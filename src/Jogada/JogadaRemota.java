package Jogada;

import components.Cordenada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import components.Cordenada;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

 public class JogadaRemota /*servidor*/ extends Jogada {
	private ServerSocket serverSocket;

	private Socket clientSocket;

	private PrintWriter out;

	private BufferedReader in;

	public void inicar(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	public void parar() {
		try {
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException ex) {
			System.out.println("Erro ao fechar a conexão.");
		}
	}

	public void enviarJogada(Cordenada cordenada) {
		out.println(cordenada);
	}

	public String receberJogada() throws IOException {
		return in.readLine();
	}


	public Cordenada solicitarJogada(){
		return new Cordenada(0,0);
	}
 }
