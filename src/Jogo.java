import components.Posicao;
import components.Tabuleiro;
import util.CarregadorEmbarcacoes;
import view.Visualizador;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Jogo {
    private static final Logger LOG = Logger.getAnonymousLogger();
    private List<Posicao> embarcacoes;
    private Tabuleiro tabuleiro = new Tabuleiro(10);

    public void loader() {
        final String FILE = "C://Users//RUAND//projetos//Faculdade//batalhanaval//src//posicoes.csv";
        LOG.info("Iniciando leitura do arquivo");
        embarcacoes = CarregadorEmbarcacoes.carregar(FILE);
        LOG.info("Finalizando leitura arquivo");
    }

    private void criarTabuleiro() {
        for (Posicao posicao : embarcacoes) {
            tabuleiro.adicionarEmbarcacao(posicao);
            LOG.info(posicao.getTipo());
        }
    }

    public static void main(String[] args) {
        Jogo game = new Jogo();
        game.loader();
        game.criarTabuleiro();
        while (!game.estaTerminado()) {
            game.visualizar();
            game.solicitarJogada();
        }
        game.terminar();
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

    private void jogar(int linha, int coluna) {
        if (linha < 0 || linha >= tabuleiro.getTamanho() || coluna < 0 || coluna >= tabuleiro.getTamanho()) {
            System.out.println("Jogada inválida, tente novamente.");
            return;
        }

        char resultado = tabuleiro.verificarJogada(linha, coluna);
        if (resultado == 'S') {
            System.out.println("Você acertou um navio!");
        } else {
            System.out.println("Você errou, não tem embarcação nessa posição :(");
        }
        tabuleiro.setPosicao(linha, coluna, resultado);

        visualizar();
    }

    private void solicitarJogada() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a linha da jogada: ");
        int linha = scanner.nextInt();

        System.out.print("Digite a coluna da jogada: ");
        int coluna = scanner.nextInt();

        jogar(linha, coluna);
    }

    private boolean estaTerminado() {
        return tabuleiro.todasEmbarcacoesDestruidas();
    }

    private void visualizar() {
        Visualizador visualizador = new Visualizador(tabuleiro);
        visualizador.ver();
    }
}
