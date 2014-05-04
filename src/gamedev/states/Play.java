/**
 * Author: NHS Tech Club
 * License: GNU Public License v2.0
 */
package gamedev.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

	private Image player, movingDown, movingUp, movingRight, movingLeft;
	private Image bg;
	private float xPos = 0;
	private float yPos = 0;
	boolean quit = false;

	/**
	 * Create the menu class
	 */
	public Play(int state) {

	}

	/**
	 * Start the menu state
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("res/map/map.png");
		player = new Image("res/sprites/front.png");
		movingUp = new Image("res/sprites/back.png");
		movingDown = new Image("res/sprites/front.png");
		movingRight = new Image("res/sprites/right.png");
		movingLeft = new Image("res/sprites/left.png");
	}

	/**
	 * Draw the first image for the state
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(player, xPos, yPos);
	}

	/**
	 * Gives the illusion of animation, draws the class
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyDown(Input.KEY_W)) {
			yPos -= 3;
			player = movingUp;
		}
		if (input.isKeyDown(Input.KEY_S)) {
			yPos += 3;
			player = movingDown;
		}
		if (input.isKeyDown(Input.KEY_A)) {
			xPos -= 3;
			player = movingLeft;
		}
		if (input.isKeyDown(Input.KEY_D)) {
			xPos += 3;
			player = movingRight;
		}

	}

	/**
	 * @return the ID of the game state
	 */
	public int getID() {
		return 1;
	}
}
