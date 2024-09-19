package program;

import java.util.ArrayList;

public class Arma {
	// Funcion padre de todas las armas
	private ArrayList<Arma> armas = new ArrayList<Arma>();
	private String arma;
	private int damage;
	private int alcance;
	private int acierto;
	private float valor;
	private boolean habilidad;
	
	Arma(){		
		this.arma = "Daga";
		this.damage = 1;
		this.alcance = 1;
		this.acierto = 4;	
		this.valor=0;
		this.habilidad=false;
	}
	
	
	public void setArma(String arma) {
		this.arma = arma;
	}
	
	public String getArma() {
		return this.arma;
	}
	
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	
	public int getAlcance() {
		return this.alcance;
	}
	
	
	public void setAcierto(int acierto) {
		this.acierto = acierto;
	}
	
	public int getAcierto() {
		return this.acierto;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getValor() {
		return this.valor;
	}
	
	//True es que ha usado la habilidad, false es que no.
	public void setHabilidad(boolean habilidad) {
		this.habilidad = habilidad;
	}
	
	public boolean getHabilidad() {
		return habilidad;
	}
	
	public Arma getArmas(int idx) {
		return armas.get(idx);
	}
	
	
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		System.out.println( "No hay habilidad especial");
		return enemigos;
	}


	public float valormuertes(ArrayList<Zombie> enemigos, float cash) {
		return cash;
	}
	
}