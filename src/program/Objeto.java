package program;

import java.util.ArrayList;
//Clase padre de objetos
public class Objeto {
	private float valor; // precio de objeto
	private int efecto;	//efecto de objeto(suelen ser numeros sin causa, la funcion del objeto ya usara este numero para hacer cosas
	private String nombre;
	private String type; // indetificar que tipo de objeto es, de momento solo hay los de soporte(suelen ser todos de curacion o potenciadores) o los ofensivos(debuffos para los zombies)
	
	public void setValor(float valor) {
		this.valor=valor;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public String getType() {
		return type;
	}
	
	public void setEfecto(int efecto) {
		this.efecto = efecto;
	}
	public int getEfecto() {
		return efecto;
	}
	
	//Funcion que comparten casi todos los objetos de soporte por ello esta en el padre)
	public void utilidad(Jugador jugador) {
		jugador.setsaludMax(jugador.getsaludMax()+efecto);
		if(jugador.getsaludMax()+efecto>jugador.getsaludDef()) {
			jugador.setsaludMax(jugador.getsaludDef());
		}else {
			jugador.setsaludMax(jugador.getsaludMax()+efecto);
			
		}
		System.out.println(jugador.getnombre()+ " tiene "+ jugador.getsaludMax()+" de vida");
	}
	// Declaramos la funcion que usaremos en los ofensivos, como los ofensivos suelen ser muy especiales en si solo declaramos y en cada objeto se detalla
	public void ofensivo( ArrayList<Zombie> zombies) {
		
	}
	
}
