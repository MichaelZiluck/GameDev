/**
 * Author: NHS Tech Club
 * License: GNU Public License v2.0
 */
package gamedev.objects;

import org.newdawn.slick.Color;

/**
 *
 */
public class Bullet {

	private float x;
	private float y;

	private Color color;

	public Bullet(float x, float y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public void move() {
		x += 5;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}

}
