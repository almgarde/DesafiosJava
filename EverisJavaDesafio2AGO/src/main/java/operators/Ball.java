package operators;

/**
 * Proyecto Java - Desafío 2
 * 
 * @author agadelao
 */
public abstract class Ball {

	/** Ball radius */
	private int radio = Constants.RADIO;

	/** Ball color */
	protected String colour;

	/**
	 * Devuelve color de bola
	 * 
	 * @return colour
	 */
	public String getColour() {
		return colour;
	}

}
