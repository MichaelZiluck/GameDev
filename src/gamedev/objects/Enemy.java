package gamedev.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {

	private double health;

	private Image one, two, three, four, five;
	private Image image = null;

	public Enemy(double health) {
		this.health = health;
		try {
			five = new Image("res/sprites/enemies/five.png");
			four = new Image("res/sprites/enemies/four.png");
			three = new Image("res/sprites/enemies/three.png");
			two = new Image("res/sprites/enemies/two.png");
			one = new Image("res/sprites/enemies/one.png");
			switch ("" + health) {
				case "5":
					image = five;
				case "4":
					image = four;
				case "3":
					image = three;
				case "2":
					image = two;
				case "1":
					image = one;
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
		this.health = health;
	}

	public Image getImage() {
		return this.image;
	}

}
