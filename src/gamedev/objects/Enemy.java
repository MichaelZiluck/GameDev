package gamedev.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {

	private double health;

	private Image one, two, three, four, five;

	public Enemy(double health) {
		this.health = health;
		try {
			switch ("" + health) {
				case "5":
					five = new Image("res/sprites/enemies/five.png");
				case "4":
					four = new Image("res/sprites/enemies/four.png");
				case "3":
					three = new Image("res/sprites/enemies/three.png");
				case "2":
					two = new Image("res/sprites/enemies/two.png");
				case "1":
					one = new Image("res/sprites/enemies/one.png");
					break;
				default:
					break;
			}
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}
	
	public double getHealth() {
		return this.health;
	}
	
	public void setHealth(double health) {
		
	}
	
	

}
