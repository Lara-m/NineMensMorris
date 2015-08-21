
package main;

/**
 * @author l
 *
 *Abstract Class for original Man and Null Man (Null Object)
 */
public abstract class AbstractMan {
	protected House house = null;
	protected Game.Color color = null;
	public boolean isOut;

	public abstract char getToken();
	
	public House getHouse() {return house;}
	public Game.Color getColor(){return color;}

}
