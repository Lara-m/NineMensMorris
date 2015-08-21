package main;

/**
 * @author l
 *
 * Turn Class
 * Provides means of implying turn, phase and generating moves
 */
import java.util.ArrayList;

public class Turn {
	ArrayList<AbstractMove> actions = new ArrayList<AbstractMove>();

	Turn(Man man){
		makeMoveCommandsPhaseOne(man);
	}

	Turn(ArrayList<Man> men){
		makeMoveCommandsPhaseTwo(men);
	}

	public void makeMoveCommandsPhaseTwo(ArrayList<Man> men){
		boolean success = false;
		while(success!=true){
			int menLeft = 0;
			if (Game.getInstance().currentTurn.getColour() == Game.Color.values()[0])
				menLeft=Board.getInstance().howManyMen(Board.getInstance().red);
			else
				menLeft=Board.getInstance().howManyMen(Board.getInstance().blue);

			if ( menLeft < Game.MINMEN ){
				Game.win = true;
				break;
			}
			
			System.out.println("Player "+Game.getInstance().currentTurn.getColour()+", it is your turn.");
			//for more than 3, Slide
			if ( menLeft > Game.MINMEN )
				success = makeSlideCommand(success);
			
			//when 3 left, can jump
			if ( menLeft == Game.MINMEN )
				success = makeHopCommand(success);
			
		}
	}
	
	public void makeMoveCommandsPhaseOne(Man m){
		boolean success = false;
		while(success!=true){
			System.out.println("Choose a house for a "+Game.getInstance().currentTurn.getColour()+" Man:");
			int destination = Game.getInstance().currentTurn.readInt();
			Place move = new Place();
			if (move.check(destination,m)){
				move.exec();
				actions.add(move);
				makeTakeCommand(destination, actions);
				History.getInstance().save(actions);
				success=true;
			}
		}
	}
	
	void makeTakeCommand(int src, ArrayList<AbstractMove> actions){
		if(Mills.checkMills(src)){
			Display.getInstance().update();
			System.out.println("You can take an opponent man out. "
					+ "\nChoose a house that contains an opponent man:");
			src = Game.getInstance().currentTurn.readInt();
			Take move = new Take();
			while (!move.check(src)){
				src = Game.getInstance().currentTurn.readInt();
			}
			move.exec();		
			actions.add(move);
		}
	}
	
	boolean makeSlideCommand(boolean success){
		boolean checking = false;
		Slide move = new Slide();		
		while(checking!=true){
			System.out.println("Slide one of your men from its house."
					+ " Choose a house that contains your man and a direction to slide to:"
					+ "\n{Up:"+move.UP+", Down:"+move.DOWN+", Right:"+move.RIGHT+", left:"+move.LEFT+"}");
			int src = Game.getInstance().currentTurn.readInt();
			int dir = Game.getInstance().currentTurn.readInt();
			checking = move.check(src,dir);
		}
		move.exec();
		actions.add(move);
		makeTakeCommand(move.getDestination().getId(), actions);
		success=true;
		return success;
	}
	
	boolean makeHopCommand(boolean success){
		boolean checking = false;
		Hop move = new Hop();
		while(checking!=true){
			System.out.println("You can jump. "
					+ "Choose a house that contains your man and a destination house:");
			int src = Game.getInstance().currentTurn.readInt();
			int dst = Game.getInstance().currentTurn.readInt();
			checking = move.check(src,dst);
		}
		move.exec();
		actions.add(move);
		makeTakeCommand(move.getDestination().getId(), actions);
		success=true;
		return success;
	}
}
