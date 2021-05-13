package fpdualeveris;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import variables.Developer;


public class FPDual {

	final static Logger LOGGER = LoggerFactory.getLogger(FPDual.class);

	/**
	 * Principal method
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		LOGGER.info("Inicio del método principal");

		variablesChallenge();

		LOGGER.info("Fin del método principal");
	}

	/**
	 * Method to instantiate and execute the methods of the developer class
	 */

	private static void variablesChallenge() {

		LOGGER.info("Inicio del método variablesChallenge");

		// Contratación empleados

		Developer dev1 = new Developer("Pedro");
		Developer dev2 = new Developer("Jack");
		Developer dev3 = new Developer("Steven");
		Developer dev4 = new Developer("Kate");

		// Número total de empleados

		System.out.println("El número total de empleados segun dev1 es " + dev1.getNumTotalDeveloper());
		System.out.println("El número total de empleados segun dev4 es " + dev4.getNumTotalDeveloper());

		// Número de identificación de los empleados

		System.out.println("El número de empleado de dev1 es:" + dev1.getIDDeveloper());
		System.out.println("El número de empleado de dev2 es:" + dev2.getIDDeveloper());
		System.out.println("El número de empleado de dev3 es:" + dev3.getIDDeveloper());
		System.out.println("El número de empleado de dev4 es:" + dev4.getIDDeveloper());

		// El empleado 2 consume 2 días de vacaciones

		System.out.println("El empleado 2 tiene " + dev2.getNumHolidays() + " días de vacaciones");
		dev2.spendHolidays(2);
		System.out.println("Al empleado 2 le quedan " + dev2.getNumHolidays() + " días de vacaciones");

		// Consulta número de vacaciones de los empleados

		dev1.setNumHolidays(8);
		dev3.setNumHolidays(15);
		dev4.setNumHolidays(12);

		System.out.println("El empleado 1 tiene " + dev1.getNumHolidays() + " días de vacaciones");
		System.out.println("El empleado 2 tiene " + dev2.getNumHolidays() + " días de vacaciones");
		System.out.println("El empleado 3 tiene " + dev3.getNumHolidays() + " días de vacaciones");
		System.out.println("El empleado 4 tiene " + dev4.getNumHolidays() + " días de vacaciones");

		LOGGER.info("Fin del método variablesChallenge");

	}

}
