package cartas;

import java.util.LinkedList;
import java.util.Random;

public class Baralho {
	private LinkedList<Carta> cartas;
	
	public Baralho () {
		cartas = new LinkedList<Carta>();
	}
	
	public void addBaralho (LinkedList<Carta> cartas) {
		this.cartas.addAll(cartas);
	}
	
	public void getCarta(int id) {
		cartas.get(id);
	}
	
	public void addCarta(Carta carta) {
		cartas.add(carta);
	}
	
	public synchronized Carta getCartaAleatoria() throws InterruptedException {
		Thread.sleep(500);
		return cartas.remove(new Random().nextInt(cartas.size() - 1) + 0);
	}
	
	public int getNumeroCartas() {
		return cartas.size();
	}
}
