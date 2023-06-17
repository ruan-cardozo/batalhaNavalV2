package components;
import java.io.Serializable;

public class Cordenada implements Serializable {
	private int linha;
	private int coluna;

     public Cordenada(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

}
