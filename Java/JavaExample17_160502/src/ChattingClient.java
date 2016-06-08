/* 다중 채팅 프로그램 */

/**
 * JDK 1.4 -> JDK 1.7 porting 
 * 16.05.02
 *  -  
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

class ChattingClient extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Thread listenThread;
	Socket socket;
	BufferedReader reader;
	BufferedWriter writer;

	String server_msg;
	String client_msg;
	String name;

	TextArea ta;
	TextField tf;
	List list;
	Button b;
	Panel p1;
	Panel p2;

	// 생성자
	public ChattingClient(String userName, String HostIP, String HostPort) throws Exception {

		super("[" + userName + "] Cilent Window");
		this.name = userName;

		p1 = new Panel();
		p2 = new Panel();

		ta = new TextArea();
		tf = new TextField(40);

		tf.addActionListener(this);

		list = new List();
		b = new Button("Exit");

		p1.setLayout(new GridLayout(1, 2));

		p1.add(ta);
		p1.add(list);
		p2.add(tf);
		p2.add(b);

		add(p1, "Center");
		add(p2, "South");

		name = userName;

		InetAddress realHost = InetAddress.getByName(HostIP);
		int realPort = Integer.parseInt(HostPort);

		socket = new Socket(realHost, realPort);

		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		sendMessage("001" + userName + "\n");

		// 창닫기 이벤트 핸들러 시작
		addWindowListener(new WindowAdapter() {
			@Override // JDK 1.4 에서는 이 표현이 빠져야한다.
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});

		// Exit 버튼의 창닫기
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

	}

	// 메시지를 감지하는 메소드
	public void listenMessage() {
		listenThread = new Thread() {
			@Override
			public void run() {
				try {
					while ((server_msg = reader.readLine()) != null) {
						System.out.println(server_msg);
						if (server_msg.startsWith("001")) {
							list.removeAll();
							StringTokenizer st = new StringTokenizer(server_msg.substring(3), "|");
							while (st.hasMoreTokens())
								list.add((String) st.nextToken()); // while(in)
						} else if (server_msg.startsWith("002")) {
							ta.append(server_msg.substring(3) + "\n");
						} // if
					} // while(out)
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					closeAll();
				} // try()
			} // run()
		};

		listenThread.setDaemon(true);

		listenThread.start();

	}

	// Stream/socket Close 메소드

	public void closeAll() {
		try {
			reader.close();
			writer.close();
			socket.close();
			System.exit(0);
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}

	}

	// 메시지 전송 메소드
	public void sendMessage(String msg) {

		try {
			writer.write(msg + " \n");
			writer.flush();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}

	}

	// 액션이 발생하면 불려지는 핸들러
	public void actionPerformed(ActionEvent ae) {

		sendMessage("002[" + name + "]" + tf.getText());

		tf.setText("");

	}

	// Main 메소드
	public static void main(String args[]) {
		ChattingClient cl = null;
		System.out.println(args[0] + ":" + args[1] + ":" + args[2]);
		try {
			cl = new ChattingClient(args[0], args[1], args[2]);
			cl.setBounds(200, 200, 400, 400); // 사각형 영역의 경계를 크기만큼 지정함
			cl.setVisible(true);
			cl.listenMessage();
		} catch (Exception e) {
			cl.closeAll();
		}
	} // main
}