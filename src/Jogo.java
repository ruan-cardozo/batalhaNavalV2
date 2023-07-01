import components.Embarcacao;
import components.Tabuleiro;
import components.Cordenada;
import Jogada.Jogada;
import Jogada.JogadaLocal;
import Jogada.JogadaRemota;
import util.CarregadorEmbarcacoes;
import view.Visualizador;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	private List<Embarcacao> embarcacoes;
	private Tabuleiro tabuleiroJogador = new Tabuleiro(10);
	private Tabuleiro tabuleiroOponente = new Tabuleiro(10);

	private JogadaRemota servidor;

	private JogadaLocal cliente;

	public void loader(String file) {
		this.guardarEmbarcacoes(CarregadorEmbarcacoes.carregar(file));
	}

	public void loaderUsuario() {
		this.guardarEmbarcacoes(CarregadorEmbarcacoes.loaderUsuario());
	}

	private void guardarEmbarcacoes(List<Embarcacao> carregar) {
		this.embarcacoes = carregar;
	}

	private void criarTabuleiro() {
		for (Embarcacao posicao : embarcacoes) {
			tabuleiroJogador.adicionarEmbarcacao(posicao);
		}
	}

	private void terminar() {
		visualizar();
		boolean todasEmbarcacoesDestruidas = tabuleiroJogador.todasEmbarcacoesDestruidas();
		if (todasEmbarcacoesDestruidas) {
			System.out.println("Você ganhou!");
		} else {
			System.out.println("Você perdeu!");
		}
		System.out.println("Fim de jogo!");
	}


	private void jogar() throws IOException {
		while (!estaTerminado()) {
			visualizar();

			Cordenada jogada = solicitarJogada(cliente);
			servidor.enviarJogada(jogada);

			String resposta = servidor.receberJogada();
			Cordenada respostaCordenada = converterResposta(resposta);

			if (respostaCordenada != null) {
				marcarJogadaOponente(respostaCordenada);
				posicaoAtacada(respostaCordenada.getLinha(), respostaCordenada.getColuna());
			}
		}
	}

	private void marcarJogadaOponente(Cordenada jogada) {
		tabuleiroOponente.marcarPosicao(jogada.getLinha(), jogada.getColuna(), 'X');
	}

	private Cordenada converterResposta(String resposta) {
		if (resposta == null || resposta.isEmpty()) {
			return null;
		}

		String[] split = resposta.split(",");
		if (split.length != 2) {
			return null;
		}

		try {
			int linha = Integer.parseInt(split[0]);
			int coluna = Integer.parseInt(split[1]);
			return new Cordenada(linha, coluna);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public void posicaoAtacada(int linha, int coluna) {
		if (tabuleiroOponente.posicaoAtacada(linha, coluna) == 'X' || tabuleiroOponente.posicaoAtacada(linha, coluna) == 'A') {
			System.out.println("Você já atacou essa posição");
		} else {
			tabuleiroOponente.verificarJogada(new Cordenada(linha, coluna));
		}
	}

	private Cordenada solicitarJogada(Jogada jogada) {
		return jogada.solicitarJogada();
	}

	private boolean estaTerminado() {
		return tabuleiroJogador.todasEmbarcacoesDestruidas();
	}

	private void visualizar() {
		Visualizador visualizador = new Visualizador(tabuleiroJogador, tabuleiroOponente);
		visualizador.ver();
	}

	public static void main(String[] args) throws IOException {

		Jogo game = new Jogo();
		game.servidor = new JogadaRemota();
		game.cliente = new JogadaLocal();
		game.servidor.inicar(2020);
		game.cliente.inicar("127.0.0.1", 2020);

		String file = "C://Users//RUAND//projetos//Faculdade//batalhanaval//src//";
		System.out.println("Digite cliente ou servidor para o arquivo de configuração do jogo");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();


		//game.loader(file + nome + ".csv");
		game.loaderUsuario();
		game.criarTabuleiro();
		game.jogar();
		game.terminar();
	}
}
