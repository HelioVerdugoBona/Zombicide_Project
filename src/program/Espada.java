package program;

import java.util.ArrayList;
import java.util.Random;

public class Espada extends Arma {
	Espada(){
		super.setArma("Espada");
		super.setDamage(1);
		super.setAlcance(1);
		super.setAcierto(4);
		super.setValor(8);
	}
	
	// Habilidad de la espada,
	@Override
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		Random random = new Random();
		
		System.out.println("Mata gratis a 2 zombies aleatorios");
		
		int zombieMuerto = random.nextInt(enemigos.size()-1);
		System.out.println(enemigos.get(zombieMuerto));
		enemigos.remove(zombieMuerto);
		
		if(enemigos.size()-1 == 0) {
			System.out.println(enemigos.get(0));	
			enemigos.remove(0);
		}else {
			zombieMuerto = random.nextInt(enemigos.size()-1);
			System.out.println(enemigos.get(zombieMuerto));	
			enemigos.remove(zombieMuerto);
			
		}
		return enemigos;
	}
	
	// Funcion de que si matas con la habilidad cobras la mitad del valor de muerte del zombie
	@Override
	public float valormuertes(ArrayList<Zombie> enemigos, float cash) {
		Zombie zombie;
		int media = 0;
		for(int i =0;i<enemigos.size();i++) {
			zombie = enemigos.get(i);
			media += zombie.getValor();
		}
		cash += media / enemigos.size();
		return cash;
	}
	
	public String toString() {
		return getArma() + ", tiene "+ getDamage() + ", alcance " + getAlcance() +" y acierto " + getAcierto() + ". Cuesta " + getValor();
	}
}
