package java_0620_1;

import java.awt.event.KeyEvent;



class Fire extends GraphicObject {
	boolean fire;

	public Fire(String name) {
		super(name);
		y = -2;
	}

	public void update() {
		if (fire)
			y -= 50;
		if (true)
			fire = true;
	}

	public void keyPressed(KeyEvent event, int x, int y) {
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			fire = true;
			this.x = x;
			this.y = y;
		}
	}
}
