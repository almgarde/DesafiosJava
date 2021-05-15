package operators;

/**
 *  Clases Loggers
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreenBall extends Ball {

	/**
	 * Logger
	 */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * colour: Ball color
	 */
	private String colour = Constants.COLOUR_GREEN;

}
