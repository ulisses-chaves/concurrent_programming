package macacosBananas;

import java.util.concurrent.Semaphore;

public class Bananeira{

	private int bananas;
	private int bananasRestantes;
	private int bananasComidasTotal;
	private int allBananas;
	
	private int macacosNaArvore;
	private final int LIM = 2;
	private Semaphore semaforo;
	
	public Bananeira (int bananasRestantes, Semaphore semaforo) {
		this.allBananas = bananasRestantes;
		this.semaforo = semaforo;
		this.bananasComidasTotal = 0;
		this.macacosNaArvore = 0;
		if(bananasRestantes <= 50) {
			this.bananas = bananasRestantes;
			this.bananasRestantes = 0;
		} else {
			this.bananas = 50;
			this.bananasRestantes = bananasRestantes - 50;
		}
	}
	
	public int subida () throws InterruptedException {
		if(this.bananas == 0) {
			return 0;
		} else {
			if(LIM == this.macacosNaArvore) {
				semaforo.acquire();
				return 1;
			} else {
				
				this.macacosNaArvore = this.macacosNaArvore + 1;
				//System.out.println(macacosNaArvore);
				this.bananasComidasTotal = this.bananasComidasTotal + 1;
				this.bananas = this.bananas - 1;
				return 2;
			}
		}
		
	}
	
	public void descida() throws InterruptedException {
		semaforo.release();
		this.macacosNaArvore = this.macacosNaArvore - 1;
	}

	public int getBananas() {
		return bananas;
	}

	public void setBananas(int bananas) {
		this.bananas = bananas;
	}

	public int getBananasRestantes() {
		return bananasRestantes;
	}

	public void setBananasRestantes(int bananasRestantes){
		this.bananasRestantes = bananasRestantes;
	}
	
	public synchronized int getBananasComidasTotal() throws InterruptedException {
		Thread.sleep(100);
		return bananasComidasTotal;
	}

	public synchronized int getAllBananas() throws InterruptedException {
		Thread.sleep(100);
		return allBananas;
	}
	public int getMacacosNaArvore() {
		return macacosNaArvore;
	}
}
