package cartas;

public class Mesa extends Thread{

	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador jogador3;
	private Baralho baralho;

	public Mesa (Jogador jogador1, Jogador jogador2, Jogador jogador3, Baralho baralho) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.jogador3 = jogador3;
		this.baralho = baralho;
	}

	public void run () {
		while(baralho.getNumeroCartas() > 9) {
			if(this.jogador1.getPronto() == true && this.jogador2.getPronto() == true && this.jogador3.getPronto() == true) {
				int id1 = jogador1.getCartaEscolhida().getId();
				int id2 = jogador2.getCartaEscolhida().getId();
				int id3 = jogador3.getCartaEscolhida().getId();
				if (id1 > id2 && id1 > id3) {
					System.out.println("Jogador 1 ganhou");
					jogador1.addCartasGanhas();
				} else {
					if (id2 > id3) {
						jogador2.addCartasGanhas();
						System.out.println("Jogador 2 ganhou");
					} else {
						jogador3.addCartasGanhas();
						System.out.println("Jogador 3 ganhou");
					}
				}
				jogador1.setPronto(false);
				jogador2.setPronto(false);
				jogador3.setPronto(false);
			} else {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
