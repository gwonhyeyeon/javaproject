package java_0620_1;



class Enemy extends GraphicObject {
	int dx = -10;
	int dy = -10;
	boolean siva = true;

	public Enemy(String name) {
		super(name);
		x = 500;
		y = 0;
	}

	public void update() {
		if (siva) {
			x += dx;
			y += dy;
			if (x < 0)
				dx = 10;
			if (x > 500)
				dx = -10;
			if (y < 0)
				dy = 10;
			if (y > 80)
				dy = -10;
		}
	}
}
