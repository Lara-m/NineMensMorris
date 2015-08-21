package main;

/**
 * @author l
 *
 * Singleton 
 * Display Class
 * Provides UI for notifying user of changes
 */
public class Display {
	private static Display display = new Display();
	private Display(){}
	
	public static Display getInstance(){
		return display;
	}
	
	public void update(){
		Board b = Board.getInstance();
		System.out.println(""+b.getHouses().get(0).getId() + b.getHouses().get(0).getMan().getToken() 
				+ " -------------- "+ b.getHouses().get(1).getId() + b.getHouses().get(1).getMan().getToken()+" --------------- "
				+ b.getHouses().get(2).getId() + b.getHouses().get(2).getMan().getToken());
		System.out.println("|                  |                  |");
		System.out.println("|     "+ b.getHouses().get(3).getId() + b.getHouses().get(3).getMan().getToken()
				+" --------- "+ b.getHouses().get(4).getId() + b.getHouses().get(4).getMan().getToken()+" --------- "
				+ b.getHouses().get(5).getId() + b.getHouses().get(5).getMan().getToken()+"    |");
		System.out.println("|     |            |            |     |");
		System.out.println("|     |     "+ b.getHouses().get(6).getId() + b.getHouses().get(6).getMan().getToken()+" --- "
		+ b.getHouses().get(7).getId() + b.getHouses().get(7).getMan().getToken()+" --- "+ b.getHouses().get(8).getId() + b.getHouses().get(8).getMan().getToken()
		+"    |     |");
		System.out.println("|     |     |             |     |     |");
		System.out.println(""+b.getHouses().get(9).getId() + b.getHouses().get(9).getMan().getToken()+" - "+ b.getHouses().get(10).getId() 
				+ b.getHouses().get(10).getMan().getToken()+" - "+ b.getHouses().get(11).getId() + b.getHouses().get(11).getMan().getToken()
				+"          "+ b.getHouses().get(12).getId() + b.getHouses().get(12).getMan().getToken()+" - "+ b.getHouses().get(13).getId() 
				+ b.getHouses().get(13).getMan().getToken()+" - "+ b.getHouses().get(14).getId() + b.getHouses().get(14).getMan().getToken());    
		System.out.println("|     |     |             |     |     |");
		System.out.println("|     |   "+ b.getHouses().get(15).getId() + b.getHouses().get(15).getMan().getToken()+" --- "
		+ b.getHouses().get(16).getId() + b.getHouses().get(16).getMan().getToken()+" --- "+ b.getHouses().get(17).getId() 
		+ b.getHouses().get(17).getMan().getToken()+"   |     |");
		System.out.println("|     |            |            |     |");
		System.out.println("|    "+ b.getHouses().get(18).getId() + b.getHouses().get(18).getMan().getToken()+" -------- "
		+ b.getHouses().get(19).getId() + b.getHouses().get(19).getMan().getToken()+" -------- "+ b.getHouses().get(20).getId() 
		+ b.getHouses().get(20).getMan().getToken()+"    |");
		System.out.println("|                  |                  |");
		System.out.println(""+b.getHouses().get(21).getId() + b.getHouses().get(21).getMan().getToken()+" ------------- "
		+ b.getHouses().get(22).getId() + b.getHouses().get(22).getMan().getToken()+" ------------- "+ b.getHouses().get(23).getId() 
		+ b.getHouses().get(23).getMan().getToken());
	}

}
