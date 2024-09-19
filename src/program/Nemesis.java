package program;

import java.util.ArrayList;

public class Nemesis extends Zombie {
//Enemigo tocho del juego, cuando sale tienes que priorizar su muerte o te puede hacer mucho daño
	public Nemesis( String nombre) {
		setsaludMax(2);
		setMovimiento(3);
		setDamage(2);
		setTipo("Nemesis");
		setnombre(nombre);
		setvivo(true);
		setValor(50);
	}
	
	@Override
	public ArrayList<Zombie> antelaTumba(ArrayList<Zombie> zombies, Zombie name) {
		return zombies;
	}
	
	public static final String ANSI_RED = "\u001B[31m";
	
	public static final String ANSI_RESET = "\u001B[0m";
	
	public String toString() {
		return " " + ANSI_RED + super.getnombre() + " (Jefe) " + ANSI_RESET + " ";
	}
	
}
