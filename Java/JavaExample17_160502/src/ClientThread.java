import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

class ClientThread extends Thread {

	Socket socket;
	MultiServer server;
	BufferedReader reader;
	BufferedWriter writer;
	String userMsg;
	String nickName;

	public ClientThread(Socket user_socket, MultiServer main_server) throws Exception {

		socket = user_socket;
		server = main_server;

		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	}

	// Thread run 메소드
	@Override
	public void run() {

		try {
			while ((userMsg = reader.readLine()) != null) {

				if (userMsg.startsWith("001")) { // Client List

					nickName = userMsg.substring(3);
					server.broadCast("002 new Client[" + nickName + "]님 입장");
					server.broadClientList();

				} else if (userMsg.startsWith("002")) { // Chatting

					server.broadCast("002 " + userMsg.substring(3));
				} else {

				} // if

			} // while

		} catch (SocketException e) { // Client Connection Exception
			// 표제를 정확히 달자.
			System.out.println("ClientThread.run.Socket:" + e);
		} catch (Exception e) {
			System.out.println("ClientThread.run.Exception:" + e);
		} finally {
			closeClient();
		}
	}

	// 메시지 전송
	public void sendMessage(String server_message) {

		try {
			System.out.println("sendMsg:" + server_message);
			writer.write(server_message + "\n");
			writer.flush();

		} catch (Exception e) {
			System.out.println("sendMessage:" + e);
		}

	}

	public void closeClient() {

		try {
			server.deleteFromServer(this);
			writer.close();
			reader.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("closeClient:" + e);
		}

	}

}