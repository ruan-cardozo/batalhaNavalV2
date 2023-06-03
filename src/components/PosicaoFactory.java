package components;

public class PosicaoFactory {
    public static Posicao criar(String tipo, int linhaInicial, int colunaInicial) {
        if (tipo.equals("PortaAvião")) {
            return new PortaAviao(linhaInicial, colunaInicial);
        } else if (tipo.equals("NavioTanque")) {
            return new NavioTanque(linhaInicial, colunaInicial);
        } else if (tipo.equals("ContraTorpedeiro")) {
            return new ContraTorpedeiro(linhaInicial, colunaInicial);
        } else if (tipo.equals("Submarino")) {
            return new Submarino(linhaInicial, colunaInicial);
        }

        return null;
    }
}
