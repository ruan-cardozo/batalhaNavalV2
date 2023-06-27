package jogada;

import components.Cordenada;

import java.io.BufferedReader;
import java.net.Socket;

public class JogadaRemota extends Jogada {
	private Socket socket;
	private BufferedReader in;

	public JogadaRemota(Socket clientSocket) {
		super();
	}

	public Cordenada solicitarJogada() {
		return  new Cordenada(0,0); // substituir por uma jogada remota
	}
}
