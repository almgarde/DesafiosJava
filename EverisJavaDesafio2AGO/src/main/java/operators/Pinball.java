package operators;

/**
 *  Clase Scanner
 */
import java.util.Scanner;

/**
 *  Clases Loggers
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase NumberUtils
 */
import org.apache.commons.lang3.math.NumberUtils;

public class Pinball {

	/**
	 * Logger
	 */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * Scanner: entrada por teclado
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * namePlayer: Player's name
	 */
	private String namePlayer;

	/**
	 * pointsObstacle: Points for each obstacle that is hit
	 */
	private int pointsObstacle = 0;

	/**
	 * pointsBall: Total points scored for a ball
	 */
	private int pointsBall = 0;

	/**
	 * pointsGame: Total game points
	 */
	private int pointsGame = 0;

	/**
	 * numLifes: Number of launches
	 */
	private int numLifes = Constants.LIFES;

	/**
	 * answerPlayer: confirm or not if a player wants to play again
	 */
	private String answerPlayer = "";

	/**
	 * b: Ball-type element
	 */
	private Ball b;

	/**
	 * bv: green ball-type element
	 */
	private GreenBall bv;

	/**
	 * ba: blue ball-type element
	 */
	private BlueBall ba;

	/**
	 * orange ball-type element
	 */
	private OrangeBall bn;

	/**
	 * mc: mucus type element
	 */
	private Mucus mc;

	/**
	 * @return namePlayer
	 */
	public String getNamePlayer() {
		return namePlayer;
	}

	/**
	 * @return numLifes
	 */
	public int getNumLifes() {
		return numLifes;
	}

	/**
	 * @return answerPlayer
	 */
	public String getAnswerPlayer() {
		return answerPlayer;
	}

	/**
	 * initGame: Start the game
	 */
	public void initGame() {

		LOGGER.info("Inicio del método initGame");
		// Almacenamiento del nombre del jugador

		System.out.println("¡ Bienvenido a Pinball ! Para comenzar diga su nombre: ");
		namePlayer = sc.nextLine();

		// Instrucciones

		System.out.println(" Hola " + getNamePlayer() + " ! ");
		System.out.println("Antes de nada lea las siguientes instrucciones: ");
		System.out.println("1 - Escoja una opción del menú.");
		System.out.println("2 - Si escoge la opción lanzar una bola, ésta se lanzará (o no) golpeando " + Constants.TOTALOBSTACLES
		        + " obstáculos escogidos al azar. Algunos dan puntos, otros restan y también tenemos el retrete por donde perderemos la bola...");
		System.out.println("3 - Tiene " + Constants.LIFES + " lanzamientos.");
		System.out.println("4 - La opción 2 te muestra los puntos conseguidos hasta el momento y los lanzamientos que te quedan. ");
		System.out.println("5 - Puedes salir del juego en cualquier momento.");
		System.out.println("¡ Buena suerte !");

		LOGGER.info("Fin del método initGame");
	}

	/**
	 * takeOutBall: select a ball
	 */
	public void takeOutBall() {

		LOGGER.info("Inicio del método takeOutBall");

		// Genera un número aleatorio

		int resultBall = (int) (Math.random() * 200 + 1);
		LOGGER.debug("La variable resultBall es " + resultBall);

		// Genera una bola verde

		if (resultBall >= 0 && resultBall <= 50) {
			b = new GreenBall();
			System.out.println("Le ha tocado una bola verde . Allá vamos! ");
			pointsGame += launchBall();
		}

		// Genera una bola azul

		if (resultBall > 50 && resultBall <= 100) {
			b = new BlueBall();
			System.out.println("Le ha tocado una bola azul. Allá vamos! ");
			pointsGame += launchBall();
		}

		// Genera una bola naranja

		if (resultBall > 100 && resultBall <= 150) {
			b = new OrangeBall();
			System.out.println("Le ha tocado una bola naranja. Allá vamos! ");
			pointsGame += launchBall();
		}

		// Genera un moco

		if (resultBall > 150 && resultBall <= 200) {
			mc = new Mucus();
			System.out.println("Upss! Ha salido un moco!");
			pointsBall = 0;
		}
		LOGGER.info("Fin del método takeOutBall");
	}

	/**
	 * lauchBall: throw a ball
	 * 
	 * @return finalPointsBall
	 */
	public int launchBall() {

		LOGGER.info("Inicio del método launchBall");

		// Selección de los obstáculos golpeados

		for (int i = 0; i < Constants.TOTALOBSTACLES; i++) {

			// Genera un número aleatorio

			int result = (int) (Math.random() * 250 + 1);

			LOGGER.debug("La variable result es: " + result);

			// Obstáculo 1

			if (result >= 0 && result <= 50) {
				System.out.println("Has golpeado el obstáculo 1. Ganas " + Constants.POINTSOBSTACLE1 + " puntos");
				pointsObstacle = Constants.POINTSOBSTACLE1;
			}

			// Obstáculo 2

			if (result > 50 && result <= 100) {
				System.out.println("Has golpeado el obstáculo 2. Ganas " + Constants.POINTSOBSTACLE2 + " puntos");
				pointsObstacle = Constants.POINTSOBSTACLE2;
			}

			// Obstáculo 3

			if (result > 100 && result <= 150) {
				System.out.println("Has golpeado el obstáculo 3. Ganas " + Constants.POINTSOBSTACLE3 + " puntos");
				pointsObstacle = Constants.POINTSOBSTACLE3;
			}

			// Obstáculo Canina

			if (result > 150 && result <= 200) {
				System.out.println("Has golpeado la canina.... Pierdes " + Constants.POINTSOBSTACLE4 + " puntos");
				pointsObstacle = Constants.POINTSOBSTACLE4;
			}

			// Obstáculo Retrete

			if (result > 200 && result <= 250) {
				System.out.println("Tu bola se ha ido por el retrete... Menudo chasco >_< ");
				pointsBall = 0;
				System.out.println("Has conseguido " + pointsBall + " puntos en total con esta bola");
				return pointsBall;
			}

			// Suma de los puntos de los obstáculos

			pointsBall += pointsObstacle;
		}

		LOGGER.info("Fin del método launchBall");

		return finalPointsBall();
	}

