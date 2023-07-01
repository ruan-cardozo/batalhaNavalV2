package Jogada;
import components.Cordenada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class JogadaLocal /*cliente*/ extends Jogada {
	private Socket clientSocket;

	private PrintWriter out;

	private BufferedReader in;

	public void inicar(String ip, int port) throws IOException {
		clientSocket = new Socket(ip, port);
		//handler para escrita de dados
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		//handler para leitura de dados
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}

	public void parar(){
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException ex) {
			System.out.println("Erro ao fechar a conexão.");
		}
	}

	public void enviarJogada(Cordenada cordenada) {
		out.println(cordenada.getLinha() + " " + cordenada.getColuna());
	}

	public String receberJogada() throws IOException {
		String resposta = in.readLine();
		return (resposta != null) ? resposta : "";
	}

	public Cordenada solicitarJogada() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Digite a linha e a coluna da jogada.");
			System.out.println("Lembre-se que o tabuleiro é de 10x10.");
			System.out.println("Linha e coluna devem ser números entre 0 e 9.");
			System.out.println("Exemplo: Linha: 0 & Coluna:0");
			System.out.println("Digite a linha da jogada: ");
			int linha = scanner.nextInt();
			if (linha == -1) {
				try {
					throw new Exception("Jogada inválida, tente novamente.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Digite a coluna da jogada: ");
			int coluna = scanner.nextInt();
			if (coluna == -1) {
				try {
					throw new Exception("Jogada inválida, tente novamente.");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					scanner.close();
				}
			}
			return new Cordenada(linha, coluna);
		} while (true);

	}

}
