package view;

import components.Tabuleiro;

public class Visualizador {
	private final Tabuleiro tabuleiroJogador;
	private final Tabuleiro tabuleiroOponente;

	public Visualizador(Tabuleiro tabuleiroJogador, Tabuleiro tabuleiroOponente) {
		this.tabuleiroJogador = tabuleiroJogador;
		this.tabuleiroOponente = tabuleiroOponente;
	}

	public void ver() {
		int tamanho = tabuleiroJogador.getTamanho();
		char[][] matrizJogador = tabuleiroJogador.getMatriz();
		char[][] matrizOponente = tabuleiroOponente.getMatriz();

		System.out.println("Tabuleiro do Jogador             Tabuleiro do Oponente");
		System.out.println();

		System.out.print("   ");
		for (int i = 0; i < tamanho; i++) {
			System.out.print(i + " ");
		}
		System.out.print("      ");
		for (int i = 0; i < tamanho; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int linha = 0; linha < tamanho; linha++) {
			System.out.print(linha + "  ");
			for (int coluna = 0; coluna < tamanho; coluna++) {
				char caracterJogador = matrizJogador[linha][coluna];
				char caracterOponente = matrizOponente[linha][coluna];

				if (caracterJogador == 0) {
					System.out.print("░ ");
				} else {
					System.out.print(caracterJogador + " ");
				}
			}
			System.out.print("    ");

			System.out.print(linha + "  ");
			for (int coluna = 0; coluna < tamanho; coluna++) {
				System.out.print("░ ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
