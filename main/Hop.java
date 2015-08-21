package main;

/**
 * @author l
 * 
 * Hop Class
 * Provides check and execution of Jump/Hop moves
 */
public class Hop extends AbstractMove{
	//check if the jump is possible
	public boolean check(int src, int dest){
		if ( Board.getInstance().minHouseId <= dest && dest <= Board.getInstance().maxHouseId){
			if (Board.getInstance().getHouses().get(src).getMan().getColor() 
					!= Game.getInstance().currentTurn.getColour()){
				System.out.println("Choose a house that belongs to you.");
				return false;
			}
			if (Board.getInstance().getHouses().get(dest).getMan()==Board.getInstance().nullman){
				source = Board.getInstance().getHouses().get(src);
				destination = Board.getInstance().getHouses().get(dest);
				man = (Man) source.getMan();
				return true;
			}
			else{
				System.out.println("Chosen destination is not empty.");
				return false;
			}
		}
		else
			System.out.println("Chosen destination is not on the board.");
		return false;
	}
	//execute jump
	public void exec(){
		destination.setMan(man);
		man.setHouse(destination);
		source.setMan(Board.getInstance().nullman);
	}
}
