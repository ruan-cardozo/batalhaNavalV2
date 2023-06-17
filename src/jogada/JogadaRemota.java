package jogada;

import components.Cordenada;

import java.util.Scanner;

public class JogadaRemota extends Jogada {
	public Cordenada solicitarJogada() {
        // sockets conexao e toda confusao do Rodrigo
		return  new Cordenada(0, 0); // substituir por uma jogada remota
	}
}
