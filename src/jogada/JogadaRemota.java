package jogada;

import components.Cordenada;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class JogadaRemota extends Jogada {


	public Cordenada solicitarJogada() {
		return  new Cordenada(0,0); // substituir por uma jogada remota
	}
}
