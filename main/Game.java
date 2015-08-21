package main;

/**
 * @author l
 * 
 * Singleton
 * Game Class
 * Contains main method
 * In charge of major pipelining and providing data to other classes.
 */
public class Game {
	private static Game game = new Game();	
	private Game(){}
	public static Game getInstance(){return game;}
	
	public enum Color {White, Black};
	public static boolean win=false;
	AbstractPlayer currentTurn;
	AbstractPlayer p1;
	AbstractPlayer p2;
	int phase = 0;
	int numberOfMen = 9;
	//number of men left that can allow a man to jump
	final static int MINMEN = 3;

	private void PhaseTwo(){
		int endCounter = 150;
		while (win!=true) {
			endCounter --;
			if(Mills.canMove(Board.getInstance().red)==true){
				currentTurn = p1;
				new Turn(Board.getInstance().red);
				Display.getInstance().update();
				Board.getInstance().howManyMen(Board.getInstance().red);
				
				System.out.println("Are you sure about this move? [Y/N]");
				if(p1.readYN()){
					History.getInstance().undo();
					Display.getInstance().update();
				}
				
			}
			else
				win=true;
			if(Mills.canMove(Board.getInstance().blue)){
				currentTurn = p2;
				new Turn(Board.getInstance().blue);
				Display.getInstance().update();
				Board.getInstance().howManyMen(Board.getInstance().blue);
				
				System.out.println("Are you sure about this move? [Y/N]");
				if(p2.readYN()){
					History.getInstance().undo();
					Display.getInstance().update();
				}
				
			}
			else
				win=true;
			if (endCounter <=0)
				System.out.println("Draw.");
		}
		if (currentTurn == p1)
			System.out.println("Game finished! Player "+Color.values()[1]+" won!");
		else
			System.out.println("Game finished! Player "+Color.values()[0]+" won!");
	}
	
	private void PhaseOne(){
		System.out.println("Each Player gets "+numberOfMen+" Men.");
		int redIndex = 0;
		int blueIndex = 0;
		for(int i = 0; i<(2*numberOfMen); i++){
			if(i%2==0){
				currentTurn = p1;
				new Turn(Board.getInstance().red.get(redIndex));
				Display.getInstance().update();
				
				System.out.println("Are you sure about this move? [Y/N]");
				if(!p1.readYN()){
					History.getInstance().undo();
					Display.getInstance().update();
					i--;
					continue;
				}
				
				redIndex++;
				
			}
			else{
				currentTurn = p2;
				new Turn(Board.getInstance().blue.get(blueIndex));
				Display.getInstance().update();
				
				System.out.println("Are you sure about this move? [Y/N]");
				if(!p2.readYN()){
					History.getInstance().undo();
					Display.getInstance().update();
					i--;
					continue;
				}
				
				blueIndex++;
				
			}
		}
		//testAfterPhaseOne();//DEBUG
		return;
	}
	
	private void setUp(){
		p1 = new Human(Color.values()[0]);
		p2 = new Human(Color.values()[1]);
		Board.getInstance().setUp();
		Display.getInstance().update();
	}
	
	public void play(){
		setUp();
		phase = 1;
		PhaseOne();
		phase = 2;
		PhaseTwo();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to L's Nine Men's Morris!");
		Game.getInstance().play();
		System.out.println("End of Game. Bye!");
	}
	
	/*
	 * TESTING PURPOSES
	 */
	/*
	public void testAfterPhaseOne(){
		System.out.println(""+Color.values()[0]+" Houses:");
		int size=Board.getInstance().howManyMen(Board.getInstance().red);
		for(int i=0; i<size;i++){
			if (Board.getInstance().red.get(i).getHouse()==null){
				i--;
				size = Board.getInstance().howManyMen(Board.getInstance().red);
			}
			else
				System.out.print(Board.getInstance().red.get(i).getHouse().getId()+"   ");
		}
		System.out.println("");
		System.out.println(""+Color.values()[1]+" Houses:");
		size=Board.getInstance().howManyMen(Board.getInstance().blue);
		for(int i=0; i<size;i++){
			if (Board.getInstance().blue.get(i).getHouse() == null){
				i--;
				size = Board.getInstance().howManyMen(Board.getInstance().blue);
			}
			else
				System.out.print(Board.getInstance().blue.get(i).getHouse().getId()+"   ");
		}
		System.out.println("");
		return;
	}
	*/
}
