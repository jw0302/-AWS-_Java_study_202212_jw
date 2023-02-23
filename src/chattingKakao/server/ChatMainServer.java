package chattingKakao.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import chattingKakao.Dto.JoinReqDto;
import chattingKakao.Dto.JoinRespDto;
import chattingKakao.Dto.MessageReqDto;
import chattingKakao.Dto.MessageRespDto;
import chattingKakao.Dto.RequestDto;
import chattingKakao.Dto.ResponseDto;
import lombok.Data;

@Data
class ConnectedSocket extends Thread {
	
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	
	private String username;
	
	public ConnectedSocket(Socket socket) throws IOException {
		this.socket = socket;
		gson = new Gson();
		socketList.add(this);
		outputStream = socket.getOutputStream();
	}
	
	
	@Override
	public void run() {
		try {
			
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			while(true) {
				
				String request = in.readLine();
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);
				
				switch(requestDto.getResource()) {
					case "create" :
						
//						JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
//						username = joinReqDto.getUsername();
//						List<String> connectedUsers = new ArrayList<>();
//						
//						for(ConnectedSocket connectedSocket : socketList) {
//							connectedUsers.add(connectedSocket.getUsername());
//						}
//						
//						sendRoomList();
//						addRoomToList(username);
//						
//						JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
//						sendToUser(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
//						break;
						
						JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
					    username = joinReqDto.getUsername();
					    List<String> connectedUsers = new ArrayList<>();
					    for (ConnectedSocket connectedSocket : socketList) {
					        if (connectedSocket.getUsername() != null) {
					            connectedUsers.add(connectedSocket.getUsername());
					        }
					    }
					    sendRoomList();
					    addRoomToList(username);
					    JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
					    sendToUser(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
					    break;
						
					case "sendMessage" :
						
						MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);
						
						if(messageReqDto.getToUser().equalsIgnoreCase("all")) {
							String message = messageReqDto.getFromUser() + messageReqDto.getMeesageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToUser(requestDto.getResource(), "ok", gson.toJson(messageRespDto));
							
						}
						
						break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	private void sendRoomList() throws IOException {
		List<String> roomList = new ArrayList<>();
		for (ConnectedSocket connectedSocket : socketList) {
			if (connectedSocket.getUsername() != null) {
				roomList.add(connectedSocket.getUsername());
			}
		}
		ResponseDto responseDto = new ResponseDto("roomList", "ok", gson.toJson(roomList));
		sendToAll(responseDto);
		
	}
	
	private void addRoomToList(String roomName) {
//		for (ConnectedSocket connectedSocket : socketList) {
//			if (connectedSocket.getUsername() != null) {
//				ResponseDto responseDto = new ResponseDto("addRoomToList", "ok", roomName);
//				try {
//					connectedSocket.getOutputStream().write(gson.toJson(responseDto).getBytes("UTF-8"));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		for (ConnectedSocket connectedSocket : socketList) {
	        if (connectedSocket.getUsername() != null) {
	            ResponseDto responseDto = new ResponseDto("roomAdd", "ok", roomName);
	            String message = gson.toJson(responseDto);
	            try {
					connectedSocket.outputStream.write(message.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }
	}
	private void sendToUser(String resource, String status, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		
		for(ConnectedSocket connectedSocket : socketList) {
			outputStream = connectedSocket.getSocket().getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			out.println(gson.toJson(responseDto));
		}
	}
	
	private void sendToAll(ResponseDto responseDto) {
//		 String responseDtoJson = gson.toJson(responseDto);
//		
//		for(ConnectedSocket connectedSocket : socketList) {
//			outputStream = connectedSocket.getSocket().getOutputStream();
//			PrintWriter out = new PrintWriter(outputStream, true);
//			
//			out.println(gson.toJson(responseDtoJson));
//		}
		
		 String message = gson.toJson(responseDto);
		    for (ConnectedSocket connectedSocket : socketList) {
		        try {
		            OutputStream outputStream = connectedSocket.socket.getOutputStream();
		            outputStream.write(message.getBytes());
		            outputStream.flush();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
	}
	
	
	
}

public class ChatMainServer {
	
//	private static final int PORT = 9090;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("==========<<< 서버 실행 >>>==========");
			
			while(true) {
				Socket socket = serverSocket.accept();
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				System.out.println("새로운 클라이언트 접속: " + socket.getInetAddress());
				
				connectedSocket.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("==========<<< 서버 종료 >>>==========");
			
		}
		
	}
	
	

}
