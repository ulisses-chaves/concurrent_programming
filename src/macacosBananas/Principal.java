package macacosBananas;

import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		int q = 200; // N�mero total de bananas!
		
		Semaphore semaforo = new Semaphore(2);
		Bananeira bananeira = new Bananeira(q, semaforo);
		Macaco macaco1 = new Macaco("Z�", bananeira);
		Macaco macaco2 = new Macaco("Ot�vio", bananeira);
		Macaco macaco3 = new Macaco("J�o", bananeira);
		Reposicao reposicao = new Reposicao(bananeira);
		
		reposicao.start();
		macaco1.start();
		macaco2.start();
		macaco3.start();
		
		macaco1.join();
		macaco2.join();
		macaco3.join();
		
		System.out.println("N = " + q + "\nZ�: " + macaco1.getBananasComidas() + "\nOt�vio: " + macaco2.getBananasComidas() + "\nJ�o: " + macaco3.getBananasComidas());
	}

}
