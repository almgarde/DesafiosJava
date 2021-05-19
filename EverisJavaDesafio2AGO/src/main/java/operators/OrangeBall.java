package operators;

/**
 * Proyecto Java - Desafío 2
 * 
 * @author agadelao
 */
public class OrangeBall extends Ball {

	/** Ball color: Orange */
	private String colour = Constants.COLOUR3;

	/**
	 * Returns triple points
	 * 
	 * @param points
	 * @return points*3
	 */
	public int triplePoints(int points) {
		return points * 3;
	}
}
