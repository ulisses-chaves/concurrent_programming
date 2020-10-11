package macacosBananas;

import java.util.concurrent.Semaphore;

public class Bananeira extends Thread{

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
	
	public int subida () {
		//System.out.println(this.bananas);
		//System.out.println(this.bananasRestantes);
		if(this.bananas == 0) {
			return 0;
		} else {
			if(LIM <= this.macacosNaArvore ) {
				semaforo.release();
				return 1;
			} else {
				this.macacosNaArvore = this.macacosNaArvore + 1;
				this.bananasComidasTotal = this.bananasComidasTotal + 1;
				this.bananas = this.bananas - 1;
				return 2;
			}
		}
		
	}
	
	public void run() {
		while(this.bananasRestantes != 0) {
			while(this.bananas == 0) {
				while(this.bananas <= 50 && this.bananasRestantes != 0) {
					this.bananas = this.bananas + 5;
					this.bananasRestantes = this.bananasRestantes - 5;
					try {
						sleep((long) (2000)); //5000
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				sleep((long) (100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void descida() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void setBananasRestantes(int bananasRestantes) {
		this.bananasRestantes = bananasRestantes;
	}
	
	public int getBananasComidasTotal() {
		return bananasComidasTotal;
	}

	public int getAllBananas() {
		return allBananas;
	}
}
