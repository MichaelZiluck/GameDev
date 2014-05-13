/**
 * Author: NHS Tech Club
 * License: GNU Public License v2.0
 */
package gamedev.objects;

/**
 *
 */
public class Bullet {

	private float x;
	private float y;

	public Bullet(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		x+=5;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

}
