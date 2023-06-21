package java_0620;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.management.MXBean;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GraphicObject {
	BufferedImage img = null;
	//이미지 객체를 만들기 위한 클래스 이미지를 읽어올 수 있다.  
	int x = 0, y = 0;
	
	//생성자에서 이미지를 읽는다.
	public GraphicObject(String name) {
		try {
			img = ImageIO.read(new File(name));
			//파일명을 매개변수로 받아 이미지를 읽는다. 
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	public void update() {
	}	
	//화면에 이미지를 그린다.
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	public void keyPressed(KeyEvent event) {
	}
}
//GraphicObject상속,미사일을 나타내는 클래스 정의
class Missile extends GraphicObject {
	boolean launched = false;
	//미사일 lauched 변수로 스위치 역할 미사일 발사 시키는 역할을 한다. 
	public Missile(String name) {
		super(name); //파일명으로 이미지 불러오기. 부모메서드 그대로 상속
		y = -200; // 미사일의 초기 위치 
	}
	public void update() {
		//미사일 위치를 변경 부모의 update메서드 미사일 클래스에 맞게 구현 
		if (launched)//스위치가 발동되면 
			y -= 10;//y축으로 -10씩 (위쪽으로) 계속 이동한다.  
		if (y < -100000) //일정 위치를 벗어나면(화면에서 벗어나면)
			launched = false;//스위치는 꺼진다. 
		
	}	
	//스페이스키가 눌리면 미사일이 발사
	public void keyPressed(KeyEvent event, int x, int y) {
		if (event.getKeyCode() == KeyEvent.VK_SPACE) { //미사일의 스페이스 키를 누르면
			launched = true; //스페이스 키를 누르면 스위치 launched값을 true바꾸어서 발동시킨다. 
			this.x = x; 
			System.out.println("spaceship.x ="+x);
			this.y = y;
			System.out.println("spaceship.y ="+y);
		}
	}
}
//GraphicObject상속, Enemy클래스 작성
class Enemy extends GraphicObject {
	int dx = -10;

	public Enemy(String name) {
		//파일명을 불러와 이미지를 불러온다. 
		super(name);
		x = 500;//초기위치
		y = 0;
		
	}
	//Enemy캐릭터의 위치 변경
	public synchronized void update(int m) { //enemy의 움직임은 x축으로 -10씩 계속 이동한다 (오른쪽에서 왼쪽으로)
		x += dx;
		if (x < 0) //x축이 0이 되면 다시 반대쪽으로 +10씩 계속 이동한다. 
			dx = +10;
		if (x > 500)//x축이 500위치에서는 다시 반대편으로 이동한다. 
			dx = -10;	
		if(x == m || x +10 == m || x -10 == m) {
			System.out.println("충돌");
			Thread.interrupted();
		}
	}
}
//GraphicObject상속, SpaceShip클래스 작성
class SpaceShip extends GraphicObject {
	public SpaceShip(String name) {
		//우주선 이미지를 불러온다. 
		super(name);
		x = 150;//우주선의 초기위치 
		y = 350;
	}
	//화살표 키에 따라 플레이어 캐릭터 위치 변경
	//우주선의 움직임은 key이벤트로 작동한다. 오른쪽, 왼쪽, 위, 아래 버튼으로 이동시킨다. 
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		}
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
		}
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
		}
	}
}
class Background extends GraphicObject {
	public Background(String name) {
		//배경이미지 불러오기 
		super(name);
		x = 0;
		y = 0;
	}
}
class MyPanel extends JPanel implements KeyListener {
	Enemy enemy;
	SpaceShip spaceship;
	Missile missile;
	Background background;
	
	//이렇게 생성된 4개의 이미지 객체를 jpanel을 생성하여 불러온다. 

	public MyPanel() {
		super();
		this.addKeyListener(this);
		//각 객체에 keylistener들이 작동하도록 한다. 
		this.requestFocus();//키 이벤트 발동을 위하여 포커스를 받을 객체를 지정
		setFocusable(true);//지정된 객체에 포커스를 발동시킨다. 이벤트가 작동하도록 
		//4개의 이미지 파일을 불러올 수 있는 인스턴스 생성자를 만든다. 
		enemy = new Enemy("enemy.png");
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		background = new Background ("background.jpg");
		
		//스레드를 이용하여 게임의 메인루프를 작성
		//각객체의 위치를 변경하고 다시 그린다.
		class MyThread extends Thread {
			public void run() {
				while (true) {		
					//3개의 움직임이 있는 객체들이 움직이는 로직이 담긴 메서드 update()를 호출한다. 
					enemy.update();
					spaceship.update();
					missile.update();
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
			}
		}
		Thread t = new MyThread();
		t.start();//스레드로 설정하고 스레드 시작
	}
	public void paint(Graphics g) {
		//4개의 객체가 이미지 상으로 나타나도록 그려준다. 
		super.paint(g);
		background.draw(g);
		enemy.draw(g);
		spaceship.draw(g);
		missile.draw(g);
	}
	//키보드 이벤트를 각 객체에 전달
	public void keyPressed(KeyEvent event) {
		spaceship.keyPressed(event);
		missile.keyPressed(event, spaceship.x, spaceship.y);
		enemy.update(missile.x);
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
}
public class ShootingGame_Thread extends JFrame {
	public ShootingGame_Thread() {
		setTitle("Shooting Game");
		add(new MyPanel());
		setSize(500, 500);		
		setVisible(true);
	}
	public static void main(String[] args) {
		new ShootingGame_Thread();
	}
}
