package components;

class PortaAviao extends Embarcacao {
	PortaAviao(Cordenada cordenada) {
		super("PortaAvião", cordenada, 'P');
		tamanho = 5;
	}
}