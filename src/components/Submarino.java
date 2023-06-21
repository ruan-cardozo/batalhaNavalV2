package components;

class Submarino extends Embarcacao {
	public Submarino(Cordenada cordenada) {
		super("Submarino", cordenada, 'S');
		tamanho = 1;
	}
}