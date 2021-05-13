package variables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Developer {

	final static Logger LOGGER = LoggerFactory.getLogger(Developer.class);

	/**
	 * Developer name
	 */
	private String name;

	/**
	 * Developer identification number
	 */
	private int iDDeveloper;

	/**
	 * Developer number counter
	 */
	private static int numTotalDeveloper = 0;

	/**
	 * Number of developer holidays days
	 */
	private int numHolidays = Constants.MAXHOLYDAYS;

	/**
	 * @param name
	 * @throws Exception
	 * 
	 *             Developer class constructor
	 */

	public Developer(String name) {

		LOGGER.info("Inicio del método constructor");

		try {

			// Comprobación: No superar el máximo de empleados

			if (numTotalDeveloper < Constants.MAXDEVELOPER) {
				this.name = name;
				this.iDDeveloper = numTotalDeveloper + 1;
				numTotalDeveloper++;
			}
		} catch (Exception e) {
			System.out.println("Ya has alcanzado el número máximo de empleados");
			LOGGER.error("Se intenta sobrepasar el máximo de empleados contratados");
		}

		LOGGER.info("Final del método constructor");
	}

	/**
	 * 
	 * @param numHolidays
	 * 
	 *            Set method of the number of holidays days
	 */
	public void setNumHolidays(int numHolidays) {

		LOGGER.info("Inicio del método setNumHolidays");

		// Comprobación: Integridad del número de días de vaciones

		if (numHolidays < 0) {
			System.out.println("No se pueden tener vacaciones negativas");
			LOGGER.error("Número de vacaciones negativas");

		} else {

			// Comprobación: No superar el máximo de días de vacaciones

			if (numHolidays > Constants.MAXHOLYDAYS) {
				System.out.println("El número máximo de días de vacaciones es " + Constants.MAXHOLYDAYS);
				LOGGER.error("El número de días de vacaciones supera el máximo");

			} else {

				// Set: Días de vacaciones
				this.numHolidays = numHolidays;
				LOGGER.debug("Se han establecido " + numHolidays + " días de vacaciones");
			}
		}

		LOGGER.info("Final del método setNumHolidays");
	}

	/**
	 * @return numTotalDeveloper
	 * 
	 *         Get method of the total number of developers
	 */

	public int getNumTotalDeveloper() {
		return numTotalDeveloper;
	}

	/**
	 * @return name
	 * 
	 *         Get method of the name of developers
	 */

	public String getName() {
		return name;
	}

	/**
	 * @return numHolidays
	 * 
	 *         Get method of the number of developer holidays days
	 */

	public int getNumHolidays() {
		return numHolidays;
	}

	/**
	 * @return iDDeveloper
	 * 
	 *         Get method of the developer identification number
	 */

	public int getIDDeveloper() {
		return iDDeveloper;
	}

	/**
	 * @param days
	 * 
	 *            Method to consume holidays days
	 */

	public void spendHolidays(int days) {

		LOGGER.info("Inicio del método spentHolidays");

		// Comprobación: Integridad del número de días de vaciones
		if (days < 0) {
			System.out.println("Introduce un número de días positivos");
			LOGGER.error("Número de vacaciones negativas");

		} else {

			// Comprobación: Días de vacaciones suficientes
			if (numHolidays - days < 0) {
				System.out.println("No tienes suficientes días de vacaciones");
				LOGGER.error("Días de vacaciones insuficientes");

			} else {

				// Gasto de días de vacaciones
				numHolidays = numHolidays - days;
				LOGGER.debug("Se han gastado " + days + " días de vacaciones");
			}

		}

		LOGGER.info("Final del método spentHolidays");
	}
}
