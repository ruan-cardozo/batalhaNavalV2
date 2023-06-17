package jogada;

import components.Cordenada;

import java.util.Scanner;

public class JogadaLocal extends Jogada {
	public Cordenada solicitarJogada() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite a linha da jogada: ");
		int linha = scanner.nextInt();
		System.out.print("Digite a coluna da jogada: ");
		int coluna = scanner.nextInt();
		return new Cordenada(0, 0);
	}
}
