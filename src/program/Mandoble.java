package program;

import java.util.ArrayList;

public class Mandoble extends Arma{
	Mandoble(){
		super.setArma("Mandoble");
		super.setDamage(2);
		super.setAlcance(1);
		super.setAcierto(4);
		super.setValor(25);
	}
	//ataque especial de mandoble, mata corredores
	@Override
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		System.out.println("Mata gratis a 2 corredores"); 
		Zombie zombie;
		int countCaminantesMuertos = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Corredor") == 0) {
				enemigos.remove(zombie);
				System.out.println("Se ha usado el ataque especial del Mandoble, matando en el proceso a "+ zombie.getnombre());
				i--;
				countCaminantesMuertos ++;
			}
			if (countCaminantesMuertos == 2){
				break;
			}
		}
		if(countCaminantesMuertos == 0) {
			System.out.println("Se ha usado el ataque especial del Mandoble, matando en el proceso a ¡Absolutamente Nadie!");
		}
		
		return enemigos;
	}
	
	@Override
	public float valormuertes(ArrayList<Zombie> enemigos, float cash) {
		Zombie zombie;
		int countCaminantesMuertos = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Corredor") == 0) {
				cash += zombie.getValor()/ 2;
				countCaminantesMuertos ++;
			}
			if (countCaminantesMuertos == 2){
				break;
			}
		}
		
		return cash;
	}
	
	public String toString() {
		return getArma() + ", tiene "+ getDamage() + ", alcance " + getAlcance() +" y acierto " + getAcierto() + ". Cuesta " + getValor() + " ";
	}
}
