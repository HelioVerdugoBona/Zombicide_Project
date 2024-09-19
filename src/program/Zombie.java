package program;

import java.util.ArrayList;

// Funcion padre los Zombies
public class Zombie extends Humanoide {

	private int movimiento;
	private int damage;
	private float valor; // valor de monedas que da el zombie al morir
	private String tipo;
	
	
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	
	public int getMovimiento() {
		return movimiento;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDaño() {
		return damage;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	//Declaracion de la Funcion que los zombies usaran cuando mueran
	public ArrayList<Zombie> antelaTumba(ArrayList<Zombie> zombies, Zombie name) {
		return zombies;


	}
}