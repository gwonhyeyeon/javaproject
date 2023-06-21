package java_0620_1;

import java.awt.event.KeyEvent;



class Missile extends GraphicObject {
	boolean launched = false;

	public Missile(String name, int width, int height) {
		super(name);
		y = -200;
	}

	public void update() {
		if (launched)
			y -= 20;
		if (y < -100)
			launched = false;
	}

	public void keyPressed(KeyEvent event, int x, int y) {
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;
			this.x = x;
			this.y = y;
		}
	}
}
