/**
 * Author: NHS Tech Club
 * License: GNU Public License v2.0
 */
package gamedev.states;

import gamedev.objects.Player;
import gamedev.objects.Star;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

	private Player p = null;
	private boolean starred = false;
	private boolean showMenu = false;
	private boolean paused = false;
	private ArrayList<Star> stars = new ArrayList<Star>();

	/**
	 * Create the menu class
	 */
	public Play() {}

	/**
	 * Start the menu state
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		p = new Player(gc);
	}

	/**
	 * Draw the first image for the state
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		g.setBackground(Color.black);

		if (!starred) {
			Random r = new Random();
			for (int i = 0; i < 75; i++) {
				stars.add(new Star(r.nextInt(gc.getWidth()), r.nextInt(gc.getHeight())));
			}
			starred = true;
		}

		for (Star star : stars) {
			g.fillOval(star.getX(), star.getY(), 5, 5);
		}

		g.drawImage(p.getImage(), p.getX(), p.getY());

		if (showMenu)
			g.drawString("Quit: (Q)\nPause: (P)", 50, 100);

	}

	/**
	 * Gives the illusion of animation, draws the class
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		Input input = gc.getInput();

		if (!paused) {

			if (input.isKeyDown(Input.KEY_W))
				p.setDirection("up");

			if (input.isKeyDown(Input.KEY_S))
				p.setDirection("down");

			if (input.isKeyDown(Input.KEY_A))
				p.setDirection("left");

			if (input.isKeyDown(Input.KEY_D))
				p.setDirection("right");

			if (input.isKeyPressed(Input.KEY_ESCAPE))
				showMenu = !showMenu;

		}
		if (showMenu && input.isKeyDown(Input.KEY_Q))
			System.exit(0);

		if (showMenu && input.isKeyDown(Input.KEY_P))
			// do pause stuff
			;
	}

	/**
	 * @return the ID of the game state
	 */
	public int getID() {
		return 1;
	}
}
