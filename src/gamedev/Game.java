/**
 * Author: NHS Tech Club
 * License: GNU General Public License v2.0
 */
package gamedev;

import gamedev.states.Menu;
import gamedev.states.Play;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	/**
	 * The name of the game
	 */
	public static final String NAME = "Bullet Hell";

	public static HashMap<String, Integer> scores = new HashMap<String, Integer>();

	// state numbers
	public static final int menu = 0;
	public static final int play = 1;

	// game container
	private static AppGameContainer appgc = null;

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
		gc.setVSync(true);
		// gc.setShowFPS(false);

		try {
			File file = new File(new File(Game.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile(), "scores.txt");
			if (!file.exists())
				file.createNewFile();
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "Ender: 5";
			while ((str = br.readLine()) != null) {
				int t = str.indexOf(":");
				scores.put(str.substring(0, t), Integer.parseInt(str.substring(t + 2, str.length())));
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * This runs when the jar is run
	 */
	public static void main(String[] args) {
		try {
			appgc = new AppGameContainer(new Game(NAME));
			appgc.setDisplayMode(1280, 720, false);
			appgc.start();
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}

}
