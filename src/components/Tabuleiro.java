package components;

public class Tabuleiro {
    private char[][] matriz;
    private int tamanho;

    public Tabuleiro(int tamanho) {
        this.matriz = new char[tamanho][tamanho];
        this.tamanho = tamanho;
    }

    public void adicionarEmbarcacao(Posicao posicao) {
        int linhaInicial = posicao.getLinhaInicial();
        int colunaInicial = posicao.getColunaInicial();
        char caracter = posicao.getCaracter();
        int horizontal = 0;
        int vertical = 0;

        matriz[linhaInicial][colunaInicial] = caracter;

        if( posicao.getDirecao() == Direcao.HORIZONTAL) {
            horizontal = 1;
        } else {
            vertical = 1;
        }

        if (posicao instanceof PortaAviao) {
            matriz[linhaInicial + (1 * vertical) ][colunaInicial + (1 * horizontal)] = caracter;
            matriz[linhaInicial + (2 * vertical) ][colunaInicial + (2 * horizontal)] = caracter;
            matriz[linhaInicial + (3 * vertical) ][colunaInicial + (3 * horizontal)] = caracter;
            matriz[linhaInicial + (4 * vertical) ][colunaInicial + (4 * horizontal)] = caracter;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public char[][] getMatriz() {
        return this.matriz;
    }
}

