package program;

import java.util.ArrayList;

public class Daga extends Arma{
	Daga(){
		super.setArma("Daga");
		super.setDamage(1);
		super.setAlcance(1);
		super.setAcierto(4);
		super.setValor(0);
	}
	
	@Override
	public ArrayList<Zombie> ataqueEspecial (ArrayList<Zombie> enemigos){
		System.out.println("La daga no tiene ataque especial");
		return enemigos;
	}
	
	public String toString() {
		return getArma() + ", tiene "+ getDamage() + ", alcance " + getAlcance() +" y acierto " + getAcierto() + ". Cuesta " + getValor();
	}
	
}