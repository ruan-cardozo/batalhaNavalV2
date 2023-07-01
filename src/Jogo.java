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
			cliente.enviarJogada(jogada);

			Cordenada respostaCordenada = servidor.receberJogada();

			if (respostaCordenada != null) {
				marcarJogadaOponente(respostaCordenada);
				tabuleiroJogador.posicaoAtacada();
			}
		}
	}

	private void marcarJogadaOponente(Cordenada jogada) {
		tabuleiroOponente.marcarPosicao(jogada.getLinha(), jogada.getColuna(), 'X');
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
		JogadaLocal jogadaLocal = new JogadaLocal();
		JogadaRemota jogadaRemota = new JogadaRemota();

		String file = "C://Users//RUAND//projetos//Faculdade//batalhanaval//src//";
		System.out.println("Digite cliente ou servidor para o arquivo de configuração do jogo");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();

		game.loader(file + nome + ".csv");
		game.criarTabuleiro();

		if (nome.equalsIgnoreCase("servidor")) {
			jogadaRemota.iniciar(2021);
			game.servidor = jogadaRemota;
			game.cliente = jogadaLocal;
		} else if (nome.equalsIgnoreCase("cliente")) {
			System.out.println("Digite o IP do servidor:");
			String ip = scanner.nextLine();
			jogadaLocal.inicar(ip, 2021);
			game.servidor = jogadaRemota;
			game.cliente = jogadaLocal;
		} else {
			System.out.println("Opção inválida. Encerrando o jogo.");
			return;
		}

		game.jogar();
		game.cliente.parar();
		game.terminar();
	}
}
