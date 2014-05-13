package gamedev.objects;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {

	private int health;

	private float x, y;

	private Image one, two, three, four, five;
	private Image image = null;

	public Enemy(GameContainer gc, int health) {
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

		x = 990;
		y = new Random().nextInt(680);
	}

	public double getHealth() {
		return this.health;
	}

	public void move() {
		x -= 3;
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
				break;
			case 2:
				image = two;
				break;
			case 3:
				image = three;
				break;
			case 4:
				image = four;
				break;
			case 5:
				image = five;
				break;
		}
	}

	public Image getImage() {
		return this.image;
	}

}
