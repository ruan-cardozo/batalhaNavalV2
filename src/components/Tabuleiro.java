package components;

import java.util.LinkedList;

import static java.lang.System.out;

public class Tabuleiro {
	public static final char ACERTOU = 'X';
	public static final char NAO_ACERTOU = 'A';
	private char[][] matriz;

	private boolean[][] matrizJogadas;
	private int tamanho;
	private Cordenada cordenada;
	private LinkedList<Embarcacao> embarcacoes = new LinkedList<Embarcacao>();

	public Tabuleiro(int tamanho) {
		this.matriz = new char[tamanho][tamanho];
		this.matrizJogadas = new boolean[tamanho][tamanho];
		this.tamanho = tamanho;
	}

	public void adicionarEmbarcacao(Embarcacao embarcacao) {
		char caracter = embarcacao.getCaracter();
		int horizontal = 0;
		int vertical = 0;
		out.println("DIRECAO " + embarcacao.getDirecao());
		if (embarcacao.getDirecao() == 'H') {
			horizontal = 1;
		} else {
			vertical = 1;
		}

		int tamanho = embarcacao.getTamanho(embarcacao.getTipo());
		for (int i = 0; i < tamanho; i++) {
			int linhaInicial = embarcacao.getCordenada().getLinha();
			int colunaInicial = embarcacao.getCordenada().getColuna();
			matriz[linhaInicial + (i * vertical)][colunaInicial + (i * horizontal)] = caracter;
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

 /*   public void posicaoValida(linha, coluna) {
        int tamanhoMatriz = matriz.length;

        if (linha < 0 || linha >= tamanhoMatriz) {
            throw new IllegalArgumentException("Jogada inválida, linha fora do tabuleiro");
        }
    }*/

	public char verificarJogada(Cordenada cordenada) {

		if(matrizJogadas[cordenada.getLinha()][cordenada.getColuna()]) {
			System.out.println("Jogada já realizada ->"+ " " + "Linha: " + cordenada.getLinha() + " " +"" + "Coluna: "+ cordenada.getColuna());
			return NAO_ACERTOU;
		}
		matrizJogadas[cordenada.getLinha()][cordenada.getColuna()] = true;

		char acertou = NAO_ACERTOU;
		for (Embarcacao embarcacao : embarcacoes) {
			if(embarcacao.foiAcertada(cordenada)) {
				System.out.println("Acertou um navio!");
				acertou = ACERTOU;
				break; // para o loop
			} /*else {
				System.out.println("Não acertou nenhum navio!");
			}*/ //bug de toda vez que acertar alguma coisa ele vai printar isso independente de ter acertado ou não
		}
		posicaoJogada(cordenada, acertou);
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
			if (embarcacao.estaDestruido()) {
				numeroEmbarcacoesDestruidas++;
			}
		}
		return numeroEmbarcacoes == numeroEmbarcacoesDestruidas;

	}

	public char posicaoAtacada(int linha, int coluna) {
		return matriz[linha][coluna];
	}

}