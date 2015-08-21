package main;

/**
 * @author l
 * 
 * Mills Class
 * Provides static ways of checking in there are any moves available 
 * ... and if Mills state has happened.
 */
import java.util.ArrayList;

public class Mills {
	
	//Checking if Mills happened
	public static boolean checkMills(int id){
		House home =  Board.getInstance().getHouses().get(id);
		if (home==null)
			return false;
		House right = home.getRight();
		House farRight = null;
		if(right!=null)
			farRight = right.getRight();
		House left = home.getLeft();
		House farLeft=null;
		if (left!=null)
			farLeft= left.getLeft();
		House up = home.getUp();
		House farUp = null;
		if(up!=null)
			farUp = up.getUp();
		House down = home.getDown();
		House farDown = null;
		if(down!=null)
			farDown = down.getDown();
		
		if(right!=null && left!=null)
			if(home.getMan().getColor()==right.getMan().getColor() 
			&& home.getMan().getColor()==left.getMan().getColor())
				return true;
		if(down!=null && up!=null)
			if(home.getMan().getColor()==up.getMan().getColor() 
			&& home.getMan().getColor()==down.getMan().getColor())
				return true;
		if(down!=null && farDown!=null)
			if(home.getMan().getColor()==down.getMan().getColor() 
			&& home.getMan().getColor()==farDown.getMan().getColor())
				return true;
		if(up!=null && farUp!=null)
			if(home.getMan().getColor()==up.getMan().getColor() 
			&& home.getMan().getColor()==farUp.getMan().getColor())
				return true;
		if(right!=null && farRight!=null)
			if(home.getMan().getColor()==right.getMan().getColor() 
			&& home.getMan().getColor()==farRight.getMan().getColor())
				return true;
		if(left!=null && farLeft!=null)
			if(home.getMan().getColor()==left.getMan().getColor() 
			&& home.getMan().getColor()==farLeft.getMan().getColor())
				return true;
		return false;
	}
	
	//Check if there are any moves available
	public static boolean canMove(ArrayList<Man> men){
		int numberOfMen = Board.getInstance().howManyMen(men);
		int trappedMen = 0 ;
		for(int i=0; i<=Board.getInstance().maxHouseId; i++){
			House current = Board.getInstance().getHouses().get(i);
			
			//if the house is taken by the man of same color
			if (current.getMan()!= Board.getInstance().nullman 
					&& current.getMan().getColor() == men.get(0).getColor()){
				//System.out.println("current.id: "+current.getId()); //DEBUG
				//System.out.println("current.token: "+current.getMan().getToken()); //DEBUG
				//if the neighbors are free
				if (   (current.getRight()!= null && current.getRight().getMan()== Board.getInstance().nullman)  
					|| (current.getLeft() != null && current.getLeft().getMan() == Board.getInstance().nullman) 
					|| (current.getUp()   != null && current.getUp().getMan()	== Board.getInstance().nullman)
					|| (current.getDown() != null && current.getDown().getMan() == Board.getInstance().nullman) )
					continue;
				//if no neighbor is free hence there's no space to move to
				else
					trappedMen++;
			}
		}
		//Check if the number of men that are unable to move is same as total men (Or higher to avoid mistakes and glitches)
		//Also considering that this situation only applies to slide, and not while jump is available.
		//System.out.println("trappedMen: "+trappedMen);//DEBUG
		if ((numberOfMen != Game.MINMEN) && (trappedMen >= numberOfMen) ){
			Game.win = true;
			return false;
		}
		return true;
	}
}
