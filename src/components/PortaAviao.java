package components;

class PortaAviao extends Embarcacao {
     PortaAviao(Cordenada cordenadaInicial) {
        super("PortaAvião", cordenadaInicial, 'P');
        tamanho = 5;
    }

    public PortaAviao(int linhaInicial, int colunaInicial) {
        super("PortaAvião", new Cordenada(linhaInicial, colunaInicial), 'P');
    }
}