package view;

import components.Tabuleiro;
import components.Cordenada;

public class Visualizador {
	private final Tabuleiro tabuleiro;

	public Visualizador(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public void ver() {
		int tamanho = tabuleiro.getTamanho();
		char[][] matriz = tabuleiro.getMatriz();
//		System.out.print("\n ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
//
//		String pontuacaoText = "PLACAR " + tabuleiro.getPontuacao();
//		int espacosEsquerda = (30 - pontuacaoText.length()) / 2;
//		int espacosDireita = 30 - espacosEsquerda - pontuacaoText.length();
//		System.out.print(" ░░░░" + " ".repeat(espacosEsquerda) + pontuacaoText + " ".repeat(espacosDireita) + "  ░░░░ \n");
//		System.out.print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n\n");


		System.out.print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n\n");
		System.out.print("            0 1 2 3 4 5 6 7 8 9\n");

		int linha;
		int coluna = 0;
		for (linha = 0; linha < tamanho; linha++) {
			System.out.print("          " + linha + " ");
			for (coluna = 0; coluna < tamanho; coluna++) {
				char caracter = matriz[linha][coluna];
				if (caracter == 0) {
					System.out.print("░");
				} else {
					System.out.print(caracter);
				}
				System.out.print(" ");
			}
			System.out.println();

		}

		System.out.print("\n\n");
		System.out.print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n\n");
		System.out.println("         Jogada (linha,coluna) -> \n");
	}
}