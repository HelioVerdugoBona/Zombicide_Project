package program;

import java.util.ArrayList;

public class Bazuca extends Arma {
	Bazuca(){
		super.setArma("Bazuca");
		super.setDamage(5);
		super.setAlcance(3);
		super.setAcierto(5);
		super.setValor(50);
	}
	// Habilidad esepcial es que mata a todos los enemigos y al portador del arma
	@Override
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		System.out.println("Mata gratis a todos los zombies (el portador de esta arma incuido)"); 
		Zombie zombie;
		
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
				enemigos.remove(zombie);
				i--;
		}
		System.out.println("Se ha usado el ataque especial del Bazuca, matando a todo ser no vivo en el proceso junto con el portador del bazuca");
		return enemigos;
	}
	// Funcion que retona la mitad del dinero de los muertos
	@Override
	public float valormuertes(ArrayList<Zombie> enemigos, float cash) {
		Zombie zombie;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			cash += zombie.getValor() / 2;
		}
		return cash;
	}
	
	public String toString() {
		return getArma() + ", tiene "+ getDamage() + ", alcance " + getAlcance() +" y acierto " + getAcierto() + ". Cuesta " + getValor();
	}
}