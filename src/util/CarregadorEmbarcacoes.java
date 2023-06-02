package util;

import components.Embarcacao;
import components.EmbarcacaoFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CarregadorEmbarcacoes {
    private static final Logger LOG = Logger.getAnonymousLogger();
    public static List<Embarcacao> carregarEmbarcacoes(String nomeArquivo) {
        List<Embarcacao> embarcacoes = new ArrayList<>();

        try {
            int contador = 0;
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String tipo = parts[0].trim();
                int linhaInicial = Integer.parseInt(parts[1].trim());
                int colunaInicial = Integer.parseInt(parts[2].trim());

                Embarcacao embarcacao = EmbarcacaoFactory.criarEmbarcacao(tipo, linhaInicial, colunaInicial);
                if (embarcacao != null) {
                    embarcacoes.add(embarcacao);
                    contador++;
                    LOG.info("Embarcacao adicionada " + contador);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return embarcacoes;
    }
}