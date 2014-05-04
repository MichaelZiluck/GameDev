/**
 * Author: NHS Tech Club
 * License: GNU Public License v2.0
 */
package gamedev.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	/**
	 * Mouse location
	 */
	private int xpos = 0;
	private int ypos = 0;

	/**
	 * Create the menu class
	 */
	public Menu(int state) {

	}

	/**
	 * Start the menu state
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}

	/**
	 * Draw the first image for the state
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.blue);
		g.fillOval(75, 100, 100, 100);
		g.drawString("Play Now!", 80, 70);
		g.drawString("Mouse Position:\nx: " + xpos + "\ny: " + ypos, 200, 200);
	}

	/**
	 * Gives the illusion of animation, draws the class
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		xpos = input.getMouseX();
		ypos = input.getMouseY();
		if ((xpos > 75 && xpos < 175) && (ypos > 100 && ypos < 200)) {
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(1);
			}
		}

	}

	/**
	 * @return the ID of the game state
	 */
	public int getID() {
		return 0;
	}

}
