package AdventurGm;

import java.util.Scanner;

public class Game {
 Player player;
 Location location;
 Scanner scan=new Scanner(System.in);
 
 
 public void login() {
	 System.out.println("Welcome to Adventure Game !! ");
	 System.out.println("Please enter your name: ");
	 String playerName=scan.nextLine();
	 player=new Player(playerName);
	 player.selectCha();
	 start();		
 }
 public void start()
 {
	while(true)
	{	 
	 System.out.println();
	 System.out.println("======================");
	 System.out.println();
	 System.out.println("Choose a place for game: ");
	 System.out.println("1. Safe House --> A safe place for you not enemies !");
	 System.out.println("2. Cave --> You may encounter Zombies !");
	 System.out.println("3. Forest --> You may encounter Vampire !");
	 System.out.println("4. River --> You may encounter Bear !");
	 System.out.println("5. Store --> You can take gun and armor");
	 System.out.println("you want to go is place::");
	 int selLoc=scan.nextInt();
	 
	 while(selLoc <0 || selLoc>5 ) {
		 System.out.println("Please select a valid location: ");
		 selLoc=scan.nextInt();
	 }
	 
	 switch(selLoc) {
	 case 1:
		 location=new SafeHouse(player);
		 break;
	 case 2:
		 location=new Cave(player);
		 break;
	 case 3:
		 location=new Forest(player);
		 break;
	 case 4:
		 location=new River(player);
		 break;
	 case 5:
		 location=new ToolStore(player);
		 break;
     default:
    	 location=new SafeHouse(player);
	 }
	 if(!location.getClass().getName().equals("SafeHouse")) {
         if(player.getInv().isFirewood()&&player.getInv().isFood()&&player.getInv().isWater()) {
        	 System.out.println("Congratulations !!!  You won the game  !!!");
		     break;
         }
	 }
	 if(!location.getLocation()) {
		 System.out.println("Game Over!!! ");
		 break;
	 }
     }
 }
 
}
