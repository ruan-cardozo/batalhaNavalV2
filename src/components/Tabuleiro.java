package components;

public class Tabuleiro {
    private char[][] matriz;

    public Tabuleiro(int tamanho) {
        matriz = new char[tamanho][tamanho];
    }

    public void adicionarEmbarcacao(Embarcacao embarcacao) {
        int linhaInicial = embarcacao.getLinhaInicial();
        int colunaInicial = embarcacao.getColunaInicial();
        char caracter = embarcacao.getCaracter();

        matriz[linhaInicial][colunaInicial] = caracter;

        if (embarcacao instanceof PortaAviao) {
            matriz[linhaInicial + 1][colunaInicial] = caracter;
            matriz[linhaInicial + 2][colunaInicial] = caracter;
            matriz[linhaInicial + 3][colunaInicial] = caracter;
            matriz[linhaInicial + 4][colunaInicial] = caracter;
        }
    }

}

