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
	private Image start = null, score = null, exit = null;

	/**
	 * Create the menu class
	 */
	public Menu() {}

	/**
	 * Start the menu state
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		try {
			start = new Image("res/buttons/blueStart.png");
			score = new Image("res/buttons/blueScore.png");
			exit = new Image("res/buttons/blueQuit.png");
		} catch (SlickException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Draw the first image for the state
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.blue);

		g.drawImage(start, (gc.getWidth() / 2) - (start.getWidth() / 2), 200);

		g.drawImage(score, (gc.getWidth() / 2) - (score.getWidth() / 2), 315);

		g.drawImage(exit, (gc.getWidth() / 2) - (exit.getWidth() / 2), 430);

		g.drawString("Mouse Position:\nx: " + xpos + "\ny: " + ypos, 200, 200);
	}

	/**
	 * Gives the illusion of animation, draws the class
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		xpos = input.getMouseX();
		ypos = input.getMouseY();

		if ((xpos >= 590 && xpos < 690) && (ypos >= 200 && ypos <= 300)) {
			if (input.isMousePressed(0)) {
				sbg.enterState(1);
			}
		}
		if ((xpos >= 590 && xpos < 690) && (ypos >= 315 && ypos <= 415)) {
			if (input.isMousePressed(0)) {
				System.out.println("Went to scores.");
			}
		}
		if ((xpos >= 590 && xpos < 690) && (ypos >= 430 && ypos <= 530)) {
			if (input.isMousePressed(0)) {
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
