package macacosBananas;

public class Macaco extends Thread{

	private String nome;
	private Bananeira bananeira;
	private int bananasComidas;
	private long tempoSemComer;
	private long tempoMaxSemComer;
	
	public Macaco (String nome, Bananeira bananeira) {
		this.nome = nome;
		this.bananeira = bananeira;
		this.bananasComidas = 0;
		this.tempoSemComer = 0;
	}
	
	public void run () {
		long inicio = 0;
		long fim = 0;
		try {
			while(bananeira.getBananasComidasTotal() < bananeira.getAllBananas()) {
				inicio = System.currentTimeMillis();
				int resposta = 0;
				resposta = bananeira.subida();
				if(resposta == 1) {
					System.out.println("O macaco " + this.nome + " não conseguiu subir na bananeira");
					sleep(2000); //2000
					fim = System.currentTimeMillis();
					this.tempoSemComer = this.tempoSemComer + (fim - inicio);
					if(tempoSemComer > tempoMaxSemComer) {
						tempoMaxSemComer = tempoSemComer;
					}
				} else {
					if (resposta == 2) {
						System.out.println("O macaco " + this.nome + " comeu uma banana");
						sleep(1000); //1000
						this.bananasComidas = this.bananasComidas + 1;
						this.tempoSemComer = 0;
						bananeira.descida();
					} else {
						System.out.println("Não havia bananas para o macaco " + this.nome + " comer");
						fim = System.currentTimeMillis();
						this.tempoSemComer = this.tempoSemComer + (fim - inicio);
						if(tempoSemComer > tempoMaxSemComer) {
							tempoMaxSemComer = tempoSemComer;
						}
						sleep(1000); //1000
					}
				}
			}
		} catch (InterruptedException e) {}
		System.out.println("O tempo máximo sem comer do macaco " + this.nome + " foi de "  + tempoMaxSemComer + " milisegundos");
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