package operators;

/**
 * Proyecto Java - Desafío 2
 * 
 * @author agadelao
 */
public class BlueBall extends Ball {

	/** Ball color: Blue */
	private String colour = Constants.COLOUR2;

	/**
	 * Returns double points
	 * 
	 * @param points
	 * @return points*2
	 */
	public int doublePoints(int points) {

		return points * 2;
	}
}
