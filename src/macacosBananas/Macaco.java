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
		try {
			while(bananeira.getBananasComidasTotal() < bananeira.getAllBananas()) {
				int resposta = 0;
				resposta = bananeira.subida();
				if(resposta == 1) {
					System.out.println("O macaco " + this.nome + " não conseguiu subir na bananeira");
					sleep(2000); //2000
				} else {
					if (resposta == 2) {
						System.out.println("O macaco " + this.nome + " comeu uma banana");
						sleep(1000); //1000
						this.bananasComidas = this.bananasComidas + 1;
						bananeira.descida();
					} else {
						System.out.println("Não havia bananas para o macaco " + this.nome + " comer");
						sleep(1000); //1000
					}
				}
			}
		} catch (InterruptedException e) {}
		System.out.println(bananeira.getMacacosNaArvore());
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