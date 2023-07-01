package Jogada;
import components.Cordenada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class JogadaLocal /*cliente*/ extends Jogada {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void iniciar(String ip, int port) throws IOException {
		clientSocket = new Socket(ip, port);
		// handler para escrita de dados
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		// handler para leitura de dados
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
		out.println(cordenada.getLinha() + "," + cordenada.getColuna());
	}

	public Cordenada receberJogada() throws IOException {
		String resposta = in.readLine();
		if (resposta != null) {
			String[] coordenadas = resposta.split(",");
			int linha = Integer.parseInt(coordenadas[0]);
			int coluna = Integer.parseInt(coordenadas[1]);
			return new Cordenada(linha, coluna);
		} else {
			return new Cordenada(0, 0); // Retornar uma coordenada inválida caso a resposta seja nula
		}
	}

	public Cordenada solicitarJogada() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("Digite a linha e a coluna da jogada.");
				System.out.println("Lembre-se que o tabuleiro é de 10x10.");
				System.out.println("Linha e coluna devem ser números entre 0 e 9.");
				System.out.println("Exemplo: Linha: 0 & Coluna:0");
				System.out.println("Digite a linha da jogada: ");
				int linha = scanner.nextInt();
				if (linha < 0 || linha > 9) {
					throw new Exception("Jogada inválida, tente novamente.");
				}
				System.out.println("Digite a coluna da jogada: ");
				int coluna = scanner.nextInt();
				if (coluna < 0 || coluna > 9) {
					throw new Exception("Jogada inválida, tente novamente.");
				}
				return new Cordenada(linha, coluna);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				scanner.nextLine(); // Limpar o buffer do scanner
			}
		} while (true);
	}


}
