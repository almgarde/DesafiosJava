package operators;

/**
 *  Clases Loggers
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mucus {

	/**
	 * Logger
	 */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * viscosity: mucus viscosity
	 */
	private String viscosity;

	/**
	 * get method of viscosity
	 * 
	 * @return viscosity
	 */
	public String getViscosity() {
		return viscosity;
	}

	/**
	 * set method of viscosity
	 * 
	 * @param viscosity
	 */
	public void setViscosity(String viscosity) {
		this.viscosity = viscosity;
	}

}
