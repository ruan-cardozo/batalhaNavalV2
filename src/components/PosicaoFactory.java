package components;

public class PosicaoFactory {
    public static Posicao criarEmbarcacao(String tipo, int linhaInicial, int colunaInicial) {
        if (tipo.equals("PortaAvião")) {
            return new PortaAviao(linhaInicial, colunaInicial);
        } else if (tipo.equals("NavioTanque")) {
            return null;
        } else if (tipo.equals("ContraTorpedeiro")) {
            return null;
        } else if (tipo.equals("Submarino")) {
            return null;
        }

        return null;
    }
}
