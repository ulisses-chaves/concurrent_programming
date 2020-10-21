package cartas;

import java.util.LinkedList;

public class Inicio {

	public static void main(String[] args) throws InterruptedException {
		int n = 3; // num jogadores e baralhos
		LinkedList<Carta> cartas = new LinkedList<Carta>();
		
		//instanciando as cartas de um baralho
		for (int i = 2; i <= 13; i++) {
			cartas.add(new Carta(i + 1, "Paus"));
		}
		for (int i = 2; i <= 13; i++) {
			cartas.add(new Carta(i + 1, "Copas"));
		}
		for (int i = 2; i <= 13; i++) {
			cartas.add(new Carta(i + 1, "Espadas"));
		}
		for (int i = 2; i <= 13; i++) {
			cartas.add(new Carta(i + 1, "Ouros"));
		}
		
		//instanciando o baralho e adicionando baralhos ao número total de cartas que serão usados no game
		Baralho baralho = new Baralho();
		for (int i = 0; i < n; i++) {
			baralho.addBaralho(cartas);
		}
		
		//instaciando os jogadores e a mesa
		Jogador jogador1 = new Jogador(1, baralho);
		Jogador jogador2 = new Jogador(2, baralho);
		Jogador jogador3 = new Jogador(3, baralho);
		
		Mesa mesa = new Mesa(jogador1, jogador2, jogador3, baralho);
		
		//rodando as threads
		jogador1.start();
		jogador2.start();
		jogador3.start();
		mesa.start();
		jogador1.join();
		jogador2.join();
		jogador3.join();
		mesa.join();
		
		int c1 = jogador1.getCartasGanhas();
		int c2 = jogador2.getCartasGanhas();
		int c3 = jogador3.getCartasGanhas();
		//System.out.println(c1);
		//System.out.println(c2);
		//System.out.println(c3);
		if (c1 > c2 && c1 > c3) {
			System.out.println("jogador 1 foi o campeão");
		} else {
			if (c2 > c3) {
				System.out.println("jogador 2 foi o campeão");
			} else {
				if (c3 > c2) {
					System.out.println("jogador 3 foi o campeão");
				} else {
					if (c1 == c2 && c1 == c3) {
						System.out.println("todos os jogadores empataram");
					} else {
						if (c1 == c2) {
							System.out.println("jogadores 1 e 2 empataram");
						} else {
							if (c1 == c3) {
								System.out.println("jogadores 1 e 3 empataram");
							} else {
								if (c2 == c3) {
									System.out.println("jogador 2 e 3 empataram");
								}
							}
						}
					}
				}
			}
		}
	}

}
