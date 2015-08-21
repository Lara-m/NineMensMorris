package main;

/**
 * @author l
 * 
 * Human Class
 * Provides input unification and a way of keeping track of turns 
 */
import java.util.Scanner;

public class Human extends AbstractPlayer{
	private Scanner in = new Scanner(System.in);
	
	Human(Game.Color c){
		color = c;
	}
		
	public int readInt(){
		return in.nextInt();
	}
	
	public boolean readYN(){
		String response = in.next();
		if (response.charAt(0)=='Y'||response.charAt(0)=='y')
			return true;
		else if (response.charAt(0) == 'N'||response.charAt(0)=='n')
			return false;
		else{
			System.out.println("What you typed in made no sense."
					+ "\nEither type 'Y' and press enter or press 'N' and press enter.");
			return readYN();
		}
	}
}
