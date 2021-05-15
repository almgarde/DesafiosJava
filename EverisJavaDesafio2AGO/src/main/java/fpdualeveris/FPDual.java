package fpdualeveris;

/**
 *  Clases Loggers
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Pinball
 */
import operators.Pinball;

public class FPDual {

	/**
	 * Logger
	 */
	final static Logger LOGGER = LoggerFactory.getLogger(FPDual.class);

	/**
	 * Principal method
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		LOGGER.info("Inicio del método principal");

		operatorsChallenge();

		LOGGER.info("Fin del método principal");
	}

	/**
	 * Method to instantiate and execute the methods of the pinball class
	 */

	private static void operatorsChallenge() {

		LOGGER.info("Inicio del método operatorsChallenge");

		// Creación de un objeto Pinball

		Pinball p = new Pinball();

		// Inicio del juego

		p.initGame();

		// Ejecución del menú

		p.Menu();

		// Repetición de la partida

		if (!p.getAnswerPlayer().equalsIgnoreCase("N")) {
			p.playAgain();
		}

		while (p.getAnswerPlayer().equalsIgnoreCase("S")) {

			p.Menu();
			if (!p.getAnswerPlayer().equalsIgnoreCase("N")) {
				p.playAgain();
			}

		}

		LOGGER.info("Fin del método operatorsChallenge");

	}

}
