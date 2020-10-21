package cartas;

import java.util.LinkedList;

public class Jogador extends Thread{
	private int nome;
	private LinkedList<Carta> cartasNaMao;
	private Carta cartaEscolhida;
	private int cartasGanhas;
	private Baralho baralho;
	private boolean pronto;

	public Jogador (int nome, Baralho baralho) {
		this.nome = nome;
		this.baralho = baralho;
		this.setCartaEscolhida(null);
		this.cartasGanhas = 0;
		this.cartasNaMao = new LinkedList<Carta>();
		this.pronto = false;
	}

	public void run () {
		while(baralho.getNumeroCartas() > 9) {
			if (pronto == false) {
				System.out.println("O jogador " + nome + " está puxando as cartas");
				try {
					cartasNaMao.add(baralho.getCartaAleatoria());
					cartasNaMao.add(baralho.getCartaAleatoria());
					cartasNaMao.add(baralho.getCartaAleatoria());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(cartasNaMao.get(0).getId() >=  cartasNaMao.get(1).getId() && cartasNaMao.get(0).getId() >= cartasNaMao.get(2).getId()) {
					setCartaEscolhida(cartasNaMao.get(0));
					baralho.addCarta(cartasNaMao.get(1));
					baralho.addCarta(cartasNaMao.get(2));
				} else {
					if (cartasNaMao.get(1).getId() >= cartasNaMao.get(2).getId()) {
						setCartaEscolhida(cartasNaMao.get(1));
						baralho.addCarta(cartasNaMao.get(0));
						baralho.addCarta(cartasNaMao.get(2));
					}else {
						setCartaEscolhida(cartasNaMao.get(2));
						baralho.addCarta(cartasNaMao.get(1));
						baralho.addCarta(cartasNaMao.get(0));
					}
				}
				this.pronto = true;
				this.cartasNaMao.removeAll(cartasNaMao);
			} else {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getCartasGanhas() {
		return cartasGanhas;
	}
	public void addCartasGanhas() {
		this.cartasGanhas = this.cartasGanhas + 3;
	}

	public Carta getCartaEscolhida() {
		return cartaEscolhida;
	}

	public void setCartaEscolhida(Carta cartaEscolhida) {
		this.cartaEscolhida = cartaEscolhida;
	}

	public boolean getPronto() {
		return this.pronto;
	}

	public void setPronto(boolean pronto) {
		this.pronto = pronto;
	}
}
