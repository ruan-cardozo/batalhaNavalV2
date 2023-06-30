package jogada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class Rede {
	protected Socket clienteSocket;

	protected PrintWriter out;

	protected BufferedReader in;

	protected int port;

	protected String ip;

	public Rede(int port) {
		this.port = port;
	}

	public Rede(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public abstract void conectarNoServidor() throws IOException;

	public void parar() throws IOException {
		this.in.close();
		this.out.close();
		this.clienteSocket.close();
	}

	public void enviarJogada(String mensagem) {
		out.println(mensagem);
	}

	public String recerberJogada() throws IOException {
		return in.readLine();
	}


}
