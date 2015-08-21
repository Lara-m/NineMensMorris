package main;

/**
 * @author l
 *
 * House Class
 * Represents a physical spot or intersection of lines in Mills Game
 */
public class House {
	private House up = null;
	private House down = null;
	private House left = null;
	private House right = null;
	private AbstractMan man = null;
	private int id;

	//neighbors getters and setters
	public House getUp() {return up;}
	public void setUp(House h) {up = h;}
	public House getDown() {return down;}
	public void setDown(House h) {down = h;}
	public House getLeft() {return left;}
	public void setLeft(House h) {left = h;}
	public House getRight() {return right;}
	public void setRight(House h) {right = h;}
	
	public AbstractMan getMan() {return man;}
	public void setMan(AbstractMan m) {man = m;}
	public int getId() {return id;}
	public void setId(int i) {id = i;}
	
}
