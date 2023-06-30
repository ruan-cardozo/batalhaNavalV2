package Rede;

import components.Cordenada;

public abstract class Jogada extends Thread {
	public Jogada(int port) {
		this.conectarNoServidor(port);
	}

	private void conectarNoServidor(int port) {

	}

	public void run(){

	}
	public abstract Cordenada jogar();
}
