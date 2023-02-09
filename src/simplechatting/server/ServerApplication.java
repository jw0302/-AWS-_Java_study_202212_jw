package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;	// try안에 ServerSocket을 생성하면 그안에서만 쓸수 있는 지역변수이기 때문에 finally에서 또한번 선언을 해줘야 한다 그래서 위로 뺌
		
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("========<<< 서버 실행 >>>========");
			
			Socket socket = serverSocket.accept();	// 클라이언트의 접속을 기다리는 녀석
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			out.println("join");
			
			InputStream inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			String welcomeMessage = in.readLine();
			System.out.println(welcomeMessage);
			out.println(welcomeMessage);
			
			while(true) {
				in.readLine();
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
