import components.Posicao;
import components.Tabuleiro;
import util.CarregadorEmbarcacoes;
import view.Visualizador;
import java.util.List;
import java.util.logging.Logger;

public class Jogo {
    private static final Logger LOG = Logger.getAnonymousLogger();
    private List<Posicao> embarcacoes;
    private Tabuleiro tabuleiro = new Tabuleiro(10);


    public  void loader() {
        final String FILE = "C://Users//RUAND//projetos//Faculdade//batalhanaval//src//posicoes.csv/";
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
        while(! game.estaTerminado()) {
            game.visualizar();
            game.solicitarJogada();
            game.jogar();

        }
        game.terminar();

    }

    private void terminar() {
        // mostrar pontuação
        // mostrar quem ganhou
        // mostrar mensagem de fim de jogo

    }

    private void jogar() {
        // verificar se a jogada é válida
        // verificar se a jogada acertou alguma embarcação
        // atualizar o tabuleiro
    }

    private void solicitarJogada() {
        // digitar linha e coluna da jogada
    }

    private boolean estaTerminado() {
        // verificar se o jogo terminou
        // se todas as embarcacoes foram destruidas terminou
        return false;
    }

    private void visualizar() {
        Visualizador v = new Visualizador(tabuleiro);
        v.ver();
    }
}
