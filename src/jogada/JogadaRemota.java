package jogada;

import components.Cordenada;
import Server.Server;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
