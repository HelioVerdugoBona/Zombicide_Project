package program;

import java.util.ArrayList;
import java.util.Scanner;


public class Juego {
	public static ArrayList<Arma> arma;
	public static ArrayList<Jugador> jugador;

	public static void main(String[] args) {
		arma = new ArrayList<Arma>();
		jugador = new ArrayList<Jugador>();
		setArmas();
		setBasicPlayers();
		Scanner leer = new Scanner(System.in);
		boolean bucle = true;
		while (bucle) {
			printZombicide();
			printMenu();
			switch(leer.nextLine()) {
			case "1":
				selectGroup();
				continue;
				
			case "2":
				if(jugador.size() < 10) {
					newPlayer();
					continue;

				}else {
					System.out.println("\nYa has creado el maximo de Supervivientes\n");
					continue;
				}
				
			case "3":
				menuReglas();
				continue;
			case "0":
				System.out.println("\n Fin del Juego \n");
				bucle = false;
				break;
				
			default:
				System.out.println("\n Error, introduce un valor valido \n");
				
			}
		}
		leer.close();
	}
	
	// es el Cartel
	public static void printZombicide() {
		System.out.println("|------------------------------------------------------Welcome To------------------------------------------------------| \n"
		+ " ________     ______       __       __      ______    ________     _______     ________     _______      ________        \n"
		+ "|_____   |   /   _  \\     |  \\     /  |    |   _  \\  |__    __|   /   ____\\   |__    __|   |  ___  \\    |   _____|  \n"
		+ "     /  /    |  | |  |    |   \\___/   |    |  |_/ /     |  |      |  /           |  |      |  |   \\ \\   |  |         \n"
		+ "    /  /     |  | |  |    |  |\\___/|  |    |_____/      |  |      |  |           |  |      |  |   | |   |   -----|     \n"
		+ "  /  /       |  | |  |    |  |     |  |    |  _ \\       |  |      |  |           |  |      |  |   | |   |   -----|      \n"
		+ " /  /___     |  |_|  |    |  |     |  |    | |_\\ \\    __|  |__    |  \\_____    __|  |__    |  |__/ /    |  |_____     \n"
		+ "|_______|     \\_____/     |__|     |__|    |_____/   |________|    \\______/   |________|   |______/     |________|   \n \n"
		+"|----------------------------------------------------------------------------------------------------------------------|\n");
	}
	
	//menu del juego
	public static void printMenu() {
		System.out.println("1- Nueva Partida \n"
						 + "2- Nuevo Personaje \n"
						 + "3- Manual del Superviviente \n"
						 + "0- Salir \n");
	}
	
	//Funcion de creacion de nuevo jugador
	@SuppressWarnings("resource")
	public static void newPlayer() {
		System.out.println("\n Introduce el nombre del nuevo Superviviente \n");
		String nombreSuperviviente = new Scanner(System.in).nextLine();
		Jugador jugadornuevo = new Jugador(nombreSuperviviente,5,arma.get(0));
		jugador.add(jugadornuevo);
		
	}
	
	// Funcion en en caso de que el jugador no quiera entrar a crear su grupo empiezas con este equipo como "default"
	public static void setBasicPlayers(){
		Jugador jugador1 = new Jugador("James",7,arma.get(5));
		Jugador jugador2 = new Jugador("Marie",5,arma.get(0));
		Jugador jugador3 = new Jugador("Jaci",5,arma.get(0));
		jugador.add(jugador1);
		jugador.add(jugador2);
		jugador.add(jugador3);
	}
	
	// Settear armas para añadir a los jugadores
	public static void setArmas() {
		Daga daga = new Daga();
		Arco arco = new Arco();
		Espada espada = new Espada();
		Hacha hacha = new Hacha();
		Hechizo hechizo = new Hechizo();
		Mandoble mandoble = new Mandoble();
		Bazuca bazuca = new Bazuca();
		
		arma.add(daga);
		arma.add(arco);
		arma.add(espada);
		arma.add(hacha);
		arma.add(hechizo);
		arma.add(mandoble);
		arma.add(bazuca);
	}
	
