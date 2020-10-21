package producaoGames;

import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		Semaphore sem = new Semaphore(0);
		Equipe equipeA = new Equipe ('A', "João", "Pedro", sem);
		Equipe equipeB = new Equipe ('B', "Ulisses", "Lucas", sem);
		Equipe equipeC = new Equipe ('C', "Iury", "Hugo", sem);
		Equipe equipeD = new Equipe ('D', "Giva", "Lucão", sem);
		Equipe equipeE = new Equipe ('E', "Luquinhas", "Caio", sem);
		Concepcao conA = new Concepcao (equipeA);
		Concepcao conB = new Concepcao (equipeB);
		Concepcao conC = new Concepcao (equipeC);
		Concepcao conD = new Concepcao (equipeD);
		Concepcao conE = new Concepcao (equipeE);
		Desenvolvimento devA = new Desenvolvimento (equipeA);
		Desenvolvimento devB = new Desenvolvimento (equipeB);
		Desenvolvimento devC = new Desenvolvimento (equipeC);
		Desenvolvimento devD = new Desenvolvimento (equipeD);
		Desenvolvimento devE = new Desenvolvimento (equipeE);
		
		conA.start();
		conB.start();
		conC.start();
		conD.start();
		conE.start();
		devA.start();
		devB.start();
		devC.start();
		devD.start();
		devE.start();
		
		conA.join();
		conB.join();
		conC.join();
		conD.join();
		conE.join();
		devA.join();
		devB.join();
		devC.join();
		devD.join();
		devE.join();

		Equipe vencedor;
		
		if (equipeA.getTempoDev() <= equipeB.getTempoDev() && equipeA.getTempoDev() <= equipeC.getTempoDev() && equipeA.getTempoDev() <= equipeD.getTempoDev() && equipeA.getTempoDev() <= equipeE.getTempoDev()) {
			vencedor = equipeA;
		} else {
			if (equipeB.getTempoDev() <= equipeC.getTempoDev() && equipeB.getTempoDev() <= equipeD.getTempoDev() && equipeB.getTempoDev() <= equipeE.getTempoDev()) {
				vencedor = equipeB;
			} else {
				if (equipeC.getTempoDev() <= equipeD.getTempoDev() && equipeC.getTempoDev() <= equipeE.getTempoDev()) {
					vencedor = equipeC;
				} else {
					if (equipeD.getTempoDev() <= equipeE.getTempoDev()) {
						vencedor = equipeD;
					} else {
						vencedor = equipeE;
					}
				}
			}
		}
		
		System.out.println("O vencedor foi a equipe " + vencedor.getNome() + " com o tempo de " + vencedor.getTempoDev() + " milisegundos.");
		
		//long segundos = ( vencedor.getTempoDev() / 1000 ) % 60;
		//System.out.println("O vencedor foi a equipe " + vencedor.getNome() + " com o tempo de " + segundos + " segundos.");
		
	}

}
