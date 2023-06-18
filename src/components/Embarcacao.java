package components;

import java.util.LinkedList;

public abstract class Embarcacao {
    protected String tipo;
    private  Cordenada cordenada;
    protected char caracter;


    LinkedList<Cordenada> cordenadas = new LinkedList<Cordenada>();

    protected int tamanho;

    protected char direcao;

    protected int pontuacao;

    public int getTamanho() {
        return tamanho;
    }

    private void atingir() {
        pontuacao += 10;
    }
    public int getPontuacao() {
        return pontuacao;
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

    public void adicionarCordenada(Cordenada cordenada) {
        this.cordenadas.add(cordenada);
    }

    public Cordenada getCordenada() {
        return  this.cordenada;
    }

    public boolean foiAcertada(Cordenada cordenada) {
        // isso ta certo
        // medo da bruxaria // copilot da github
        for (Cordenada cordenadaEmbarcacao : cordenadas) {
            if( cordenadaEmbarcacao.equals(cordenada) ) {
                atingir();
                return true;
            }
        }
        return false;
    }
}
