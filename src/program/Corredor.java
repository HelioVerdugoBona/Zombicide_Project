package program;
import java.util.ArrayList;
import java.util.Random;

public class Corredor extends Zombie{

	
	public Corredor( String nombre) {
		setsaludMax(1);
		setMovimiento(2);
		setDamage(1);
		setTipo("Corredor");
		setnombre(nombre);
		setvivo(true);
		setValor(4);
	}
	//Habilidad especial del Corredor
	@Override
	public ArrayList<Zombie> antelaTumba(ArrayList<Zombie> zombies, Zombie name) {
		Random random=new Random();
		int probability=random.nextInt(101);
		int countCorredoresMuertos=0;
		zombies.remove(name);
		if(probability>95) {
			Zombie zombie;
			for (int i = 0; i < zombies.size(); i++) {
				zombie=zombies.get(i);
				if(zombie.getTipo().compareToIgnoreCase("Corredor") == 0) {
					System.out.println(" Corredor ha usado su habilidad, Matando a " + zombie);
					zombies.remove(i);
					i--;
					countCorredoresMuertos++;
				}
				
			}if(countCorredoresMuertos == 0) {
				System.out.println(" Corredor ha usado su habilidad, pero ¡No ha muerto nadie! ");
			}
		}
		return zombies;
	}
	
	public String toString() {
		return " " + super.getnombre() + " (Corredor) ";
	}
}
