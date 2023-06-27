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

    private int contador;

    private boolean destruido;

    public boolean estaDestruido(Cordenada cordenada) {
        if (cordenadas.contains(cordenada)) {
            atingir();
            return true;
        }
        return false;
    }

    public int getTamanho(String tipo) {
        return tamanho;
    }

    private void atingir() {
        contador += 1;
        if (contador == getTamanho(getTipo())) {
            destruido = true;
        }
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
        this.destruido = false;
        this.contador = 0;
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
