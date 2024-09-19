package program;

import java.util.ArrayList;

public class Hacha extends Arma{
	Hacha(){
		super.setArma("Hacha");
		super.setDamage(2);
		super.setAlcance(1);
		super.setAcierto(3);
		super.setValor(20);
	}
	
	//Atque esepcial de la Hacha
	@Override
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		System.out.println("Mata gratis a 1 gordo");
		Zombie zombie;
		int countGordosMuertos = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Gordo") == 0) {
				enemigos.remove(zombie);
				System.out.println("Se ha usado el ataque especial del Hacha, matando en el proceso a "+ zombie.getnombre());
				countGordosMuertos ++;
			}
			if (countGordosMuertos == 1){
				break;
			}
		}
		if(countGordosMuertos == 0) {
			System.out.println("Se ha usado el ataque especial del Mandoble, matando en el proceso a ¡Absolutamente Nadie!");
		}
		
		return enemigos;
	}
	
	//mitad del valor cuando matas con el ataque especial
	@Override
	public float valormuertes(ArrayList<Zombie> enemigos, float cash) {
		Zombie zombie;
		int countGordosMuertos = 0;
		for(int i = 0; i < enemigos.size(); i++) {
			zombie = enemigos.get(i);
			if(zombie.getTipo().compareToIgnoreCase("Gordo") == 0) {
				cash += zombie.getValor() / 2;
				countGordosMuertos ++;
			}
			if (countGordosMuertos == 1){
				break;
			}
		}
		return cash;
	}
	
	public String toString() {
		return getArma() + ", tiene "+ getDamage() + ", alcance " + getAlcance() +" y acierto " + getAcierto() + ". Cuesta" + getValor();
	}
}