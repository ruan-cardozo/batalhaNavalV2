package components;

public class EmbacacaoFactory {
    public static Embarcacao criar(String tipo, Cordenada cordenada) {
        if (tipo.equals("PortaAvião")) {
            return new PortaAviao(cordenada);
        } else if (tipo.equals("NavioTanque")) {
            return new NavioTanque(cordenada);
        } else if (tipo.equals("ContraTorpedeiro")) {
            return new ContraTorpedeiro(cordenada);
        } else if (tipo.equals("Submarino")) {
            return new Submarino(cordenada);
        }

        return null;
    }
}
