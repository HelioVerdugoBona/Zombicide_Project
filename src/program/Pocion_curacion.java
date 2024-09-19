package program;

public class Pocion_curacion extends Objeto{

	Pocion_curacion(){
		super.setValor(20);
		super.setEfecto(7);
		super.setNombre("Pocion de curacion");
		super.setType("utilidad");
	}
	
	@Override
	public String toString(){
		return " Pocion de Curación, cura " + super.getEfecto()  + " y cuesta " + super.getValor() + "";
	}
}
