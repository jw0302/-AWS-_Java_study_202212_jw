package simpleChatting2.server;

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

import lombok.Data;
import simpleChatting2.dto.JoinReqDto;
import simpleChatting2.dto.JoinRespDto;
import simpleChatting2.dto.MessageReqDto;
import simpleChatting2.dto.MessageRespDto;
import simpleChatting2.dto.RequestDto;
import simpleChatting2.dto.ResponseDto;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		socketList.add(this);
	}
	
	
	@Override
	public void run() {
		try {		
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			while(true) {
				String request = in.readLine(); // requestDto(JSON)
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);
				
				switch(requestDto.getResource()) {
					case "join" : 
						
						JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
						username = joinReqDto.getUsername();
						List<String> connectedUsers = new ArrayList<>();
						
						for(ConnectedSocket connectedSocket : socketList) {
							connectedUsers.add(connectedSocket.getUsername());
						}
						
						JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
						sendToAll(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
						break;
					case "sendMessage" :
						
						MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);
						
						if(messageReqDto.getToUser().equalsIgnoreCase("all")) {
							String message = messageReqDto.getFromUser() + "[전체]: " + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToAll(requestDto.getResource(), "ok", gson.toJson(messageRespDto));
						} else {
							String message = messageReqDto.getFromUser() + "[" + messageReqDto.getToUser() + "]: " + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToUser(requestDto.getResource(), "ok", gson.toJson(messageRespDto), messageReqDto.getToUser());
						}
						
						break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	전체에게 메세지 보낼 수 있는 메소드
	private void sendToAll(String resource, String status, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		
		// 다른 접속자에게 메세지 보내게 하는 코드
		for(ConnectedSocket connectedSocket : socketList) {
			outputStream = connectedSocket.getSocket().getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			out.println(gson.toJson(responseDto));
		}
	}
	
//	특정유저에게만 메세지 보낼수 있는 메소드
	private void sendToUser(String resource, String status, String body, String toUser) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		
		for(ConnectedSocket connectedSocket : socketList) {
			// 상대 지정해서 메세지 보냈을때 보낸 문구가 내 메세지창에도 뜨게 하는 if문
			if(connectedSocket.getUsername().equals(toUser) || connectedSocket.getUsername().equals(username)) {
				
				outputStream = connectedSocket.getSocket().getOutputStream();
				PrintWriter out = new PrintWriter(outputStream, true);
				
				out.println(gson.toJson(responseDto));
			}
		}
	}
	
}

public class ServerApplication {
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;	// try안에 ServerSocket을 생성하면 그안에서만 쓸수 있는 지역변수이기 때문에 finally에서 또한번 선언을 해줘야 한다 그래서 위로 뺌
		
		try {
//			서버실행 
			serverSocket = new ServerSocket(9090);
			System.out.println("========<<< 서버 실행 >>>========");
			
//          실행된 상태에서 접속 대기중
			while(true) {
				Socket socket = serverSocket.accept();	// 클라이언트의 접속을 기다리는 녀석
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				
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
			
			System.out.println("========<<< 서버 종료 >>>========");
			
		}
	}

}
