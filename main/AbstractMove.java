package main;

/**
 * @author l
 *
 *Abstract Class as parent for different types of moves
 */
public abstract class AbstractMove {
	protected Man man = null;
	protected House destination = null;
	protected House source = null;

	public abstract void exec();
	public Man getMan(){return this.man;}
	public House getDestination(){return this.destination;}
	public House getSource(){return this.source;}
}
