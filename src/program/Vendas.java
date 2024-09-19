package program;

public class Vendas  extends Objeto{
	
	Vendas(){
		setValor(5);
		setEfecto(1);
		setNombre("vendas");
		super.setType("utilidad");
	}
	
	@Override
	public String toString(){
		return " Vendas, cura " + super.getEfecto()  + " y cuesta " + super.getValor() + "";
	}
}