package jogada;
import components.Cordenada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Rede {

	public Cliente (String ip, int port) {
		super(ip, port);
	}

	public Cliente() {
		super();
	}

	@Override
	public void conectarNoServidor() throws IOException {
		clienteSocket = new Socket(ip, port);
		out = new PrintWriter(clienteSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
	}

	public Cordenada jogar() {
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
			Cordenada c = new Cordenada(linha, coluna);
			this.enviar(c);
			return c;
		} while (true);

	}

	private void enviar(Cordenada c) {
		// logica para enviar para o servidor
	}
}
