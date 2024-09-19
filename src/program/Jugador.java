package program;

import java.util.ArrayList;
// Objeto jugador que hereda de humaniode
public class Jugador extends Humanoide {
	private ArrayList<Arma> arma;
	private ArrayList<Objeto> objetos;
	private boolean rondaPasada;
	private boolean estadoAlterado;
	private boolean clase;
	private int arma_seleccionada;
	private int retorno;

	

	
	Jugador(String nombre,int vida,Arma arma){
		this.arma = new ArrayList<Arma>();
		this.objetos = new ArrayList<Objeto>();
		this.setArma(arma);
		this.setPrincipal(0);
		super.setsaludDef(vida);
		super.setnombre(nombre);
		super.setsaludMax(vida);
		super.setvivo(true);
		setEstado(false);
		setClase(false);
	}
	
	public void setArma(Arma arma) {
		this.arma.add(arma);
	}
	// se hace para guardar el daño del arma
	public void setRetorno(int retorno) {
		this.retorno=retorno;
	}
	
	// si el jugador esta alterado por un objeto(concretamente el de un objeto potenciador)
	public void setEstado(boolean estado) {
		estadoAlterado=estado;
	}
	
	// Si el jugador tiene una clase o no (False si no tiene True si si);
	public void setClase(boolean clase) {
		this.clase=clase;
	}
	
	// Devuelve si el jugador tiene una clase o no (False si no tiene True si si);
	public boolean getClase() {
		return clase;
	}
	
	
	
	// Para poner el arma que usas
	public void setPrincipal(int principal) {
		arma_seleccionada=principal;
	}
	
	// para agarrar el inventario personal del jugador
	public ArrayList<Arma> getArrayArma() {
		return arma;
	}
	
	public Arma getArma() {
		return arma.get(arma_seleccionada);
	}
	// para retornar el estado anterior
	public int getRetorno() {
		return retorno;
	}
	//meter objetos dentro del inventario de objetos
	public void setArrayObjeto(Objeto objeto) {
		objetos.add(objeto);
	}
	
	// para agarrar el inventario de objeto del jugador
	public ArrayList<Objeto> getArrayObjeto() {
		return objetos;
	}
	
	public void setrondaPasada(boolean rondaPasada) {
		this.rondaPasada = rondaPasada;
	}
	
	public boolean getrondaPasada() {
		return this.rondaPasada;
	}
	// Para pillar el estado del jugador
	public boolean getestadoAlterado() {
		return this.estadoAlterado;
	}
	// Funcion para volver al estado normal el arma
	public void corrector(){
		getArma().setDamage(retorno);
	}
	
	public String toString(){
		return "El Superviviente " + super.getnombre() + " tiene " + super.getsaludMax() + " de salud Maxima, usa " + getArma().getArma() + " como arma y hace " + getArma().getDamage() + " de daño";
	}
}
