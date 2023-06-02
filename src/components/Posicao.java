package components;
public abstract class Posicao {
    protected String tipo;
    protected int linhaInicial;
    protected int colunaInicial;
    protected char caracter;

    protected Direcao direcao;

     Posicao(String tipo, int linhaInicial, int colunaInicial, char caracter) {
       this(tipo,linhaInicial,colunaInicial,caracter,Direcao.VERTICAL);
    }

    Posicao(String tipo, int linhaInicial, int colunaInicial, char caracter, Direcao direcao) {
        this.tipo = tipo;
        this.linhaInicial = linhaInicial;
        this.colunaInicial = colunaInicial;
        this.caracter = caracter;
        this.direcao = direcao;
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

    public Direcao getDirecao() {
         return this.direcao;
    }
}
