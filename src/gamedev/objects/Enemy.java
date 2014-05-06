package gamedev.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {

	private int health;

	private float x = 0, y = (float) (500 * Math.pow(0.9, x));

	private Image one, two, three, four, five;
	private Image image = null;

	public Enemy(int health) {
		this.health = health;
		try {
			five = new Image("res/sprites/enemies/five.png");
			four = new Image("res/sprites/enemies/four.png");
			three = new Image("res/sprites/enemies/three.png");
			two = new Image("res/sprites/enemies/two.png");
			one = new Image("res/sprites/enemies/one.png");
			assignImage();
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}

	public double getHealth() {
		return this.health;
	}

	public void moveIn() {
		x += 10;
		y = (float) (300 * Math.pow(0.9, x));
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	public void setHealth(int health) {
		this.health = health;
		assignImage();
	}

	private void assignImage() {
		switch (health) {
			case 1:
				image = one;
			case 2:
				image = two;
			case 3:
				image = three;
			case 4:
				image = four;
			case 5:
				image = five;
				break;
		}
	}

	public Image getImage() {
		return this.image;
	}

}
