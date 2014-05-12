package gamedev.objects;

import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private float x;
	private float y;

	private Image player;
	private Image u, d, r, l, ur, ul, dr, dl;

	private String[] ds = { "left", "right", "up", "down" };
	private List<String> directions = Arrays.asList(ds);

	public Player(GameContainer gc) {
		createImages();
		x = (gc.getWidth() / 2) - (player.getWidth() / 2);
		y = 600;
	}

	private void createImages() {
		try {
			u = new Image("res/sprites/player/back.png");
			d = new Image("res/sprites/player/front.png");
			r = new Image("res/sprites/player/right.png");
			l = new Image("res/sprites/player/left.png");
			ur = new Image("res/sprites/player/upRight.png");
			ul = new Image("res/sprites/player/upLeft.png");
			dr = new Image("res/sprites/player/downRight.png");
			dl = new Image("res/sprites/player/downLeft.png");
			player = d;
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}

	public void setDirection(String direction) {
		if (directions.contains(direction)) {
			switch (direction) {
				case "left":
					if (x <= 0)
						break;
					x -= 4;
					break;
				case "right":
					if (x >= 1240)
						break;
					x += 4;
					break;
				case "up":
					if (y <= 0)
						break;
					y -= 4;
					break;
				case "down":
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

	public void setImage(int type) {
		switch (type) {
			case 0:
				player = u;
				break;
			case 1:
				player = r;
				break;
			case 2:
				player = d;
				break;
			case 3:
				player = l;
				break;
			case 4:
				player = ur;
				break;
			case 5:
				player = ul;
				break;
			case 6:
				player = dr;
				break;
			case 7:
				player = dl;
				break;
		}
	}

	public Image getImage() {
		return player;
	}

}
