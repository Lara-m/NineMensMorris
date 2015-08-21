package main;

/**
 * @author l
 *
 * Singleton
 * Board Class
 * Provides wiring of houses and keeps track of Men and Houses
 */
import java.util.ArrayList;
import main.Game.Color;

public class Board {
	private static Board board = new Board();
	private Board(){}
	public static Board getInstance(){
		return board;
	}
	
	private ArrayList<House> houses = new ArrayList<House>();
	NullMan nullman;
	public int maxHouseId = 23;
	public int minHouseId = 0;
	
	//Men are colored as red and blue to avoid the naming conventions. 
	//Name of each team/player that are shown to players are changed through "Game.Color" and are independent of the names used here.
	ArrayList<Man> red = new ArrayList<Man>();
	ArrayList<Man> blue = new ArrayList<Man>();
	
	public int howManyMen(ArrayList<Man> men){
		int i=0;
		for (Man m:men){
			if(m.isOut == false)
				i++;
		}
		//System.out.println(""+men.get(0).getToken()+" men:"+i);//DEBUG
		return i;
	}
	
	public ArrayList<House> getHouses(){
		return houses;
	}
	
	/*
	 * Main board logic. 
	 * The wiring of houses and their knowledge of where other houses are comes from this part.
	 */
	public void setUp(){
		for(int i = 0; i<Game.getInstance().numberOfMen; i++){
			Man m = new Man(Color.values()[0]);
			m.setHouse(null);
			red.add(m);
		}
		for(int i = 0; i<Game.getInstance().numberOfMen; i++){
			Man m = new Man(Color.values()[1]);
			m.setHouse(null);
			blue.add(m);
		}

		nullman = new NullMan();
		 
		for (int i=0;i<=maxHouseId;i++){
			houses.add(new House());
			houses.get(i).setId(i);
			houses.get(i).setMan(nullman);
		}
		houses.get(0).setRight(houses.get(1));
		houses.get(0).setDown(houses.get(9));
		
		houses.get(1).setRight(houses.get(2));
		houses.get(1).setLeft(houses.get(0));
		houses.get(1).setDown(houses.get(4));
		
		houses.get(2).setLeft(houses.get(1));
		houses.get(2).setDown(houses.get(14));

		houses.get(3).setRight(houses.get(4));
		houses.get(3).setDown(houses.get(10));

		houses.get(4).setLeft(houses.get(3));
		houses.get(4).setRight(houses.get(5));
		houses.get(4).setUp(houses.get(1));
		houses.get(4).setDown(houses.get(7));

		houses.get(5).setLeft(houses.get(4));
		houses.get(5).setDown(houses.get(13));

		houses.get(6).setRight(houses.get(7));
		houses.get(6).setDown(houses.get(11));

		houses.get(7).setLeft(houses.get(6));
		houses.get(7).setRight(houses.get(8));
		houses.get(7).setUp(houses.get(4));

		houses.get(8).setLeft(houses.get(7));
		houses.get(8).setDown(houses.get(12));

		houses.get(9).setRight(houses.get(10));
		houses.get(9).setUp(houses.get(0));
		houses.get(9).setDown(houses.get(21));

		houses.get(10).setRight(houses.get(11));
		houses.get(10).setLeft(houses.get(9));
		houses.get(10).setUp(houses.get(3));
		houses.get(10).setDown(houses.get(18));

		houses.get(11).setLeft(houses.get(10));
		houses.get(11).setUp(houses.get(6));
		houses.get(11).setDown(houses.get(15));

		houses.get(12).setRight(houses.get(13));
		houses.get(12).setUp(houses.get(8));
		houses.get(12).setDown(houses.get(17));

		houses.get(13).setRight(houses.get(14));
		houses.get(13).setLeft(houses.get(12));
		houses.get(13).setUp(houses.get(5));
		houses.get(13).setDown(houses.get(20));

		houses.get(14).setLeft(houses.get(13));
		houses.get(14).setUp(houses.get(2));
		houses.get(14).setDown(houses.get(23));

		houses.get(15).setRight(houses.get(16));
		houses.get(15).setUp(houses.get(11));

		houses.get(16).setLeft(houses.get(15));
		houses.get(16).setRight(houses.get(17));
		houses.get(16).setDown(houses.get(19));

		houses.get(17).setLeft(houses.get(16));
		houses.get(17).setUp(houses.get(12));

		houses.get(18).setRight(houses.get(19));
		houses.get(18).setUp(houses.get(10));

		houses.get(19).setRight(houses.get(20));
		houses.get(19).setLeft(houses.get(18));
		houses.get(19).setUp(houses.get(16));
		houses.get(19).setDown(houses.get(22));

		houses.get(20).setLeft(houses.get(19));
		houses.get(20).setUp(houses.get(13));

		houses.get(21).setRight(houses.get(22));
		houses.get(21).setUp(houses.get(9));

		houses.get(22).setRight(houses.get(23));
		houses.get(22).setLeft(houses.get(21));
		houses.get(22).setUp(houses.get(19));

		houses.get(23).setLeft(houses.get(22));
		houses.get(23).setUp(houses.get(14));
	}
	
}
