package components;

class PortaAviao extends Embarcacao {
	PortaAviao(Cordenada cordenadaInicial) {
		super("PortaAvião", cordenadaInicial, 'P');
		tamanho = 5;
	}
}