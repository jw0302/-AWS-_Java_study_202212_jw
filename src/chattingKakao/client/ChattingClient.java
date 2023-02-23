package chattingKakao.client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.Gson;

import chattingKakao.Dto.JoinReqDto;
import chattingKakao.Dto.MessageReqDto;
import chattingKakao.Dto.RequestDto;
import lombok.Getter;



@Getter
public class ChattingClient extends JFrame {
	
	
	private static ChattingClient instance;
	
	public static ChattingClient getinstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		return instance;
	}
	
//	private static final String SERVER_HOST = "127.0.0.1";
//    private static final int SERVER_PORT = 9090;
	

	private Socket socket;
	private Gson gson;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String roomOwner;
	private String username;
	
	private CardLayout mainCard;
	private JPanel mainPanel;
	
	private JPanel loginPanel;
	private JButton lpLoginBtn;
	private JTextField lpUserNameInput;
	
	private JPanel chatListPanel;
	private JButton cpCreateBtn;
	private JList<String> cpChatList;
	private DefaultListModel<String> userListModel;
	
	private JPanel chatRoomPanel;
	private JButton rpInputSubmit;
	private JButton rpChatOutBtn;
	private JTextField rpInput;
	private JTextArea rpContentsView;
	private JLabel rpChatTitle;
	
	
	
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

	
	
	public ChattingClient() {
		
		gson = new Gson();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 800);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 204, 0));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		
		
//		==================== << LoginPanel >> ==========================
		
		
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 204, 0));
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		lpUserNameInput = new JTextField();
		lpUserNameInput.setFont(new Font("굴림", Font.PLAIN, 16));
		lpUserNameInput.setHorizontalAlignment(SwingConstants.CENTER);
		lpUserNameInput.setBounds(73, 492, 300, 45);
		loginPanel.add(lpUserNameInput);
		lpUserNameInput.setColumns(10);
		
		lpLoginBtn = new JButton("");
		lpLoginBtn.addMouseListener(new MouseAdapter() {
		
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				String ip = roomOwner;
//				int port = 9090;
				
				roomOwner = lpUserNameInput.getText();
								
				try {
					Socket socket = new Socket("localhost", 9090);
					
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					

					JOptionPane.showMessageDialog(null,
							socket.getInetAddress() + roomOwner + "서버 접속",
							"접속성공!",
							JOptionPane.INFORMATION_MESSAGE);
					
					out.println(gson.toJson(roomOwner));
					
					mainCard.show(mainPanel, "chatListPanel");
					
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
				
//				roomOwner = lpUserNameInput.getText();
//				userListModel.addElement(roomOwner);
//				mainCard.show(mainPanel, "chatListPanel");
			}
		});
		
		lpLoginBtn.setIcon(new ImageIcon(ChattingClient.class.getResource("/chattingKakao/image/login_med.png")));
		lpLoginBtn.setBounds(73, 573, 300, 45);
		lpLoginBtn.setBackground(Color.white);
		lpLoginBtn.setOpaque(false);//투명하게
		lpLoginBtn.setBorderPainted(false);
		loginPanel.add(lpLoginBtn);
		
		JLabel lpImageIcon = new JLabel("");
		lpImageIcon.setIcon(new ImageIcon(ChattingClient.class.getResource("/chattingKakao/image/kakaotalk_sharing_btn_medium_ov.png")));
		lpImageIcon.setBounds(183, 226, 68, 69);
		loginPanel.add(lpImageIcon);
		
		
		
