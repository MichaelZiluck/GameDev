/**
 * Author: NHS Tech Club
 * License: GNU General Public License v2.0
 */
package gamedev;

import gamedev.states.Menu;
import gamedev.states.Play;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	/**
	 * The name of the game
	 */
	public static final String NAME = "TBD";

	// state numbers
	public static final int menu = 0;
	public static final int play = 1;

	/**
	 * Create this class
	 */
	public Game(String game) {
		super(NAME);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}

	@Override
	/**
	 * Initialize the game states
	 */
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
		if (gc instanceof AppGameContainer && !gc.isFullscreen()) {
			String[] icons = { "res/icon/Ap_icon.png", "res/icon/Ap_icon2.png" };
			gc.setIcons(icons);
		}
	}

	/**
	 * This runs when the jar is run
	 */
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(NAME));
			appgc.setDisplayMode(640, 360, false);
			appgc.start();
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}

}
