package producaoGames;

import java.util.Random;

public class Desenvolvimento extends Thread{
	private Equipe equipe;
	
	public Desenvolvimento (Equipe equipe) {
		this.equipe = equipe;
	}
	
	public void run() {
		long inicio = System.currentTimeMillis();
		while (equipe.getJogosProduzidos() < 10) {
			equipe.produzirJogo();
			int tempo = new Random().nextInt(500) + 200;
			//System.out.println("O dev " + equipe.getDev() + " da equipe " + equipe.getNome() + " está produzindo um jogo. Número de jogos da equipe " + equipe.getNome()+": "+equipe.getJogosProduzidos());
			try {
				sleep((long) (tempo*Math.random()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Número de jogos da equipe " + equipe.getNome()+": "+equipe.getJogosProduzidos());
		}
		
		long fim  = System.currentTimeMillis();
		this.equipe.setTempoDev(fim - inicio);
		
		//System.out.println("Tempo da equipe " + this.equipe.getNome() + ": " + (fim - inicio));
		
	}
}
