package Server;
import jogada.JogadaLocal;
import jogada.JogadaRemota;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler extends Thread {
	private Socket clientSocket;

	private JogadaRemota jogadaRemota;

	private JogadaLocal jogadaLocal;

	public ClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.jogadaRemota = new JogadaRemota(clientSocket);
		this.jogadaLocal = new JogadaLocal();
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			jogadaRemota = new JogadaRemota(clientSocket);
			jogadaLocal = new JogadaLocal();

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Mensagem recebida do cliente: " + inputLine);

				//fazre a jogada do cliente remoto
				jogadaRemota.solicitarJogada();

				//razer a jogada cliente local
				jogadaLocal.solicitarJogada();

				out.println("Resposta do servidor: ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
