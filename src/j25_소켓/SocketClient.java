package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9090);
			System.out.println("서버에 접속 성공!");
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			
			System.out.println(reader.readLine()); 		
			// .read() 를 하게 되면 아스키코드로 가져오기 때문에 제대로 된 값이 전달 되지 않음, 한번에 읽기 위해서 .readLine()사용
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
