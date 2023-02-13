package simpleChatting2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import simpleChatting2.dto.JoinRespDto;
import simpleChatting2.dto.MessageRespDto;
import simpleChatting2.dto.ResponseDto;

@RequiredArgsConstructor
public class ClientRecive extends Thread {
	
	private final Socket socket;
	private InputStream inputStream;
	private Gson gson;
	
	
	@Override
	public void run() {
		try {
			gson = new Gson();
			
			inputStream =socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			while(true) {
				String request = in.readLine();
				ResponseDto responseDto = gson.fromJson(request, ResponseDto.class);
				
				switch(responseDto.getResource()) {
					case "join" :
						JoinRespDto joinRespDto = gson.fromJson(responseDto.getBody(), JoinRespDto.class);
						ChattingClient.getinstance().getContentView().append(joinRespDto.getWelcomeMessage() + "\n");
						ChattingClient.getinstance().getUserListModel().clear();
						ChattingClient.getinstance().getUserListModel().addAll(joinRespDto.getConnectedUsers());
						
						break;
					case "sendMessage" :
						MessageRespDto messageRespDto = gson.fromJson(responseDto.getBody(), MessageRespDto.class);
						ChattingClient.getinstance().getContentView().append(messageRespDto.getMessageValue() + "\n");
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
