package operators;

/**
 *  Clases Loggers
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlueBall extends Ball {
	
	/**
	 * Logger
	 */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * colour: Ball color
	 */
	private String colour = Constants.COLOUR_BLUE;

	
	/**
	 * returns double points
	 * 
	 * @param points
	 * @return points*2
	 */
	public int doublePoints(int points) {
		return points * 2;
	}
}
