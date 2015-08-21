package main;

/**
 * @author l
 * 
 * Take Class
 * Provides check and execution of taking token moves
 */
public class Take extends AbstractMove{
	
	//check if the move is valid.
	public boolean check(int src){
		if ( Board.getInstance().minHouseId <= src && src <= Board.getInstance().maxHouseId){
			//if the chosen house is empty or if the chosen man is same as player
			if (Board.getInstance().getHouses().get(src).getMan() == Board.getInstance().nullman){
				System.out.println("Chosen house is empty. Choose another.");
				return false;
			}
				
			if (Board.getInstance().getHouses().get(src).getMan().getColor() == Game.getInstance().currentTurn.getColour()){
				System.out.println("Chosen house contains your own man. Choose another.");
				return false;
			}
			//if are all in mills, then the man can be removed
			if(!allmills() && Mills.checkMills(src)){
				System.out.println("Chosen house contains a man that's already in a mill."
						+ "\nYou can't remove that. Choose another");
				return false;
			}
			source = Board.getInstance().getHouses().get(src);
			man = (Man) source.getMan();
			return true;
		}
		else
			System.out.println("Chosen destination is not on the board. Choose another");
		return false;
	}

	//Execute the move. Remove the man
	public void exec(){
		man.isOut=true;
		man.setHouse(null);
		//set the house to null man
		source.setMan(Board.getInstance().nullman);
	}
	
	public boolean allmills(){
		//Should also check to see if all are in Mill, remove from Mill
		if(Game.getInstance().currentTurn.getColour() == Game.Color.values()[0]){
			int counter = 0;
			int howmany = 0;
			for(Man m:Board.getInstance().blue){
				//if the man has not already been removed
				if(m.getHouse()!=null){
					if(Mills.checkMills(m.getHouse().getId()))
						counter++;
				howmany++;
				}
			}
			if (counter < howmany)
				return false;
		}
		else{
			int counter = 0;
			int howmany = 0;

			for(Man m:Board.getInstance().red){
				if(m.getHouse()!=null){
					if(Mills.checkMills(m.getHouse().getId()))
						counter++;
				}
				howmany++;
			}
			if (counter < howmany)
				return false;
		}
		return true;
	}
	
}
