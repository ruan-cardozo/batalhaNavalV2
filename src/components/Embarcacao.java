package components;

import java.util.LinkedList;

public abstract class Embarcacao {
    protected String tipo;
    private  Cordenada cordenada;
    protected char caracter;


    LinkedList<Cordenada> cordenadas = new LinkedList<Cordenada>();

    protected int tamanho;

    protected char direcao;

    public int getTamanho() {
        return tamanho;
    }

    public Embarcacao(String tipo, Cordenada cordenada, char caracter, int tamanho, char direcao) {
        this.tipo = tipo;
        this.cordenada = cordenada;
        this.caracter = caracter;
        this.tamanho = tamanho;
        this.direcao = direcao;
    }

    public Embarcacao(String tipo, Cordenada cordenada, char caracter) {
        this.tipo = tipo;
        this.cordenada = cordenada;
        this.caracter = caracter;
        this.direcao = direcao;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLinhaInicial() {
        return cordenada.getLinha();
    }

    public int getColunaInicial() {
        return cordenada.getColuna();
    }

    public char getCaracter() {
        return caracter;
    }

    public char getDirecao() {
         return this.direcao;
    }

    public boolean foiDestruida() {
         // fazer a logica para saber se foi destruida
        return false;
    }

    public int getPontuacao() {
         // para cada posicao atingida retornar 10 pontos
        return 0;
    }

    public void adicionarCordenada(Cordenada cordenada) {
        this.cordenadas.add(cordenada);
    }

    public Cordenada getCordenada() {
        return  this.cordenada;
    }
}
