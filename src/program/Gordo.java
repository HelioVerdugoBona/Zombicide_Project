package program;

import java.util.ArrayList;
import java.util.Random;

public class Gordo  extends Zombie{

	public Gordo(String nombre) {
		setsaludMax(2);
		setMovimiento(1);
		setDamage(1);
		setTipo("Gordo");
		setnombre(nombre);
		setvivo(true);
		setValor(4);
	}
	
	
	//Funcion para ejecutar la habilidad especial del Gordo
	@Override
	public ArrayList<Zombie> antelaTumba(ArrayList<Zombie> zombies, Zombie name) {
		Random random=new Random();
		int probability=random.nextInt(101);
		int countGordosMuertos=0;
		zombies.remove(name);
		if(probability>95) {
			Zombie zombie;
			for (int i = 0; i < zombies.size(); i++) {
				zombie=zombies.get(i);
				if(zombie.getTipo().compareToIgnoreCase("Gordo") == 0) {
					System.out.println("Ante la tumba ha matado a" + zombie);
					zombies.remove(i);
					countGordosMuertos++;
				}
			}if(countGordosMuertos == 0) {
				System.out.println("Ante la tumba no ha encontrado Gordos para matar");
			}
		}
		return zombies;
	}
	
	public String toString() {
		return " " + super.getnombre() + " (Gordo) ";
	}
}
