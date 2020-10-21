package cafeBanheiro;

import java.util.concurrent.Semaphore;

public class Cafeteria {
	private Semaphore semaforo;
	private int chaves;
	private int banheirosOcupados;
	
	public Cafeteria (Semaphore semaforo, int chaves) {
		this.semaforo = semaforo;
		this.chaves = chaves;
		this.banheirosOcupados = 0;
	}
	
	public void beberCafe (int nome) throws InterruptedException {
		System.out.println("O consumidor " + nome + " está bebendo café.");
		Thread.sleep(1000);
	}
	
	public void pegarChave(int nome) throws InterruptedException {
		if (this.banheirosOcupados >= this.chaves) {
			System.out.println("Não tinha chave para o consumidor " + nome + ".");
			semaforo.acquire();
		}
		//System.out.println(this.banheirosOcupados); // caso queira vê o numero de consumidores usando o banheiro
		this.banheirosOcupados++;
		System.out.println("O consumidor " + nome + " pegou uma chave.");
		Thread.sleep(1000);
	}
	
	public void usarBanheiro(int nome) throws InterruptedException {
		System.out.println("O consumidor " + nome + " está usando o banheiro.");
		Thread.sleep(1000);
	} 
	
	public void colocaChaveVolta(int nome) throws InterruptedException {
		Thread.sleep(1000);
		semaforo.release();
		this.banheirosOcupados--;
		System.out.println("O consumidor " + nome + " colocou uma chave de volta.");
	}
	
}