//		==================== << ChatListPanel >> ==========================
		
		
		chatListPanel = new JPanel();
		chatListPanel.setBackground(new Color(255, 204, 0));
		mainPanel.add(chatListPanel, "chatListPanel");
		chatListPanel.setLayout(null);	
		
		JScrollPane cpChatListScroll = new JScrollPane();
		cpChatListScroll.setBounds(133, 0, 331, 761);
		chatListPanel.add(cpChatListScroll);
		
		userListModel = new DefaultListModel<>();
		cpChatList = new JList<String>(userListModel);
		cpChatList.setFont(new Font("궁서", Font.PLAIN, 18));
		
		cpChatList.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				roomOwner = lpUserNameInput.getText();
				String username = cpChatList.getSelectedValue().toString();
		        String message = roomOwner + " 님이 방을 생성하였습니다";
		        rpContentsView.setText(message);
		        
		        rpChatTitle.setText(username + " (님)의 방");
				
				mainCard.show(mainPanel, "chatRoomPanel");
			}
			
		});
		
		cpChatListScroll.setViewportView(cpChatList);
		
		JLabel cpImageIcon = new JLabel("");
		cpImageIcon.setIcon(new ImageIcon(ChattingClient.class.getResource("/chattingKakao/image/kakaotalk_sharing_btn_medium_ov.png")));
		cpImageIcon.setBounds(30, 53, 68, 69);
		chatListPanel.add(cpImageIcon);
		
		cpCreateBtn = new JButton("");
		cpCreateBtn.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				username = JOptionPane.showInputDialog(null,
//						"방의 제목을 입력해주시오.",
//						"방 생성",
//						JOptionPane.INFORMATION_MESSAGE);
//				
//				try {
//					
//					ClientRecive clientRecive = new ClientRecive(socket);
//					clientRecive.start();
//					
//					JoinReqDto joinReqDto = new JoinReqDto(username);
//					String joinReqDtoJson = gson.toJson(joinReqDto);
//					RequestDto requestDto = new RequestDto("create", joinReqDtoJson);
//					String requestDtoJson = gson.toJson(requestDto);
//					
//					outputStream = socket.getOutputStream();
//					PrintWriter out = new PrintWriter(outputStream, true);
//					out.println(requestDtoJson);
//					
//					userListModel.addElement("제목: " + username);
//					rpChatTitle.setText(username + " (님)의 방");
//					String message = roomOwner + " 님이 방을 생성하였습니다";
//					rpContentsView.setText(message);
//					username = cpCreateBtn.getText();
//					mainCard.show(mainPanel, "chatRoomPanel");
//					
//				} catch (UnknownHostException e1) {
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
					
				username = JOptionPane.showInputDialog(null,
							"방의 제목을 입력해주시오.",
							"방 생성",
							JOptionPane.INFORMATION_MESSAGE);
				
				if (username != null && !username.isEmpty()) {
					try {
						
						JoinReqDto joinReqDto = new JoinReqDto(username);
						RequestDto requestDto = new RequestDto("create", gson.toJson(joinReqDto));
						outputStream.write((gson.toJson(requestDto) + "\n").getBytes());
						outputStream.flush();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				
				userListModel.addElement("제목: " + username);
				rpChatTitle.setText(username + " (님)의 방");
				String message = roomOwner + " 님이 방을 생성하였습니다";
				rpContentsView.setText(message);
				username = cpCreateBtn.getText();
				mainCard.show(mainPanel, "chatRoomPanel");
					
			}
		});
		
		cpCreateBtn.setIcon(new ImageIcon(ChattingClient.class.getResource("/chattingKakao/image/plus-round_icon-icons.com_50065.png")));
		cpCreateBtn.setBounds(30, 148, 79, 54);
		cpCreateBtn.setBackground(Color.white);
		cpCreateBtn.setOpaque(false);//투명하게
		cpCreateBtn.setBorderPainted(false);
		chatListPanel.add(cpCreateBtn);
		
		
		
//		==================== << ChatRoomPanel >> ==========================		
		
			
		chatRoomPanel = new JPanel();
		chatRoomPanel.setBackground(new Color(255, 204, 0));
		mainPanel.add(chatRoomPanel, "chatRoomPanel");
		chatRoomPanel.setLayout(null);
		
		JScrollPane rpContentsScroll = new JScrollPane();
		rpContentsScroll.setBounds(0, 103, 464, 562);
		chatRoomPanel.add(rpContentsScroll);
		
		rpContentsView = new JTextArea();
		rpContentsView.setFont(new Font("굴림", Font.PLAIN, 15));
		rpContentsScroll.setViewportView(rpContentsView);
		
		JScrollPane rpInputScroll = new JScrollPane();
		rpInputScroll.setBounds(0, 663, 380, 98);
		chatRoomPanel.add(rpInputScroll);
		
		rpInput = new JTextField();
		rpInput.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		rpInputScroll.setViewportView(rpInput);
		rpInput.setColumns(10);
		
		rpChatOutBtn = new JButton("");
		rpChatOutBtn.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				mainCard.show(mainPanel, "chatListPanel");
				rpContentsView.setText("");
				rpInput.setText("");
				
			}
		});
		
		rpChatOutBtn.setIcon(new ImageIcon(ChattingClient.class.getResource("/chattingKakao/image/quit_icon_149882.png")));
		rpChatOutBtn.setBounds(359, 29, 65, 46);
		rpChatOutBtn.setBackground(Color.white);
		rpChatOutBtn.setOpaque(false);//투명하게
		rpChatOutBtn.setBorderPainted(false);
		chatRoomPanel.add(rpChatOutBtn);
		
		JLabel rpImageIcon = new JLabel("");
		rpImageIcon.setIcon(new ImageIcon(ChattingClient.class.getResource("/chattingKakao/image/kakaotalk_sharing_btn_medium_ov.png")));
		rpImageIcon.setBounds(30, 10, 68, 69);
		chatRoomPanel.add(rpImageIcon);
		
		rpChatTitle = new JLabel("");
		rpChatTitle.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		rpChatTitle.setBounds(121, 29, 226, 46);
		chatRoomPanel.add(rpChatTitle);
		
		rpInputSubmit = new JButton("");
		rpInputSubmit.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sendMessage();
				
//				String message = rpInput.getText();
//				
//			    rpContentsView.append("\n" + roomOwner + ": " + message);
//			    rpInput.setText("");
				
			}
		});
		
		rpInputSubmit.setIcon(new ImageIcon(ChattingClient.class.getResource("/chattingKakao/image/mail_send_icon_180871.png")));
		rpInputSubmit.setBounds(379, 663, 85, 98);
		chatRoomPanel.add(rpInputSubmit);
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
		
		if(!rpInput.getText().isBlank()) {
			
			String toUser = cpChatList.getSelectedIndex() == 0 ? "all" : cpChatList.getSelectedValue();
					
			MessageReqDto messageReqDto = 
			new MessageReqDto(toUser, username, rpInput.getText());
					
			sendRequest("sendMessage", gson.toJson(messageReqDto));
			rpInput.setText("");	
				
		}
	}
	
}
