package main;

/**
 * @author l
 * 
 * Place Class
 * Provides check and execution of placing token moves
 */
public class Place extends AbstractMove{

	public boolean check(int adrs, Man m){
		if ( Board.getInstance().minHouseId <= adrs && adrs <= Board.getInstance().maxHouseId){
			if(Board.getInstance().getHouses().get(adrs).getMan().getColor()==null){
				destination = Board.getInstance().getHouses().get(adrs);
				man = m;
				return true;
			}
			else{
					System.out.println("The house you're choosing has already been filled."
							+ "\nChoose a different House.");
					return false;
			}
		}
		else
			System.out.println("Chosen destination is not on the board.");
		return false;		
	}
	
	public void exec(){
		destination.setMan(man);
		man.setHouse(destination);
	}
}
