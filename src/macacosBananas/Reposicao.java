package macacosBananas;

public class Reposicao extends Thread{
	private Bananeira bananeira;
	public Reposicao (Bananeira bananeira) {
		this.bananeira = bananeira;
	}
	
	public void run() {
		while(bananeira.getBananasRestantes() != 0) {
			while(bananeira.getBananas() == 0) {
				while(bananeira.getBananas() <= 50 && bananeira.getBananasRestantes() != 0) {
					bananeira.setBananas(bananeira.getBananas() + 5);
					bananeira.setBananasRestantes(bananeira.getBananasRestantes() - 5);
					try {
						sleep((long) (5000)); //5000
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
}
