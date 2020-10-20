package cartas;

public class Carta {
	private int id;
	private String naipe;
	
	public Carta (int i, String naipe) {
		this.setId(i);
		this.setNaipe(naipe);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	
	
}
