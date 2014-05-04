package gamedev.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private int x;
	private int y;

	private Image player;
	private Image movingUp, movingDown, movingRight, movingLeft;

	private String[] ds = { "left", "right", "up", "down" };
	private List<String> directions = Arrays.asList(ds);

	public Player() {
		x = 0;
		y = 0;
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
				break;
			case "right":
				break;
			case "up":
				break;
			case "down":
				break;
			}
		}
	}

}
