package Pkg;
import java.util.*;

public class Dragon {
	public Random rand = new Random();
	
	public int name;
	public int health;
	public int damage;
	public int dodge;
	public int crit;
	public boolean flying;
	public boolean isAlive = true; 
	public int level = 1;


	
	Dragon(int name){
		this.name = name;
		isFlying();
		dragonType();
	}
	
	public void levelUp() {
		this.health += rand.nextInt(40)+10;
		this.damage += rand.nextInt(10)+10;
		this.level += 1;
		if(this.flying == true) {
			if(this.dodge < 79 && this.crit < 79) {
			this.crit += rand.nextInt(10)+10;
			this.dodge += rand.nextInt(10)+10;
			} else {
				this.health += rand.nextInt(40)+10;
				this.damage += rand.nextInt(10)+10;
			}
		} else {
			if(this.dodge < 80 && this.crit < 80) {
				this.crit += rand.nextInt(5)+5;
				this.dodge += rand.nextInt(5)+5;
				} else {
					this.health += rand.nextInt(40)+10;
					this.damage += rand.nextInt(10)+10;
				}
		}
	} 
	public void isFlying() {
		int decider = rand.nextInt(2);
		if(decider == 1) {
			this.flying = true;
		} else {
			this.flying = false;
		}
	}
	
	public void dragonType() {
		if(this.flying == true) {
			this.health = rand.nextInt(100)+50;
			this.damage = rand.nextInt(30)+20;
			this.dodge = rand.nextInt(10)+20;
			this.crit = rand.nextInt(10)+20;
		} else {
			this.health = rand.nextInt(100)+100;
			this.damage = rand.nextInt(30)+40;
			this.dodge = rand.nextInt(5)+5;
			this.crit = rand.nextInt(5)+5;
		}
		
		
	}
	public void stats() {
		System.out.print("His tag is: " + this.name );
		System.out.print(" ");

//		System.out.println("Is he Alive? " + this.isAlive); 
		System.out.print("His level is: " + this.level);
		System.out.print(" ");

		System.out.print("Can he fly? " + this.flying);
		System.out.print(" ");

		System.out.print("Health is: " + this.health);
		System.out.print(" ");

		System.out.print("Damage is " + this.damage);
		System.out.print(" ");

		System.out.print("Dodge chance is: " + this.dodge);
		System.out.print(" ");

		System.out.print("Crit chance is: " + this.crit);
		System.out.println("");
	}
	public void killed() {
		
			this.isAlive = false;
		
	}
	public boolean critChance() {
		int chance = rand.nextInt(100)+1;
		if(chance <= this.crit) {
			return true;
		} else {
			return false;
		}
	}
	public boolean dodgeChance() {
		int chance = rand.nextInt(100)+1;
		if(chance > this.dodge) {
			return true;
		} else {
			return false;
		}
	}
}
