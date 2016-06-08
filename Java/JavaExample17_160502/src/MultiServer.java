
/**
 * JDK 1.4 -> JDK 1.7 porting 
 * 16.05.02
 *  - Vector clients; -> Vector<ClientThread> clients(Generic)
 *  - Enumeration clientsEn -> Iterator<ClientThread> clientsIt
 *  - Iterator Add in the Method broadCast 
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class MultiServer {

	ServerSocket sc;
	// Vector clients; // JDK 1.4
	Vector<ClientThread> clients;
	ClientThread client;
	// Enumeration clientsEn; // JDK 1.4
	Iterator<ClientThread> clientsIt;

	public static void main(String args[]) {

		MultiServer ms = null;

		try {
			ms = new MultiServer();
			ms.welcomeclients();

		} catch (Exception e) {

			System.out.println("main:" + e);

		}
	}

	public MultiServer() throws Exception {

		sc = new ServerSocket(7777);
		// clients = new Vector(); // JDK 1.4
		clients = new Vector<ClientThread>();
	}

	public void welcomeclients() throws Exception {

		while (true) {
			Socket socket = sc.accept();
			client = new ClientThread(socket, this);

			addClient(client);
			client.setDaemon(true);
			client.start();
		}
	}

	// public synchronized void addClient(Thread clientThread) {
	public synchronized void addClient(ClientThread clientThread) {
		// clinets.add(clientThread); // JDK 1.4
		clients.add(clientThread);
		System.out.println("current clients : " + clients.size());
	}

	public synchronized void broadCast(String message) {

		// Enumeration JDK 1.4
		/*
		 * clientsEn = clients.elements(); while (clientsEn.hasMoreElements()) {
		 * ((ClientThread) clientsEn.nextElement()).sendMessage(message); }
		 */

		// Iterator Add 16.05.02
		clientsIt = clients.iterator();
		while (clientsIt.hasNext()) {
			((ClientThread) clientsIt.next()).sendMessage(message);
		}
	}

	public void broadClientList() {
		/*
		 * 16.05.03 StringBuffer로 변경.
		 * String re = "";
		 * for (int i = 0; i < clients.size(); i++) 
		 * 	re += ((ClientThread) clients.get(i)).nickName + "|";
		 * re = re.substring(0, re.length() - 1);
		 * broadCast("001" + re);
		 */
		StringBuffer strBuf = new StringBuffer("");

		clientsIt = clients.iterator();

		while (clientsIt.hasNext()) {
			ClientThread ct = (ClientThread) clientsIt.next();
			strBuf.append(ct.nickName + "|");
			strBuf.append(strBuf.substring(0, strBuf.length() - 1));
		}
		broadCast("001" + strBuf);

	}

	public synchronized void deleteFromServer(ClientThread clientThread) {

		clients.remove(clientThread);
		System.out.println(clients.size() + " left in server");

	}
}