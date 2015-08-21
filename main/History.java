package main;

/**
 * @author l
 *
 * Singleton 
 * History Class
 * Keeps track of history and provides ways of undoing the history
 */
import java.util.ArrayList;

public class History {	
	private static History history = new History();
	private History(){}
	public static History getInstance(){return history;}
	
	ArrayList <AbstractMove> lastmove = new ArrayList <AbstractMove>();
	
	public void save(ArrayList<AbstractMove> a){
			lastmove = a;
	}
		
	
	void undo(){
		// If there's a source, put man back to it's source
		// If there's a destination, refer it to nullman
		for(AbstractMove a: lastmove){
			if (a instanceof Place){
				a.getDestination().setMan(Board.getInstance().nullman);
				a.getMan().setHouse(null);
			}
			else if(a instanceof Take){
				a.getMan().isOut = false;
				a.getSource().setMan(a.getMan());
				a.getMan().setHouse(a.getSource());
			}
			else if((a instanceof Slide)||(a instanceof Hop)){
				a.getSource().setMan(a.getMan()); 
				a.getMan().setHouse(a.getSource());
				a.getDestination().setMan(Board.getInstance().nullman);
			}

		}
	}
}
