package program;

import java.util.ArrayList;

public class Hechizo extends Arma{
	Hechizo(){
		super.setArma("Hechizo");
		super.setDamage(1);
		super.setAlcance(3);
		super.setAcierto(4);
		super.setValor(10);
	}
	
	// atque especial de Hechizo
	@Override
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		System.out.println("Mata gratis a 2 caminantes");
		Zombie zombie;
		int countCaminantesMuertos = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Caminante") == 0) {
				enemigos.remove(zombie);
				System.out.println("Se ha usado el ataque especial del Hechizo, matando en el proceso a "+ zombie.getnombre());
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
	
	//Mitad de valor al matar con habilidad esepcial
	@Override
	public float valormuertes(ArrayList<Zombie> enemigos, float cash) {
		Zombie zombie;
		int countCaminantes = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Caminante") == 0) {
				cash += zombie.getValor()/ 2;
				countCaminantes ++;
			}
			if (countCaminantes == 2){
				break;
			}
		}
		return cash;
	}
	
	public String toString() {
		return getArma() + ", tiene "+ getDamage() + ", alcance " + getAlcance() +" y acierto " + getAcierto() + ". Cuesta " + getValor();
	}
}
