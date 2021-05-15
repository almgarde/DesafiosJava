package operators;

/**
 *  Clases Loggers
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrangeBall extends Ball {

	/**
	 * Logger
	 */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * colour: Ball color
	 */
	private String colour = Constants.COLOUR_ORANGE;

	/**
	 * returns triple points
	 * 
	 * @param points
	 * @return points*3
	 */
	public int triplePoints(int points) {
		return points * 3;
	}
}
