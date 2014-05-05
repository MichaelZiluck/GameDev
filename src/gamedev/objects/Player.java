package gamedev.objects;

import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private float x;
	private float y;

	private Image player;
	private Image movingUp, movingDown, movingRight, movingLeft;

	private String[] ds = { "left", "right", "up", "down" };
	private List<String> directions = Arrays.asList(ds);

	public Player() {
		x = 0;
		y = 0;
		createImages();
	}

	private void createImages() {
		try {
			movingUp = new Image("res/sprites/back.png");
			movingDown = new Image("res/sprites/front.png");
			movingRight = new Image("res/sprites/right.png");
			movingLeft = new Image("res/sprites/left.png");
			player = movingDown;
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}

	public void setDirection(String direction) {
		if (directions.contains(direction)) {
			switch (direction) {
				case "left":
					player = movingLeft;
					if (x <= 0)
						break;
					x -= 4;
					break;
				case "right":
					player = movingRight;
					if (x >= 1240)
						break;
					x += 4;
					break;
				case "up":
					player = movingUp;
					if (y <= 0)
						break;
					y -= 4;
					break;
				case "down":
					player = movingDown;
					if (y >= 680)
						break;
					y += 4;
					break;
			}
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Image getImage() {
		return player;
	}

}
