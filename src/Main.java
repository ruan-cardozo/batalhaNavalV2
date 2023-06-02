import components.Posicao;
import components.Tabuleiro;
import util.CarregadorEmbarcacoes;
import view.Visualizador;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOG = Logger.getAnonymousLogger();
    private List<Posicao> embarcacoes;
    private Tabuleiro tabuleiro = new Tabuleiro(10);

    public  void loader() {
        final String FILE = "C:\\Users\\glauco.scheffel\\IdeaProjects\\batalhanaval\\src\\posicoes.csv";
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
        Main game = new Main();
        game.loader();
        game.criarTabuleiro();
        game.visualizar();

    }

    private void visualizar() {
        Visualizador v = new Visualizador(tabuleiro);
        v.ver();
    }
}
