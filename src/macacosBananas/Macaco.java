package macacosBananas;

public class Macaco extends Thread{

	private String nome;
	private Bananeira bananeira;
	private int bananasComidas;
	
	public Macaco (String nome, Bananeira bananeira) {
		this.nome = nome;
		this.bananeira = bananeira;
		this.bananasComidas = 0;
	}
	
	public void run () {
		while(bananeira.getBananasComidasTotal() != bananeira.getAllBananas()) {
			int resposta = bananeira.subida();
			if(resposta == 1) {
				//System.out.println(bananeira.getBananasRestantes());
				System.out.println("O macaco " + this.nome + " comeu uma banana");
				try {
					sleep((long) (1000)); //1000
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.bananasComidas = this.bananasComidas + 1;
				bananeira.descida();
			} else {
				if (resposta == 2) {
					System.out.println("O macaco " + this.nome + " não conseguiu subir na bananeira");
					try {
						sleep((long) (2000)); //2000
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Não havia bananas para o macaco " + this.nome + " comer");
					try {
						sleep((long) (1000)); //1000
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getBananasComidas() {
		return bananasComidas;
	}
	
}