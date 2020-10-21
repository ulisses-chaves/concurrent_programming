package cafeBanheiro;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 6; // numero de consumidores
		int n = 3; // numero de chaves
		int k = 5; // loop
		
		Semaphore sem = new Semaphore(0);
		Cafeteria cafeteria = new Cafeteria (sem, n);
		LinkedList<Consumidor> consumidores = new LinkedList<Consumidor>();
		
		for(int i = 1; i <= x; i++) {
			consumidores.add(new Consumidor(i, cafeteria, k));
		}
		
		for(int i = 0; i < x; i++) {
			consumidores.get(i).start();
		}
		
	}

}
