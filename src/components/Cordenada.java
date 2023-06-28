package components;

import java.io.Serializable;

public class Cordenada implements Serializable {
	private int linha;
	private int coluna;
	private char caracter;

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cordenada cordenada)) {
			return false;
		}

		if (getLinha() != cordenada.getLinha()) return false;
		return getColuna() == cordenada.getColuna();
	}

	@Override
	public int hashCode() {
		int result = getLinha();
		result = 31 * result + getColuna();
		return result;
	}
}
