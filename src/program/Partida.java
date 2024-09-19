package program;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Partida {
	private float cash;// dinero del grupo de aventurereos
	private int nivel;// nivel de la partida
	private  ArrayList<Objeto> objetos;// usamos esta array como base de datos para sacar los objetos cuando buscan o compran
	private	 ArrayList<Arma> armas; // usamos esta array como base de datos para sacar las armas cuando buscan o compran
	private ArrayList<Zombie> zombie;// para alamazenar los zombies de cada ronda
	private String [] nombres= {"Calamidad","Carlos","Manolo","termoTanque","Segador de almas","Velocista","Errante","Fatonny","Sergio","TwinkHunter","Nigromante","Moab"}; // Una array de los nombres de Zombies para poder identificarlos mejor si hay mas de un tipo de zombie
	private int cont;
	
	Partida(int jugadores){
		zombie=new ArrayList<Zombie>();
		armas = new ArrayList<Arma>();
		objetos=new  ArrayList<Objeto>();
		setNivel(jugadores);
		cash = 0;
		setArmas();
		setObjetos();
	}
	
	
	
	public void setMonedas(float cash) {
		this.cash=cash;
	}
	public void setCont(int cont) {
		this.cont=cont;
	}
	
	public void setNivel(int nivel) {
		this.nivel=nivel;
	}
	
	public int getNivel() {
		return nivel;
	}

	public int getCont() {
		return cont;
	}
	
	public float getMonedas() {
		return cash;
	}
	// Funcion para corregir efectos en cada ronda
	public void contador(int nivel,ArrayList<Jugador> jugadores) {
		if(cont!=nivel) {
			Jugador jugador;
			for (int i = 0; i < jugadores.size(); i++) {
				jugador=jugadores.get(i);
				if(jugador.getestadoAlterado()!=false) {
					jugador.corrector();
				}
			}
		}
	}
	// settear los zombies cada ronda
	public void setZombie() {
		Random random= new Random();
		for (int i = 0; i < nivel; i++) {
			
			int num = random.nextInt(4);
			if(num == 3) {
				num = random.nextInt(4);
			}
			int nombreZombie;
			switch (num) {
			case 0:
				nombreZombie = random.nextInt(nombres.length);
				Corredor corredor = new Corredor(nombres[nombreZombie]);
				zombie.add(corredor);
				break;
			case 1:
				nombreZombie = random.nextInt(nombres.length);
				Caminante caminante = new Caminante(nombres[nombreZombie]);
				zombie.add(caminante);
				break;
			case 2:
				nombreZombie = random.nextInt(nombres.length);
				Gordo gordo = new Gordo(nombres[nombreZombie]);
				zombie.add(gordo);
				break;
			case 3:
				Nemesis nemesis = new Nemesis("nemesis");
				zombie.add(nemesis);
				break;

			default:
				break;
			}
		}
	}
	// Funcion para crear la base de datos de los objetos
	public void setObjetos() {
		Vendas venda = new Vendas();
		Botiquin botiquin = new Botiquin();
		Pocion_curacion curacion = new Pocion_curacion();
		Pocion_daño daño = new Pocion_daño();
		Lazo lazo = new Lazo();
		
		objetos.add(venda);
		objetos.add(botiquin);
		objetos.add(curacion);
		objetos.add(daño);
		objetos.add(lazo);
		
		
	}
	//Funcion para crear la base de datos de armas
	public void setArmas() {
		Arco arco = new Arco();
		Espada espada = new Espada();
		Hacha hacha = new Hacha();
		Hechizo hechizo = new Hechizo();
		Mandoble mandoble = new Mandoble();
		Bazuca bazuca = new Bazuca();
		Daga daga = new Daga();
	
		armas.add(arco);
		armas.add(espada);
		armas.add(hacha);
		armas.add(hechizo);
		armas.add(mandoble);
		armas.add(bazuca);
		armas.add(daga);
	}
	//Funcion de Ronda
	@SuppressWarnings("resource")
	public void ronda( ArrayList<Jugador> jugadores) {
		Scanner leer=new Scanner(System.in);
		int cont=0, nivelclase = nivel + 3;
		boolean rompedor=false;
		//Para preguntar si quiere seguir jugando y si quieres comprar
		while(rompedor==false) {
			if(cont>0) {
				System.out.println("\n¿Quieres jugar la siguiente ronda/nivel o acabar la partida? Pulsa 0 para seguir o 1 para salir ");
				int resp=leer.nextInt();
				if(resp==1) {
					rompedor=true;
					continue;
				}else {
					System.out.println(" El Mercader habre su venta al publico \n" + "¿Quieres aprobechar y pasar por su tienda ? Pulsa 1 para ir o 0 para pasar de ronda/nivel");
					int tienda=leer.nextInt();
					if(tienda==1) {
						tienda(jugadores);
					}
				}
			}
			contador(nivel,jugadores);
			setZombie();
			Jugador jugador;
			System.out.println("\n ¡Se hacerca una horda de zombies! Todos los supervivientes se ponen en sus puestos \n");
			for (int i = 0; i < jugadores.size(); i++) {
				jugador=jugadores.get(i);
				menu(zombie,cont,jugador);
				switch (leer.next()) {
				case "1":
					if(zombie.size() > 0) {
						atacar(jugador);
					}else {
						System.out.println("¡No puedes atacar a un zombie si no hay ninguno!");
						i--;
					}
					break;
				case "2":
					i = ataqueEspecial(jugador,jugadores,i);
					break;
				case "3":
					buscarObjeto(jugador);
					break;
				case "4":
					cambiarArmas(jugador);
					break;
				case "5":
					usarObjeto(jugador,jugadores,zombie);
					i--;
					break;
				case "0":
					System.out.println("Pasando");
					break;
				default:
					System.out.println("Error, no has seleccionado opción válida");
					i--;
					break;
				}
			}
			if(zombie.size()==0) {
				System.out.println("\n Habeis acabado con la horda de Zombies ¡Hurra por los No muertos! \n"
						  		  +"¡¿Pero que es eso que se ve a lo lejos?! ¡Una horda de zombies aún mayor! \n"
						          +"Sera mejor que os prepareis, la siguientes hordas serán más duras ");
				setNivel(getNivel()+1);
				resetAbility(jugadores);
				if(nivel == nivelclase) {
					seleccionarClase(jugadores);
				}
			}else {
				ataqueZombie(jugadores);
				for (int i = zombie.size()-1; i > -1; i--) {
					zombie.remove(i);
				}
				System.out.println("\n La horda de zombies se retira \n"
								  +"Pero no podeis aclamar victoria pues podeis ver que otra horda se acerca a lo lejos");
			}
			if(jugadores.size()== 0) {
				break;
			}
			cont=+1;
		}
		
	}
	
	//	Funcion de atacar
	public void atacar(Jugador jugador) {
		Random random= new Random();
		int num;
		Arma principal=jugador.getArma();
		for(int i = 0;i < principal.getAlcance();i++) {
			if(zombie.size()==0) {
				break;
			}
			num=random.nextInt(zombie.size());
			Zombie enemigo= zombie.get(num);
			if(principal.getDamage()>= enemigo.getsaludMax()) {
				int hit=random.nextInt(6);
				if(hit>=principal.getAcierto()) {
					cash+= enemigo.getValor();
					zombie=enemigo.antelaTumba(zombie,enemigo);
					System.out.println(enemigo.getTipo()+" esta muerto");
				}else {
					System.out.println(" Ha fallado con un "+ num + " contra " + enemigo);
				}
			}else {
				System.out.println( " Has fallado el ataque contra "+ enemigo);
			}
		}
		
	}
	
	//Funcion de ataque especial, llamamos de cada arma la funcion y la aplicamos dentro del juego
	public int ataqueEspecial(Jugador jugador, ArrayList<Jugador> jugadores, int idx) {
		Arma principal=jugador.getArma();
		if(principal.getHabilidad() == true) {
			System.out.println("Ya has usado la habilidad de esta arma");
		}else {
			cash = principal.valormuertes(zombie, cash);
			zombie = principal.ataqueEspecial(zombie);
			principal.setHabilidad(true);
			if (principal.getArma().compareToIgnoreCase("Bazuca") == 0) {
				System.out.println(jugador.getnombre() + " Ha muerto usando la habildad del Bazuca");
				jugadores.remove(jugador);
				idx--;
			}
		}
		return idx;

	}
	//Funcion para intercambiar el arma que usa el personaje
	@SuppressWarnings("resource")
	public  void cambiarArmas(Jugador jugador) {
		Scanner leer= new Scanner(System.in);
		System.out.println("Estas son las armas a escoger");
		Arma arma;
		for (int i = 0; i < jugador.getArrayArma().size(); i++) {
			arma=jugador.getArrayArma().get(i);
			System.out.println(i+"- "+arma.getArma());
		}
		int seleccion=leer.nextInt();
		jugador.setPrincipal(seleccion);
	}
	//Funcion de ataque de los zombies, buscan a un jugador random y le atacan
	public  void ataqueZombie(ArrayList<Jugador> jugadores) {
		Random random=new Random();
		Zombie actualzombie;
		for (int i = 0; i < zombie.size(); i++) {
			actualzombie = zombie.get(i);
			if(jugadores.size() > 0) {
				int objetivo = random.nextInt(jugadores.size());
				
				for (int j = 0; j < actualzombie.getMovimiento(); j++) {
					Jugador tarjet = jugadores.get(objetivo);
					int vida_daño = tarjet.getsaludMax() - actualzombie.getDaño();
					
					if(vida_daño <= 0) {
						jugadores.remove(tarjet);
						System.out.println("Han matado a "+ tarjet.getnombre());
						if(jugadores.size() > 0) {break;}
					}
					System.out.println( actualzombie + "a atacado a " +tarjet.getnombre()+ " y le ha quedado con "+vida_daño +" de vida \n");
					tarjet.setsaludMax(vida_daño);
					if(jugadores.size() > 0) {break;}
				}
			}else {
				System.out.println("\n Todos los supervivientes han muerto \n");
			}

		}
	}
	
	// Funcion que nos permite seleccionar objeto del inventario de su jugador, luego al usar el objeto se elimina
	@SuppressWarnings("resource")
	public void usarObjeto(Jugador jugador,ArrayList<Jugador> jugadores, ArrayList<Zombie> zombies) {
		Scanner leer=new Scanner(System.in);
		
		System.out.println("Estos son los objetos de los que dispones");
		for (int i = 0; i <jugador.getArrayObjeto().size() ; i++) {
			System.out.println(i+"-"+jugador.getArrayObjeto().get(i));
		}
		int var=leer.nextInt();
		Objeto objeto=jugador.getArrayObjeto().get(var);
		if(objeto.getType()=="utilidad") {
			if(objeto.getNombre()=="Botiquin" || objeto.getNombre()=="vendas" || objeto.getNombre()=="Pocion de curacion") {
				Jugador jugadorCurar;
				System.out.println("Que Superviviente quieres curar?");
				for(int i = 0; i< jugadores.size();i++){
					jugadorCurar = jugadores.get(i);
					System.out.println(i + " - " + jugadorCurar);
				}
				int idx = leer.nextInt();
				jugadorCurar = jugadores.get(idx);
				objeto.utilidad(jugadorCurar);
			}else {
				objeto.utilidad(jugador);
			}

		}else {
			objeto.ofensivo(zombies);
		}
		
		jugador.getArrayObjeto().remove(objeto);
	}

//Funcion de la tienda, aqui puedes comprar armas y objetos para usar en la partida, cuando compras un objeto escoges a que jugador darselo
	@SuppressWarnings("resource")
	public void tienda(ArrayList<Jugador> jugadores) {
		Scanner leer = new Scanner(System.in);
		boolean bucle=true;
		Jugador jugador;
		while(bucle) {
			System.out.println("Que objeto quieres comprar? \n"						
			+"Tienes: " + cash + " Monedas \n" 
			+"1 - Armas \n"
			+"2 - Objetos \n"
			+"0 - salir \n");
			switch(leer.next()) {
			case "1":
				System.out.println("Armas: ");
				Arma arma;
				
				for (int i = 0; i < armas.size(); i++) {
					arma=armas.get(i);
					System.out.println(i + "- " + arma);
					
				}int selec=leer.nextInt();
				if(selec >= armas.size() || selec < 0) {
					System.out.println("Eso no es un Arma de mi Tienda");
					break;
				}
				arma=armas.get(selec);
				
				if(arma.getValor()>cash) {
					System.out.println("No tienes suficiente dinero para comprar este objeto!!");
					continue;
					
				}else {
					setMonedas(cash-arma.getValor());
					
				}System.out.println("A que jugador quieres equiparle la nueva adquisicion?");
				
				
				for (int i = 0; i < jugadores.size(); i++) {
					jugador=jugadores.get(i);
					System.out.println(i+"- "+ jugador.getnombre());
					
				}int perso=leer.nextInt();
				jugador=jugadores.get(perso);
				jugador.getArrayArma().add(arma);
				break;
			
			case "2":
				System.out.println("Objetos: ");
				Objeto objeto;
				
				for (int i = 0; i < objetos.size(); i++) {
					objeto=objetos.get(i);
					System.out.println(i+"- "+ objeto);
					
				}int aggar=leer.nextInt();
				if(aggar >= armas.size() || aggar < 0) {
					System.out.println("Eso no es un Objeto de mi Tienda");
					break;
				}
				objeto=objetos.get(aggar);
				
				if(objeto.getValor()>cash) {
					System.out.println("No tienes suficiente dinero para comprar este objeto!!");
					continue;
					
				}else {
					setMonedas(cash-objeto.getValor());
					
				}System.out.println("A que jugador quieres equiparle la nueva adquisicion?");
				
				
				for (int i = 0; i < jugadores.size(); i++) {
					jugador=jugadores.get(i);
					System.out.println(i+"- "+ jugador.getnombre());
					
				}int equip=leer.nextInt();
				jugador=jugadores.get(equip);
				jugador.getArrayObjeto().add(objeto);
				System.out.println(jugador.getArrayObjeto().get(0));
				break;
			case "0":
				bucle=false;
				break;
				
			default:
				System.out.println("Escoje una opcion valida");
			break;
			}
		}
	}
	
	
//Funcion de buscar en tu entorno, puede conseguir armas y objetos
	public void buscarObjeto(Jugador jugador){
		Random random = new Random();
		Arma arma;
		Objeto objeto;
		if(random.nextInt(2) == 0) {
			switch(random.nextInt(6)){//Caso para Armas
			case 0://Caso de Arco
				arma=armas.get(0);
				jugador.setArma(arma);
				System.out.println(jugador.getnombre() +" Ha encontrado un " + arma.getArma() + " y lo ha guardado en su inventario");
				break;
			case 1://Caso de Espada
				arma=armas.get(1);
				jugador.setArma(arma);
				System.out.println(jugador.getnombre() +" Ha encontrado una " + arma.getArma() + " y la ha guardado en su inventario");
				break;
			case 2://Caso de Hacha
				arma=armas.get(2);
				jugador.setArma(arma);
				System.out.println(jugador.getnombre() +" Ha encontrado un " + arma.getArma() + " y la ha guardado en su inventario");
				break;
			case 3://Caso de Hechizo
				arma=armas.get(3);
				jugador.setArma(arma);
				System.out.println(jugador.getnombre() +" Ha encontrado un " + arma.getArma() + " y la ha guardado en su inventario");
				break;
			case 4://Caso de Mandoble
				arma=armas.get(4);
				jugador.setArma(arma);
				System.out.println(jugador.getnombre() +" Ha encontrado un " + arma.getArma() + " y lo ha guardado en su inventario");
				break;
			case 5://Caso de Daga
				arma = armas.get(6);
				jugador.setArma(arma);
				System.out.println(jugador.getnombre() +" Ha encontrado " + arma.getArma() + " y la ha guardado en su inventario");
				break;
				}
		}else {
			switch(random.nextInt(5)){//Caso para Objetos
			case 0://Caso para Vendas
				objeto = objetos.get(0);
				jugador.setArrayObjeto(objeto);
				System.out.println(jugador.getnombre() +" Ha encontrado unas " + objeto.getNombre() + " y las ha guardado en su inventario");
				break;
			case 1://Caso para Botiquin
				objeto = objetos.get(1);
				jugador.setArrayObjeto(objeto);
				System.out.println(jugador.getnombre() +" Ha encontrado un " + objeto.getNombre() + " y lo ha guardado en su inventario");
				break;
			case 2://Caso para Pocion de Curación
				objeto = objetos.get(2);
				jugador.setArrayObjeto(objeto);
				System.out.println(jugador.getnombre() +" Ha encontrado una " + objeto.getNombre() + " y la ha guardado en su inventario");
				break;
			case 3://Caso para Pocion de Daño
				objeto = objetos.get(3);
				jugador.setArrayObjeto(objeto);
				System.out.println(jugador.getnombre() +" Ha encontrado una " + objeto.getNombre() + " y la ha guardado en su inventario");
				break;
			case 4://Caso para Lazo
				objeto = objetos.get(4);
				jugador.setArrayObjeto(objeto);
				System.out.println(jugador.getnombre()  +" Ha encontrado un " + objeto.getNombre() + " y lo ha guardado en su inventario");
				break;
			}
		}
	}
	
	//Funcion para resetear habilidad especial 
	public void resetAbility(ArrayList<Jugador> jugadores){
		Jugador jugador;
		
		for (int i = 0; i < jugadores.size()-1; i++) {
			jugador = jugadores.get(i);
			Arma arma;
			for(int j = 0; j < jugador.getArrayArma().size(); j++) {
				arma = jugador.getArrayArma().get(j);
				if(arma.getHabilidad()==true) {
					arma.setHabilidad(false);
				}
			}
		}
	}
	
	
	//Funcion para hacer que los personajes obtengan una clase al haber pasado 3 niveles enteros.
	@SuppressWarnings("resource")
	public void seleccionarClase(ArrayList<Jugador> jugadores){
		Scanner leer = new Scanner(System.in);
		Jugador jugadorClase;
		boolean bucle;
		System.out.println("\n Los Supervivientes han sobrevivido a suficientes hordas de zombies, \n" 
						 + "ahora se sienten capaces de especializarse en una clase \n"
						 + "Escoje una Clase para cada Supervivientes");
		for(int i = 0; i < jugadores.size();i++) {
			jugadorClase = jugadores.get(i);
			bucle = true;
			while(bucle){
				System.out.println(" ¿Que clase quieres que sea " + jugadorClase.getnombre() + "? \n" 
								+ " 1 - Tanque (Su vida Maxima sube a 7) \n"
								+ " 2 - Médico (Obtiene 2 botiquines) \n"
								+ " 3 - Mago (Obtiene un Hechizo) \n"
								+ " 4 - Arquero (Obtiene un Arco) \n"
								+ " 0 - No darle clase (No recomendado)");
				switch(leer.next()) {
				case "1":
					System.out.println(jugadorClase.getnombre() + " Ahora es Tanque y se ha curado al maximo de su vida.");
					jugadorClase.setsaludMax(7);
					jugadorClase.setsaludDef(7);
					jugadorClase.setClase(true);
					bucle = false;
					break;
				case "2":
					System.out.println(jugadorClase.getnombre() + " Ahora es Médico/a y se ha curado al maximo de su vida");
					Objeto objeto;
					objeto = objetos.get(1);
					jugadorClase.setsaludMax(jugadorClase.getsaludDef());
					jugadorClase.setArrayObjeto(objeto);
					jugadorClase.setArrayObjeto(objeto);
					jugadorClase.setClase(true);
					bucle = false;
					break;
				case "3":
					System.out.println(jugadorClase.getnombre() + " Ahora es Mago/a y se ha curado al maximo de su vida");
					jugadorClase.setsaludMax(jugadorClase.getsaludDef());
					jugadorClase.setArma(armas.get(3));
					jugadorClase.setClase(true);
					bucle = false;
					break;
				case "4":
					System.out.println(jugadorClase.getnombre() + " Ahora es Arquero/a y se ha curado al maximo de su vida");
					jugadorClase.setsaludMax(jugadorClase.getsaludDef());
					jugadorClase.setArma(armas.get(0));	
					jugadorClase.setClase(true);
					bucle = false;
					break;
				case "0":
					System.out.println(jugadorClase.getnombre() + " No se ha especializado en nada pero al menos se ha curado al maximo de su vida");
					jugadorClase.setsaludDef(jugadorClase.getsaludMax());
					bucle = false;
					break;
				default:
					System.out.println("Introduce un valor permitido");
				}
			}
			
			
			
			
		}
	}
	
	//Menu de la funcion ronda
	public void menu(ArrayList<Zombie> zombie, int ronda,Jugador jugador) {
		System.out.print(
		"|------------------------------ Nivel: " + getNivel() + " : " + ronda + " ------------------------------| \n" 
		+ "==|");
		
		for (int i=0;i<zombie.size();i++) {  
			System.out.print(zombie.get(i));
		} 
		
		System.out.print( "|== \n"
		+ "JUGADOR:" + jugador + "\n" 
		+ "  1- Atacar \n "
		+ " 2- Ataque especial \n " 
		+ " 3- Buscar \n " 
		+ " 4- Cambiar Arma \n " 
		+ " 5- Usar Objeto \n"
		+ "  0- Pasar \n"
		+ "|--------------------------------------------------------------------------| \n");
	}

	
}
 
 