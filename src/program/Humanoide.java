package program;

public abstract class Humanoide {
	
	private int saludMax;
	private int saludDef;
	private String nombre;
	private boolean vivo;
	

	public void setsaludMax(int saludMax) {
		this.saludMax = saludMax;
	}
	
	public int getsaludMax() {
		return this.saludMax;
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	

	public void setsaludDef(int saludMax) {
		this.saludDef = saludMax;
	}
	
	public int getsaludDef() {
		return this.saludDef;
	}

	public String getnombre() {
		return this.nombre;
	}
	

	//True es vivo, false es muerto
	public void setvivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public boolean getvivo() {
		return this.vivo;
	}
}
