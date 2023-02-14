package simpleChatting2.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import lombok.Getter;
import simpleChatting2.dto.JoinReqDto;
import simpleChatting2.dto.MessageReqDto;
import simpleChatting2.dto.RequestDto;

@Getter
public class ChattingClient extends JFrame {
	
	private static ChattingClient instance;
	
	public static ChattingClient getinstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		return instance;
	}
	
	private Socket socket;
	private Gson gson;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JScrollPane userListScroll;
	private JTextField messageInput;
	private JList<String> userList;
	private DefaultListModel<String> userListModel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = ChattingClient.getinstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private ChattingClient() {
		
		gson = new Gson();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(417, 10, 116, 29);
		contentPane.add(ipInput);
		ipInput.setColumns(10);
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				
				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());
				
				try {
					socket = new Socket(ip, port);
					
					JOptionPane.showMessageDialog(null,
							socket.getInetAddress() + "서버 접속",
							"접속성공!", 
							JOptionPane.INFORMATION_MESSAGE);
//					연결된 후 버튼 비활성화 
					connectButton.setEnabled(false);		
					connectButton.removeMouseListener(this);
					
					ClientRecive clientRecive = new ClientRecive(socket);
					clientRecive.start();
					
					username = JOptionPane.showInputDialog(null,
							"사용자 이름을 입력해 주세요.",
							"이름입력",
							JOptionPane.INFORMATION_MESSAGE);
					
					JoinReqDto joinReqDto = new JoinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);
					
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson);
					
					
				} catch (ConnectException e1) {
					
					JOptionPane.showMessageDialog(null,
							"서버 접속 실패",
							"접속실패!", 
							JOptionPane.ERROR_MESSAGE);
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		connectButton.setBounds(580, 10, 63, 29);
		contentPane.add(connectButton);
		
		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(535, 10, 43, 29);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 396, 375);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		userListScroll = new JScrollPane();
		userListScroll.setBounds(417, 49, 226, 336);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList<String>(userListModel);
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 395, 547, 47);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMessage();
			}
		});
		
		sendButton.setBounds(562, 395, 81, 47);
		contentPane.add(sendButton);
	}
	
	
	private void sendRequest(String resource, String body) {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			RequestDto requestDto = new RequestDto(resource, body);
			
			out.println(gson.toJson(requestDto));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private void sendMessage() {
			
		if(!messageInput.getText().isBlank()) {
			
			String toUser = userList.getSelectedIndex() == 0 ? "all" : userList.getSelectedValue();
					
			MessageReqDto messageReqDto = 
			new MessageReqDto(toUser, username, messageInput.getText());
					
			sendRequest("sendMessage", gson.toJson(messageReqDto));
			messageInput.setText("");	
				
		}
	}
	
}
