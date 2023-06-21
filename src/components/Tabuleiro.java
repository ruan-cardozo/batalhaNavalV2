package components;

import java.util.LinkedList;

public class Tabuleiro {
    public static final char ACERTOU = 'X';
    public static final char NAO_ACERTOU = 'A';
    private char[][] matriz;
    private int tamanho;
    private Cordenada cordenada;
    private LinkedList<Embarcacao> embarcacoes = new LinkedList<Embarcacao>();

    public Tabuleiro(int tamanho) {
        this.matriz = new char[tamanho][tamanho];
        this.tamanho = tamanho;
    }

    public void adicionarEmbarcacao(Embarcacao embarcacao){
        char caracter = embarcacao.getCaracter();
        int horizontal = 0;
        int vertical = 0;
        System.out.println("DIRECAO "  + embarcacao.getDirecao());
        if(embarcacao.getDirecao() == 'H') {
            horizontal = 1;
        } else {
            vertical = 1;
        }

        int tamanho = embarcacao.getTamanho();
        for (int i = 0; i < tamanho; i++) {
            int linhaInicial = embarcacao.getCordenada().getLinha();
            int colunaInicial = embarcacao.getCordenada().getColuna();
            matriz[linhaInicial + (i * vertical) ][colunaInicial + (i * horizontal)] = caracter;
            embarcacao.adicionarCordenada(new Cordenada(linhaInicial + (i * vertical), colunaInicial + (i * horizontal)));
        }
        embarcacoes.add(embarcacao);
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public char[][] getMatriz() {
        return this.matriz;
        }

    public int getPontuacao() {
        int numeroPontos = 0;
        for (Embarcacao embarcacao : embarcacoes) {
             numeroPontos += embarcacao.getPontuacao();
        }

        return numeroPontos;

    }

    public char verificarJogada(Cordenada cordenada) {
        char acertou = NAO_ACERTOU;
        for (Embarcacao embarcacao : embarcacoes) {
            if(embarcacao.foiAcertada(cordenada)) {
                acertou = ACERTOU;
                break; // para o loop
            }
        }
        posicaoJogada(cordenada,acertou);
        return acertou;
    }

    private void posicaoJogada(Cordenada cordenada, char resultado) {
        matriz[cordenada.getLinha()][cordenada.getColuna()] = resultado; // marca a jogada na matriz
        // copilot nao colocou o ; na linha de cima isso fui eu
    }

    public void setPosicao(Cordenada cordenada) {
        this.cordenada = cordenada;
    }

    public boolean todasEmbarcacoesDestruidas() {
        int numeroEmbarcacoes = embarcacoes.size();
        int numeroEmbarcacoesDestruidas = 0;
        for (Embarcacao embarcacao : embarcacoes) {
            if(embarcacao.foiDestruida()) {
                numeroEmbarcacoesDestruidas++;
            }
        }
        return numeroEmbarcacoes == numeroEmbarcacoesDestruidas;

    }

}