import components.Embarcacao;
import components.Tabuleiro;
import util.CarregadorEmbarcacoes;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    List<Embarcacao> embarcacoes;
    private static final Logger LOG = Logger.getAnonymousLogger();

    public  void loader() {

        int countPortaAviao = 0;
        int countNavioTanque = 0;
        int countContraTorpedeiro = 0;
        int countSubmarino = 0;

        final String FILE = "C:\\Users\\glauc\\IdeaProjects\\batalhanaval\\src\\posicoes.csv";
        LOG.info("Iniciando leitura do arquivo");
        embarcacoes = CarregadorEmbarcacoes.carregarEmbarcacoes(FILE);

        Tabuleiro tabuleiro = new Tabuleiro(10);

        for (Embarcacao embarcacao : embarcacoes) {
            tabuleiro.adicionarEmbarcacao(embarcacao);
            LOG.info(embarcacao.getTipo());
        }
        LOG.info("Finalizando leitura arquivo");
    }
    public static void main(String[] args) {
        Main game = new Main();
        game.loader();
    }
}
