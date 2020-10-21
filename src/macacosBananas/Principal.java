package macacosBananas;

import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		int q = 200; // Número total de bananas!
		
		Semaphore semaforo = new Semaphore(2);
		Bananeira bananeira = new Bananeira(q, semaforo);
		Macaco macaco1 = new Macaco("Zé", bananeira);
		Macaco macaco2 = new Macaco("Otávio", bananeira);
		Macaco macaco3 = new Macaco("Jão", bananeira);
		Reposicao reposicao = new Reposicao(bananeira);
		
		reposicao.start();
		macaco1.start();
		macaco2.start();
		macaco3.start();
		
		macaco1.join();
		macaco2.join();
		macaco3.join();
		
		System.out.println("N = " + q + "\nZé: " + macaco1.getBananasComidas() + "\nOtávio: " + macaco2.getBananasComidas() + "\nJão: " + macaco3.getBananasComidas());
	}

}
