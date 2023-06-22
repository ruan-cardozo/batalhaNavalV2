import components.Embarcacao;
import components.Tabuleiro;
import components.Cordenada;
import jogada.Jogada;
import jogada.JogadaLocal;
import jogada.JogadaRemota;
import util.CarregadorEmbarcacoes;
import view.Visualizador;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Jogo {
	private static final boolean LOCAL = true;
	private static final Logger LOG = Logger.getAnonymousLogger();
	private List<Embarcacao> embarcacoes;
	private Tabuleiro tabuleiro = new Tabuleiro(10);

	public void loader() {
		final String FILE = "C://Users//RUAND//projetos//Faculdade//batalhanaval//src//posicoes.csv";
		LOG.info("Iniciando leitura do arquivo");
		this.guardarEmbarcacoe( CarregadorEmbarcacoes.carregar(FILE) );
		LOG.info("Finalizando leitura arquivo");
	}

	private void guardarEmbarcacoe(List<Embarcacao> carregar) {
		this.embarcacoes = carregar;
	}
		private void criarTabuleiro() {
		for (Embarcacao posicao : embarcacoes) {
			tabuleiro.adicionarEmbarcacao(posicao);
			LOG.info(posicao.getTipo());
		}
	}

	private void terminar() {
		visualizar();
		boolean todasEmbarcacoesDestruidas = tabuleiro.todasEmbarcacoesDestruidas();
		if (todasEmbarcacoesDestruidas) {
			System.out.println("Você ganhou!");
		} else {
			System.out.println("Você perdeu!");
		}
		System.out.println("Fim de jogo!");
	}


	private void jogar() {
		while (! this.estaTerminado()) {
			this.visualizar();
			tabuleiro.verificarJogada(solicitarJogada());

		}
	}

	public void posicaoAtacada(int linha, int coluna) {
		if(tabuleiro.posicaoAtacada(linha, coluna) == 'X' || tabuleiro.posicaoAtacada(linha, coluna) == 'A') {
			System.out.println("Você já atacou essa posição");
		} else {
			System.out.println("Você acertou um barco");
		}
	}

	private Cordenada solicitarJogada() {
		Jogada jogada ;
		if(LOCAL) {
			jogada = new JogadaLocal();
		} else {
			jogada = new JogadaRemota();
		}
		return jogada.solicitarJogada();

	}

	private boolean estaTerminado() {
		return tabuleiro.todasEmbarcacoesDestruidas();
	}

	private void visualizar() {
		Visualizador visualizador = new Visualizador(tabuleiro);
		visualizador.ver();
	}

	public static void main(String[] args) {

		Jogo game = new Jogo();
		game.loader();
		game.criarTabuleiro();
		game.jogar();
		game.terminar();
	}
}