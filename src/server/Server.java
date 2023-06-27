package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	private static final int PORT = 1234;

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Servidor iniciado na porta " + PORT);

			while(true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());


				ClientHandler clientHandler = new ClientHandler(clientSocket);
				clientHandler.start();

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

