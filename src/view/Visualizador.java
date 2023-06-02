package view;

import components.Tabuleiro;

public class Visualizador {
    private final Tabuleiro tabuleiro;

    public Visualizador(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    public void ver() {
        int tamanho = tabuleiro.getTamanho();
        char[][] matriz = tabuleiro.getMatriz();

        for (int linha = 0; linha < tamanho; linha++) {
            for (int coluna = 0; coluna < tamanho; coluna++) {
                char caracter = matriz[linha][coluna];
                if (caracter == 0) {
                    System.out.print("-");
                } else {
                    System.out.print(caracter);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
