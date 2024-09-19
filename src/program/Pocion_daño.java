package program;

public class Pocion_daño extends Objeto {
	
	Pocion_daño(){
		super.setValor(18);
		super.setEfecto(1);
		super.setNombre("Pocion de daño");
		super.setType("utilidad");
	}
	
	//Funcion que permite subirte el daño
	@Override
	public void utilidad(Jugador jugador) {
		Arma arma=jugador.getArma();
		jugador.setRetorno(arma.getDamage());
		arma.setDamage(arma.getDamage()+getEfecto());
		System.out.println(jugador.getnombre()+"ahora hace "+ jugador.getArma().getDamage()+" de daño");
	}


	@Override
	public String toString(){
		return " Pocion de Daño, Aumenta el daño en " + super.getEfecto()  + " y cuesta " + super.getValor() + "";
	}
}