	//Funcion Manual del juego, muy detallado
	@SuppressWarnings("resource")
	public static void menuReglas() {
		Scanner leer = new Scanner(System.in);
		boolean bucle = true;
		boolean bucle2;
		while(bucle) {
			System.out.println("|----Manual del Superviviente----| \n"
					  		 + " ¿Que Reglas deseas conocer? \n"
					  		 + "  1 - Reglas Generales \n"
					  		 + "  2 - Reglas de los Personajes \n"
					  		 + "  3 - Reglas de los Zombies \n"
					  		 + "  4 - Reglas de los Armas \n"
					  		 + "  5 - Reglas de las Objetos \n"
					  		 + "  6 - Reglas de las Clases\n"
					  		 + "  0 - Volver al menu principal \n"
					  		 + "|--------------------------------|");
			switch(leer.next()) {
			case "1":
				System.out.println(" Cada partida termina cuando un jugador decide abandonar entre rondas o niveles o cuando todos sus personajes han muerto. \n" 
								 + " Cada Ronda los zombies actuales huiran y apareceran otros nuevos. \n" 
								 + " Apareceran tantos zombies como el nivel actual. \n"
								 + " Cada cierto tiempo aparecera un zombie especial que se llama Nemesis, el cual estara en rojo y es un jefe. \n"
								 + " Este es más dificíl de matar, pero dara suficientes Monedas como para comrar el Bazuca \n"
								 + " (Siquires saber como funcionan ambos ves a sus respectivos apartados). \n"
								 + " Entre rondas y niveles siempre aparece el Mercader, un extraño tipo que vende armas \n"
								 + " a cambio de Monedas, el cual hoy en dia ha perdido su valor para todo el mundo excepto el. \n");
				break;
			case "2":
				System.out.println("|------------------------------------------------Humanos----------------------------------------------| \n"
								 + " = Empezaras todas tus partidas con un grupo de 3 jugadores minimo , James, Jaci y Marie \n" 
								 + " = Adicionalmente podras crear hasta 7 jugadores más, haciendo un total de 10 \n"
								 + " = Cuando empieces una partida podras escojer hasta un maximo de 6 jugadores a la vez \n"
								 + " = Dichos jugadores empezaran con 5 de vida, exceptuando James que tiene 7 \n"
								 + " = Dichos jugadores empezaran con una Daga como arma, exceptuando James que empieza con un Mandoble \n"
								 + "|-----------------------------------------------------------------------------------------------------| \n");
				break;
			case "3":
				bucle2 = true;
				while(bucle2) {
					System.out.println("|------------------------------------------------Zombies----------------------------------------------| \n"
									 + " = Los Zombies atacan despues de los jugadores \n"
									 + " = Los Zombies tienen una habilidad especial que puede aparecer despues de morir \n" 
									 + " = Los Zombies se cambian y vuelven a aparecer al principio de cada ronda y de cada nivel \n"
									 + " = Cuando todos los Zombies mueren se pasa de nivel \n "
									 + " = Hay cuatro tipos de Zombies distintos: \n"
									 + "     1. Corredores \n" 
									 + "     2. Caminantes \n"
									 + "     3. Gordos \n"
									 + "     4. Jefe (Nemesis) \n"
									 + " = ¿De cual quieres saber más? (0 si no quieres saber de ninguno) \n"
									 + "|-----------------------------------------------------------------------------------------------------| \n");
					switch(leer.next()){
					case "1":
						System.out.println("|----------------------Corredor------------------------| \n"
										 + " Descripción: Zombie rapido con vida baja \n"
										 + " Estadisticas: Salud 1, Velocidad 2, Daño 1 \n"
										 + " Abilidad al Morir: Mata al resto de corredores \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "2":
						System.out.println("|----------------------Caminante-----------------------| \n"
										 + " Descripción: Zombie normal \n"
										 + " Estadisticas: Salud 1, Velocidad 1, Daño 1 \n"
										 + " Abilidad al Morir: Revive el mismo numero caminantes \n" 
										 + " como los que haya en ese momento en el campo \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "3":
						System.out.println("|------------------------Gordo-------------------------| \n"
										 + " Descripción: Zombie rapido con vida baja \n"
										 + " Estadisticas: Salud 2, Velocidad 1, Daño 1 \n"
										 + " Abilidad al Morir: Mata a otro Gordo \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "4":
						System.out.println("|--------------------Jefe(Nemesis)---------------------| \n"
										 + " Descripción: Zombie rapido con vida baja \n"
										 + " Estadisticas: Salud 5, Velocidad 2, Daño 1 \n"
										 + " Abilidad al Morir: Se desconoce \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "0":
						bucle2= false;
						break;
						default:
							System.out.println("Introduce un valor valido");
						
					}
				}
				break;
			case "4":
				bucle2 = true;
				while(bucle2) {
					System.out.println("|------------------------------------------------Armas----------------------------------------------| \n"
									 + " = Lar Armas tienen habilidades especiales que solo se pueden usar una vez por nivel \n" 
									 + " = Las Armas se pueden obtener de dos formas distintas: \n"
									 + "     1. Encontrandolas en batalla \n "
									 + "    2. Comprarselas al Mercader por un modico precio \n"
									 + " = ¿Quieres saber las estadisticas de algun arma en concreto? (0 si no quieres saber de ninguna) \n"
									 + "    1. Daga \n"
									 + "    2. Espada \n"
									 + "    3. Hacha \n"
									 + "    4. Mandoble \n"
									 + "    5. Hechizo \n"
									 + "    6. Arco \n"
									 + "    7. Bazuca \n"
									 + "|---------------------------------------------------------------------------------------------------| \n");
					
					switch(leer.next()){
					case "1":
						System.out.println("|------------------------Daga--------------------------| \n"
										 + " Precio: No tiene  \n"
										 + " Estadisticas: Acierto 4, Alcance 2, Daño 1 \n"
										 + " Abilidad Especial: No tiene \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "2":
						System.out.println("|------------------------Espada------------------------| \n"
										 + " Precio: 8 Monedas \n"
										 + " Estadisticas: Acierto 4, Alcance 1, Daño 1 \n"
										 + " Abilidad Especial: Mata a 2 zombies aleatorios \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "3":
						System.out.println("|------------------------Hacha-------------------------| \n"
										 + " Precio: 20 Monedas \n"
										 + " Estadisticas: Acierto 3, Alcance 1, Daño 2 \n"
										 + " Abilidad Especial: Mata a 1 gordo \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "4":
						System.out.println("|----------------------Mandoble------------------------| \n"
										 + " Precio: 25 Monedas \n"
										 + " Estadisticas: Acierto 4, Alcance 1, Daño 2 \n"
										 + " Abilidad Especial: Mata a 2 Corredores \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "5":
						System.out.println("|-----------------------Hechizo------------------------| \n"
										 + " Precio: 10 \n"
										 + " Estadisticas: Acierto 4, Alcance 1, Daño 2 \n"
										 + " Abilidad Especial: Mata a 2 caminantes \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "6":
						System.out.println("|------------------------Arco--------------------------| \n"
										 + " Precio: 18 \n"
										 + " Estadisticas: Acierto 3, Alcance 1, Daño 2 \n"
										 + " Abilidad Especial: Mata a 1 corredor \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "7":
						System.out.println("|------------------------Bazuca------------------------| \n"
										 + " Precio: 50 (Esta arma solo se puede comprar)\n"
										 + " Estadisticas: Acierto 4, Alcance 1, Daño 2 \n"
										 + " Abilidad Especial: Mata  a todos los zombies \n"
										 + " (portador de esta arma incuido la mayoria de las veces) \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "0":
						bucle2= false;
						break;
						default:
							System.out.println("Introduce un valor valido");
						
					}
				}
				break;
			case "5":
				bucle2 = true;
				while(bucle2) {
					System.out.println("|------------------------------------------------Objetos----------------------------------------------| \n"
							 + " = Los Objetos son facilitadores a la hora se sobrevivir más rondas en Zombicide \n"
							 + " = Los Objetos se pueden obtener comprandose o buscando en mitad de una ronda \n" 
							 + " = ¿Quieres saber las estadisticas de algun objeto en concreto? (0 si no quieres saber de ninguno)\n" 
							 + "    1. Vendas \n" 
							 + "    2. Botiquin \n"  
							 + "    3. Poción de Curación \n"
							 + "    4. Poción de Daño \n"
							 + "    5. Lazo \n"
						     + "|-------------------------------------------------------------------------------------------------------------| \n");
						switch(leer.next()){
					case "1":
						System.out.println("|-----------------------Vendas-------------------------| \n"
										 + " Precio: 5 Monedas \n"
										 + " Estadisticas: Cura 1 de vida \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "2":
						System.out.println("|-----------------------Botiquin-----------------------| \n"
										 + " Precio: 8 Monedas \n"
										 + " Estadisticas: Cura 2 de vida \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "3":
						System.out.println("|-----------------Poción de Curación-------------------| \n"
										 + " Precio: 20 Monedas \n"
										 + " Estadisticas: Cura 7 de vida \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "4":
						System.out.println("|--------------------Poción de Daño--------------------| \n"
										 + " Precio: 18 Monedas \n"
										 + " Estadisticas: Suma 1 al daño de tu arma actual \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "5":
						System.out.println("|-------------------------Lazo-------------------------| \n"
										 + " Precio: 14 Monedas \n"
										 + " Estadisticas: Quita en 1 la velocidad de un Zombie \n"
										 + "|------------------------------------------------------| \n");
						break;
					case "0":
						bucle2 = false;
						break;
					default:
						System.out.println("Introduce un valor valido");
					}
				}
				break;
			case "6":
				bucle2 = true;
				while(bucle2) {
					System.out.println("|------------------------------------------------Clases----------------------------------------------| \n"
							 + " = Los Supervivientes tras haber sobrevivido a 3 niveles obtendran una especialización o clase\n"
							 + " = Según la clase que escojan obtendan una ventaja u otra. \n" 
							 + " = ¿Quieres saber las estadisticas de alguna clase en concreto? (0 si no quieres saber de ninguno)\n" 
							 + "    1. Tanque \n" 
							 + "    2. Médico/a \n"  
							 + "    3. Mago/a \n"
							 + "    4. Arquero/a \n"
						     + "|-------------------------------------------------------------------------------------------------------------| \n");
						switch(leer.next()){
					case "1":
						System.out.println("|--------------Tanque--------------| \n"
										 + " Tu vida maxima pasa a ser 7 \n"
										 + " Te curas tu vida maxima \n"
										 + "|----------------------------------| \n");
						break;
					case "2":
						System.out.println("|--------------Médico/a--------------| \n"
										 + " Obtienes 2 botiquines \n"
										 + " Te curas tu vida maxima \n"
										 + "|----------------------------------| \n");
						break;
					case "3":
						System.out.println("|--------------Mago/a--------------| \n"
										 + " Obtienes el arma Hechizo \n"
										 + " Te curas tu vida maxima \n"
										 + "|----------------------------------| \n");
						break;
					case "4":
						System.out.println("|--------------Arquero/a--------------| \n"
										 + " Obtienes el arma Arco \n"
										 + " Te curas tu vida maxima \n"
										 + "|----------------------------------| \n");
						break;
					case "0":
						bucle2 = false;
						break;
					default:
						System.out.println("Introduce un valor valido");
					}
				}
				break;
			case "0":
				System.out.println("Buena suerte, la necesitaras");
				bucle = false;
				break;
			default:
				System.out.println("Introduce un valor valido");
			}
		}	 
	}
	
	// Funcion encargada de seleccionar al grupo que seran tus supervivientes
	@SuppressWarnings("resource")
	public static void selectGroup() {
		Scanner leer = new Scanner(System.in);
		Jugador grupo;
		int countTotalSelected = 0;
		if(jugador.size() > 3) {// Si hay mas de 3 personajes
			for(int i=0; i<jugador.size();i++) {
				grupo = jugador.get(i);
				System.out.println(i + " - " + grupo);
				
			}System.out.println("Cuantos supervivienrtes quieres seleccionar? minimo 3 y maximo 6");
			int numJugadores = leer.nextInt() , idx;
			if(numJugadores <= 6 && numJugadores >= 3) {
				
				if (numJugadores == jugador.size()) {//Si el numero seleccionado es igual a la cantidad total de supervivientes se seleccionan todos automaticamente.
					Partida partida = new Partida(jugador.size());
					partida.ronda(jugador); 
					
				}else {
					ArrayList<Jugador> grupoJugadores = new ArrayList<Jugador>();
					System.out.println("¡Perfecto! Seleccione sus supervivientes");
					for(int i = 0; i < numJugadores;i++){
						countTotalSelected = numJugadores - i;
						System.out.println("Te faltan " + countTotalSelected + " Jugadores por seleccionar");
						idx = leer.nextInt();
						grupoJugadores.add(jugador.get(idx));
						System.out.println(jugador.get(idx) + " se ha unido a tu grupo");
						
					}System.out.println("Todos tus personajes han sido seleccionados");
					Partida partida= new Partida(grupoJugadores.size());
					partida.ronda( grupoJugadores);}
				
			}else System.out.println("El numero introducido no entra dentro de lo pedido");
			
		}else {// Si hay menos de 3 personajes
				Partida partida= new Partida(jugador.size());
				partida.ronda( jugador);
		}
		if(jugador.size() == 0) {
			setBasicPlayers();
		}
			
	}
}
	

