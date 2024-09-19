package program;

public class Botiquin extends Objeto {
//Objeto Botiquin
	Botiquin(){
		setValor(8);
		setEfecto(2);
		super.setNombre("Botiquin");
		super.setType("utilidad");
	}
	
	@Override
	public String toString(){
		return " Botiquin, cura " + super.getEfecto()  + " y cuesta " + super.getValor() + "";
	}
}
