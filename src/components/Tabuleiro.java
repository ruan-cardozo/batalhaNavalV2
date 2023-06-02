package components;

public class Tabuleiro {
    private char[][] matriz;

    public Tabuleiro(int tamanho) {
        matriz = new char[tamanho][tamanho];
    }

    public void adicionarEmbarcacao(Posicao posicao) {
        int linhaInicial = posicao.getLinhaInicial();
        int colunaInicial = posicao.getColunaInicial();
        char caracter = posicao.getCaracter();

        matriz[linhaInicial][colunaInicial] = caracter;

        if (posicao instanceof PortaAviao) {
            matriz[linhaInicial + 1][colunaInicial] = caracter;
            matriz[linhaInicial + 2][colunaInicial] = caracter;
            matriz[linhaInicial + 3][colunaInicial] = caracter;
            matriz[linhaInicial + 4][colunaInicial] = caracter;
        }
    }
}

