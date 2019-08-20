package Pkg;
import java.util.*;

public class Arena {
	
	static Random rand = new Random();
	public static int dragonNumber = 10000000;
	public static Vector<Dragon> Dragons = new Vector();
	public static Vector<Dragon> winners = new Vector();
	
	public static void main(String[] args) {
	tournment();
	}
	public static void tournment() {
		spawn();
		while (Dragons.size() > 1) {
			oddChecker();
			round();
			System.out.println(" ");

		}
		
	}
	public static void oddChecker() {
		if(Dragons.size()%2 == 1) {
			int choice = rand.nextInt(Dragons.size());
			System.out.println("This Dragon gets a by" + Dragons.get(choice).name);
			winners.add(Dragons.get(choice));
			Dragons.remove(choice);
		}
	}
	public static void round() {
		
		matchUp();
		
		
		for(int i = 0; i < Dragons.size(); i ++) {
			if(Dragons.get(i).isAlive == true) {
				System.out.println("Dragon " + Dragons.get(i).name + " has won and will now level up!");
				Dragons.get(i).levelUp();
//				System.out.println("New Stats are....");
//				Dragons.get(i).stats();
				winners.add(Dragons.get(i));
			} else if (Dragons.get(i).isAlive == false) {
				System.out.println("Dragon " + Dragons.get(i).name + " has died");
				
			} else {
				System.out.println(" Somthing has gone wrong ");
			}
				
		}
			System.out.println("Winners Bracket is!");
			Dragons.clear();
			for(int i = 0; i < winners.size(); i ++) {
				System.out.println("Dragon " + winners.get(i).name);
				Dragons.add(winners.get(i));
			}
		winners.clear();
			
		
	}
	//creates the object 
	public static void spawn() {
		for(int i = 0; i < dragonNumber; i ++) {
			Dragons.add(new Dragon(i+1));
			Dragons.get(i).stats();
		}
	}
		
		
	//pairs objects to fight
	public static void matchUp() {
		for(int i = 0; i < Dragons.size(); i = i + 2) {
			game(Dragons.get(i),Dragons.get(i+1));
		}
		
		
	}
	//determines winner
	public static void game(Dragon d1, Dragon d2) {
		int healthyx = d1.health;
		int healthyy = d2.health;
		System.out.println("These 2 dragons are fighting");
		d1.stats();
		d2.stats();
	
		while(d1.isAlive == true && d2.isAlive == true) {
			int chance = rand.nextInt(100)+1;
			if(dodgeChance(d1)) {
				if(critChance(d2)) {
//					if()
					System.out.println("Dragon " + d2.name + " Has landed a crit!");
					healthyx = healthyx -(d2.damage *2);
					System.out.println("Dragon " + d1.name + " gets critied from " + d2.name + " and now has " + healthyx + " health");

				} else {
				healthyx = healthyx - d2.damage;
				System.out.println("Dragon " + d1.name + " gets hit from " + d2.name + " and now has " + healthyx + " health");
				}
				if(healthyx < 1) {
					d1.killed();
				}
			} else {
				System.out.println("Dragon " + d1.name + " dodges!");
			}
			if(dodgeChance(d2)) {
				if(critChance(d1)) {
					System.out.println("Dragon " + d1.name + " Has landed a crit!");
					healthyy = healthyy -(d1.damage *2);
					System.out.println("Dragon " + d2.name + " gets critied from " + d1.name + " and now has " + healthyy + " health");

				} else {

				healthyy = healthyy - d1.damage;
				System.out.println("Dragon " + d2.name + " gets hit from " + d1.name + " and now has " + healthyy + " health");
				}
				if(healthyy < 1) {
					d2.killed();
				}
			} else {
				System.out.println("Dragon " + d2.name + " dodges!");
			}
			
		}
	}
		
		public static void damageCalculator(Dragon x, Dragon y) {
			
			int healthyx = x.health;
			int healthyy = y.health;
			
		//	if(chance == )
			
	}
		public static boolean dodgeChance(Dragon x) {
			int chance = rand.nextInt(100)+1;
			if(chance > x.dodge) {
				return true;
			} else {
				return false;
			}
		}
		public static boolean critChance(Dragon x) {
			int chance = rand.nextInt(100)+1;
			if(chance <= x.crit) {
				return true;
			} else {
				return false;
			}
		}

}