	/**
	 * finalPointsBall: Calculates the total points according to the type of ball
	 */
	public int finalPointsBall() {

		LOGGER.info("Inicio del método finalPointsBall");

		// Puntos finales correspondientes a una bola azul

		if (b instanceof BlueBall) {
			ba = (BlueBall) b;
			System.out.println("Has conseguido " + ba.doublePoints(pointsBall) + " puntos en total con esta bola");
			return ba.doublePoints(pointsBall);
		}

		// Puntos finales correspondientes a una bola naranja

		if (b instanceof OrangeBall) {
			bn = (OrangeBall) b;
			System.out.println("Has conseguido " + bn.triplePoints(pointsBall) + " puntos en total con esta bola");
			return bn.triplePoints(pointsBall);
		}

		// Puntos finales correspondientes a una bola verde

		System.out.println("Has conseguido " + pointsBall + " puntos en total con esta bola");

		LOGGER.info("Fin del método finalPointsBall");

		return pointsBall;

	}

	/**
	 * Menu: Game menu
	 */
	public void Menu() {

		LOGGER.info("Inicio del método Menu");

		String option;
		int optionSelected;

		// Opciones del menu disponibles
		do {
			System.out.println("Escoge una opción:");
			System.out.println("1 - Lanzar una bola");
			System.out.println("2 - Consultar puntuación y lanzamientos que te quedan.");
			System.out.println("3 - Salir del juego");
			option = sc.nextLine();

			// Comprueba que el dato introducido no es un caracter
			do {
				if (!NumberUtils.isCreatable(option)) {
					System.out.println("Por favor, introduce un  número. Prueba de nuevo");
					LOGGER.error("No ha metido un dato válido");
					option = sc.nextLine();
				}
			} while (!NumberUtils.isCreatable(option));

			// Comprueba que el dato introducido se encuentra dentro de las opciones disponibles

			optionSelected = NumberUtils.toInt(option);
			if (optionSelected < 1 || optionSelected > 3) {
				System.out.println("Debes escoger una opción de entre las 3 disponibles");
				LOGGER.error("Dato fuera del rango");
			} else {
				optionsMenu(optionSelected);
			}

		} while (optionSelected != 3 && getNumLifes() != 0);

		// Recuento final de puntos de la partida

		if (getNumLifes() == 0) {
			if (pointsGame <= 0) {
				pointsGame = 0;
				System.out.println("No has conseguido ningún punto en esta partida...");
			} else {
				System.out.println("Has conseguido " + pointsGame + " puntos en esta partida. ¡ Enhorabuena ! ");
			}
		}

		LOGGER.info("Fin del método Menu");

	}

	/**
	 * game menu functionality
	 * 
	 * @param option
	 */
	public void optionsMenu(int option) {

		LOGGER.info("Inicio del método optionsMenu");

		switch (option) {

		// Lanzamiento de una bola

		case 1:
			takeOutBall();
			numLifes--;
			break;

		// Muestra los puntos y oportunidades restantes

		case 2:
			System.out.println("Tienes " + pointsGame + " puntos en total. Te quedan " + numLifes + " tiros.");
			break;

		// Finaliza la partida

		case 3:
			System.out.println("Aaaaaadios!");
			answerPlayer = "N";
			break;
		}

		LOGGER.info("Fin del método optionsMenu");
	}

	/**
	 * playAgain: To play again
	 * 
	 * @return answerPlayer
	 */
	public String playAgain() {

		LOGGER.info("Inicio del método playAgain");

		// Pregunta si se quiere volver a jugar

		numLifes = Constants.LIFES;
		System.out.println("¿Quieres jugar de nuevo? Responde S o N");

		do {

			// Comprueba que el dato introducido no es un caracter

			answerPlayer = sc.nextLine();
			if (NumberUtils.isCreatable(answerPlayer)) {
				System.out.println("Aquí no se puede responder con números. Responde de nuevo");
				LOGGER.error("No ha metido un dato válido");

			} else {

				// Comprueba que el dato introducido se encuentra dentro de las opciones disponibles

				if (!answerPlayer.equalsIgnoreCase("S") && !answerPlayer.equalsIgnoreCase("N")) {
					System.out.println("Solo puedes responder con S o N. Responde de nuevo");
					LOGGER.error("Dato fuera del rango");
				}
			}

		} while (!answerPlayer.equalsIgnoreCase("S") && !answerPlayer.equalsIgnoreCase("N"));

		// Muestra la respuesta del juego

		String answerGame = (answerPlayer.equalsIgnoreCase("S")) ? "Genial!" : "Malaje...";
		System.out.println(answerGame);

		LOGGER.info("Fin del método playAgain");

		return answerPlayer;

	}

}
