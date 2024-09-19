package program;

import java.util.ArrayList;
import java.util.Scanner;

public class Lazo extends Objeto {
	Lazo(){
		super.setValor(14);
		super.setEfecto(1);
		super.setNombre("Lazo");
		super.setType("ofensivo");
	}
	
	public void utilidad(Zombie zombie) {
		zombie.setMovimiento(zombie.getMovimiento()-getEfecto());
	}
	
	// Funcion para ralentizar el zombie, reduce el movimiento del zombie
	@SuppressWarnings("resource")
	@Override
	public void ofensivo(ArrayList<Zombie> zombies) {
		Scanner leer=new Scanner(System.in);
		Zombie zombie;
		for (int i = 0; i < zombies.size(); i++) {
			zombie=zombies.get(i);
			System.out.println(i+"- "+zombie.getnombre());
		}
		int ale=leer.nextInt();
		zombie=zombies.get(ale);
		zombie.setMovimiento(zombie.getMovimiento()-getEfecto());
		System.out.println("El zombie "+zombie.getnombre()+ " pegara menos veces");
	}

	
	@Override
	public String toString(){
		return " Lazo, ralentiza al zombie en " + super.getEfecto()  + " y cuesta " + super.getValor() + "";
	}
}