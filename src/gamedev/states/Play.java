/**
 * Author: NHS Tech Club
 * License: GNU Public License v2.0
 */
package gamedev.states;

import gamedev.objects.Bullet;
import gamedev.objects.Enemy;
import gamedev.objects.Player;
import gamedev.objects.Star;

import java.util.ArrayList;
import java.util.Iterator;
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
	private boolean showMenu = false;
	private boolean paused = false;

	private int time = 0;

	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Star> stars = new ArrayList<Star>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	/**
	 * Create the menu class
	 */
	public Play() {}

	/**
	 * Start the menu state
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		p = new Player(gc);
		Random r = new Random();
		for (int i = 0; i < 75; i++)
			stars.add(new Star(r.nextInt(gc.getWidth()) - 248, r.nextInt(gc.getHeight())));
	}

	/**
	 * Draw the first image for the state
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		g.setBackground(Color.black);

		for (Star star : stars)
			g.fillOval(star.getX(), star.getY(), 5, 5);

		g.drawImage(p.getImage(), p.getX(), p.getY());

		for (Enemy e : enemies)
			g.drawImage(e.getImage(), e.getX(), e.getY());

		for (Bullet b : bullets)
			g.fillOval(b.getX(), b.getY(), 6, 6);

		if (showMenu)
			g.drawString("Quit: (Q)\nPause: (P)", 50, 100);

		g.drawString("Score: " + p.getScore(), gc.getWidth() - 225, 15);

		g.drawLine(gc.getWidth() - 250, gc.getHeight(), gc.getWidth() - 250, 0);
		g.drawLine(gc.getWidth() - 251, gc.getHeight(), gc.getWidth() - 251, 0);
		g.drawLine(gc.getWidth() - 252, gc.getHeight(), gc.getWidth() - 252, 0);

	}

	/**
	 * Gives the illusion of animation, d1raws the class
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		Input input = gc.getInput();

		if (!paused) {

			time++;

			if (time == 60) {
				Random r = new Random();
				enemies.add(new Enemy(gc, 1 + r.nextInt(5)));
				time = 0;
			}

			Iterator<Enemy> iter = enemies.iterator();
			Enemy e = null;

			while (iter.hasNext()) {
				e = iter.next();
				e.move();
				if (e.getX() <= 0)
					iter.remove();
			}

			Iterator<Bullet> iter2 = bullets.iterator();
			Bullet b = null;

			while (iter2.hasNext()) {
				b = iter2.next();
				b.move();
				if (b.getX() >= gc.getWidth())
					iter2.remove();
			}

			if (input.isKeyDown(Input.KEY_W))
				p.setDirection("up");

			if (input.isKeyDown(Input.KEY_S))
				p.setDirection("down");

			// if (input.isKeyDown(Input.KEY_A))
			// p.setDirection("left");
			//
			// if (input.isKeyDown(Input.KEY_D))
			// p.setDirection("right");

			if (input.isKeyPressed(Input.KEY_SPACE))
				bullets.add(new Bullet(p.getX() + p.getImage().getWidth(), p.getY() + (p.getImage().getHeight() / 2)));

			if (input.isKeyPressed(Input.KEY_ESCAPE))
				showMenu = !showMenu;

		}
		if (showMenu && input.isKeyDown(Input.KEY_Q))
			System.exit(0);

		if (showMenu && input.isKeyPressed(Input.KEY_P))
			paused = paused ? false : true;

	}

	/**
	 * @return the ID of the game state
	 */
	public int getID() {
		return 1;
	}
}
