/**
 * Author: NHS Tech Club
 * License: GNU Public License v2.0
 */
package gamedev.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	// mouse position
	private int xpos = 0;
	private int ypos = 0;

	// button images
	private Image play = null;
	private Image exit = null;

	/**
	 * Create the menu class
	 */
	public Menu(int state) {

	}

	/**
	 * Start the menu state
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		try {
			play = new Image("res/buttons/playNow.png");
			exit = new Image("res/buttons/exitGame.png");
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Draw the first image for the state
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.blue);

		g.drawImage(play, (gc.getWidth() / 2) - (play.getWidth() / 2), 200);
		g.drawImage(exit, (gc.getWidth() / 2) - (exit.getWidth() / 2), 250);

		g.drawString("Mouse Position:\nx: " + xpos + "\ny: " + ypos, 200, 200);
	}

	/**
	 * Gives the illusion of animation, draws the class
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		xpos = input.getMouseX();
		ypos = input.getMouseY();
		if ((xpos >= 535 && xpos < 746) && (ypos >= 200 && ypos < 251)) {
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(1);
			}
		}

		if ((xpos >= 535 && xpos < 746) && (ypos >= 250 && ypos < 301)) {
			if (input.isMouseButtonDown(0)) {
				System.exit(0);
			}
		}
		
		if (input.isKeyDown(Input.KEY_ESCAPE))
			System.exit(0);

	}

	/**
	 * @return the ID of the game state
	 */
	public int getID() {
		return 0;
	}

}
