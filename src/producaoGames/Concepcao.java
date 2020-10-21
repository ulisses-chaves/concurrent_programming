package producaoGames;

import java.util.Random;

public class Concepcao extends Thread{
	private Equipe equipe;
	
	public Concepcao (Equipe equipe) {
		this.equipe = equipe;
	}
	
	public void run () {
		while (equipe.getJogosProduzidos() < 10) {
			equipe.produzirGDD();
			int tempo = new Random().nextInt(1000) + 500;
			try {
				sleep((long) (tempo*Math.random()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
