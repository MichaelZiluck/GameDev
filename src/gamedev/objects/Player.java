package gamedev.objects;

import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private float x;
	private float y;

	private int score;

	private Image player;
	private Image r, l;
	// private Image u, d;

	private String[] ds = { "left", "right", "up", "down" };
	private List<String> directions = Arrays.asList(ds);

	private Color gun;

	public Player(GameContainer gc) {
		createImages();
		setGun(Color.blue);
		score = 10;
		x = 100;
		y = (gc.getHeight() / 2) - (player.getHeight() / 2);
	}

	private void createImages() {
		try {
			// u = new Image("res/sprites/player/up.png");
			// d = new Image("res/sprites/player/down.png");
			r = new Image("res/sprites/player/right.png");
			l = new Image("res/sprites/player/left.png");
			player = r;
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}

	public void setDirection(String direction) {

		if (directions.contains(direction)) {
			switch (direction) {
				case "left":
					player = l;
					if (x <= 0)
						break;
					x -= 4;
					break;
				case "right":
					player = r;
					if (x >= 990)
						break;
					x += 4;
					break;
				case "up":
					// player = u;
					if (y <= 0)
						break;
					y -= 4;
					break;
				case "down":
					// player = d;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Color getGun() {
		return gun;
	}

	public void setGun(Color gun) {
		this.gun = gun;
	}

}
