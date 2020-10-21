package producaoGames;

import java.util.concurrent.Semaphore;

public class Equipe {
	private char nome;
	private String gameDesigner;
	private String dev;
	private int jogosProduzidos;
	private long tempoDev;
	
	private Semaphore semaforo;
	private int gdd;
	private final int LIMGDD = 2;
	
	public Equipe(char nome, String gameDesigner, String dev, Semaphore semaforo) {
		this.nome = nome;
		this.gameDesigner = gameDesigner;
		this.dev = dev;
		this.jogosProduzidos = 0;
		this.tempoDev = 0;
		this.gdd = 0;
		this.semaforo = semaforo;
	}
	
	public void produzirGDD() {
		if (LIMGDD == this.gdd) {
			//System.out.println("A equipe " + this.nome + " não conseguiu fazer o GDD. Número máximo alcançado.");
			semaforo.release();
		} else {
			this.gdd = gdd + 1;
			//System.out.println("O designer " + this.gameDesigner + " da equipe " + this.nome + " está fazendo o GDD");
		}
	}
	
	public void produzirJogo() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {}
		this.gdd = this.gdd - 1;
		this.jogosProduzidos = this.jogosProduzidos + 1;
		//System.out.println("O dev " + this.dev + " da equipe " + this.nome + " está produzindo um jogo. Número de jogos da equipe " + this.nome+": " + this.jogosProduzidos);
	}
	
	//GETTERS e SETTERS
	public int getGdd() {
		return this.gdd;
	}
	
	public char getNome() {
		return nome;
	}
	
	public String getGameDesigner() {
		return gameDesigner;
	}
	
	public String getDev() {
		return dev;
	}
	
	public int getJogosProduzidos() {
		return jogosProduzidos;
	}
	
	public void setJogosProduzidos(int jogosProduzidos) {
		this.jogosProduzidos = jogosProduzidos;
	}

	public long getTempoDev() {
		return tempoDev;
	}

	public void setTempoDev(long tempoDev) {
		this.tempoDev = tempoDev;
	}
}
