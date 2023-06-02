package util;

import components.Posicao;
import components.PosicaoFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CarregadorEmbarcacoes {
    private static final Logger LOG = Logger.getAnonymousLogger();
    public static List<Posicao> carregarEmbarcacoes(String nomeArquivo) {
        List<Posicao> embarcacoes = new ArrayList<>();

        try {
            int contador = 0;
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String tipo = parts[0].trim();
                int linhaInicial = Integer.parseInt(parts[1].trim());
                int colunaInicial = Integer.parseInt(parts[2].trim());

                Posicao posicao = PosicaoFactory.criarEmbarcacao(tipo, linhaInicial, colunaInicial);
                if (posicao != null) {
                    embarcacoes.add(posicao);
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