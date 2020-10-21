package cafeBanheiro;

public class Consumidor extends Thread{
	private int id;
	private Cafeteria cafeteria;
	private int k;

	public Consumidor (int id, Cafeteria cafeteria, int loop) {
		this.id = id;
		this.cafeteria = cafeteria;
		this.k = loop;
	}

	public void run () {
		System.out.println("Consumidor " + this.id + " entrou na cafeteria.");
		for (int i = 0; i < k; i++) {
			try {
				cafeteria.beberCafe(this.id);
				cafeteria.pegarChave(this.id);
				cafeteria.usarBanheiro(this.id);
				cafeteria.colocaChaveVolta(this.id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Consumidor " + id + " deixa a cafeteria.");
	}
}
