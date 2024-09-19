package program;

import java.util.ArrayList;
// Objeto que realizara el arma de arco

public class Arco extends Arma{
	Arco(){
		super.setArma("Arco");
		super.setDamage(1);
		super.setAlcance(2);
		super.setAcierto(3);
		super.setValor(18);
	}
	// Modificacion de ataque especial para usar la habiliad especial del arco
	@Override
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		System.out.println("Mata gratis a 1 corredor");
		Zombie zombie;
		int countCorredores = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Corredor") == 0) {
				enemigos.remove(zombie);
				System.out.println("Se ha usado el ataque especial del Arco, matando en el proceso a "+ zombie.getnombre());
				countCorredores ++;
			}
			if (countCorredores == 1){
				break;
			}
		}
		if(countCorredores == 0) {
			System.out.println("Se ha usado el ataque especial del Arco, matando en el proceso a ¡Absolutamente Nadie!");
		}
		
		return enemigos;
	}
	// Funcion que cuando matas con la habilidad cobras la mitad del valor de la muerte de ese enemigo
	@Override
	public float valormuertes(ArrayList<Zombie> enemigos, float cash) {
		Zombie zombie;
		int countCorredoresMuertos = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Corredor") == 0) {
				cash += zombie.getValor()/ 2;
				countCorredoresMuertos ++;
			}
			if (countCorredoresMuertos == 1){
				break;
			}
		}
		
		return cash;
	}
	
	
	public String toString() {
		return getArma() + ", tiene "+ getDamage() + ", alcance " + getAlcance() +" y acierto " + getAcierto() + ". Cuesta " + getValor();
	}
}