package components;
public abstract class Embarcacao {
    protected String tipo;
    protected int linhaInicial;
    protected int colunaInicial;
    protected char caracter;

     Embarcacao(String tipo, int linhaInicial, int colunaInicial, char caracter) {
        this.tipo = tipo;
        this.linhaInicial = linhaInicial;
        this.colunaInicial = colunaInicial;
        this.caracter = caracter;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLinhaInicial() {
        return linhaInicial;
    }

    public int getColunaInicial() {
        return colunaInicial;
    }

    public char getCaracter() {
        return caracter;
    }
}
