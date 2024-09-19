package program;

import java.util.ArrayList;
import java.util.Random;

public class Caminante  extends Zombie{

	
	public Caminante( String nombre) {
		setsaludMax(1);
		setMovimiento(1);
		setDamage(1);
		setTipo("Caminante");
		setnombre(nombre);
		setvivo(true);
		setValor(3);
	}
	
	// Habilidad esepcial del Caminante
	@Override
	public ArrayList<Zombie> antelaTumba(ArrayList<Zombie> zombies, Zombie name) {
		Random random = new Random();
		Zombie zombie;
		int countCaminantes = 0;
		int probability=random.nextInt(101);
		zombies.remove(name);
		if(probability >= 95) {
			for(int i = 0;i < zombies.size();i++) {
				zombie = zombies.get(i);
				if(zombie.getTipo().compareToIgnoreCase("Caminante") == 0) {
					countCaminantes++;
				}
			}
			if(countCaminantes == 0) {
				System.out.println("El caminante ha usado su habilidad antes de morir... ¡Revivivendo a nadie!");
			}else {
				System.out.println("El caminante ha usado su habilidad antes de morir... ¡Revivivendo a " + countCaminantes + " caminantes");
				Caminante caminante = new Caminante ("Renacido");
				for(int i = 0;i < countCaminantes;i++) {
					zombies.add(caminante);
				}
			}

		}
		return zombies;
		
	}
	
	public String toString() {
		return " " + super.getnombre() + " (Caminante) ";
	}
}
