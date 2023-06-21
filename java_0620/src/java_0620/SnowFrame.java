package java_0620;
//EX01
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SnowFrame extends JFrame {	
	public SnowFrame() {
		super("눈 내리는 샤갈의 마을");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new SnowPanel());//콘텐츠팬 설정
		setSize(300, 300);
		setResizable(false);
		setVisible(true);
	}
	class SnowPanel extends JPanel {
		ImageIcon icon = new ImageIcon("background.jpg");
		Image img = icon.getImage();
		final int SNOWS = 50;
		final int SNOW_SIZE = 10;
		Vector<Point> snowVector = new Vector<Point>();
		//눈 송이의 왼쪽 좌표Point
		public SnowPanel() {
			this.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					//패널의 위치와 크기가 설정되면 그 때 비로소 눈을 만든다. 
					addSnow();//눈을 만들고
					new SnowThread().start();//눈 내리는 스레드 시작시킨다. 
					SnowPanel.this.removeComponentListener(this);
					//snowpanel 클래스를 참조하는 객체
					// 현재 패널에 적합하도록 눈을 만들면 리스너를 제거한다. 
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			//배경 이미지를 그린다.
			drawSnow(g);
		}
		void addSnow() {//각 눈의 위치를 랜덤하게 생성하여 벡터에 삽입한다. 
			for(int i=0; i< SNOWS; i++) {
				Point p = new Point((int)(Math.random()*getWidth()),
									(int)(Math.random()*getHeight()));
				snowVector.add(p);
			}
		}
		void drawSnow(Graphics g) {//패널에 눈을 그린다
			g.setColor(Color.WHITE);
			for(int i=0; i<snowVector.size(); i++) {
				Point p = snowVector.get(i);
				g.fillOval(p.x, p.y, SNOW_SIZE, SNOW_SIZE);
			}
		}
		void changeSnowPosition() {//눈의 위치를 조정한다. 
			for(int i=0; i< SNOWS; i++) {
				Point p = snowVector.get(i);
				int xDir = Math.random() > 0.5? 1 : -1;
				//xDir이 1이면 오른쪽으로, 아니면 왼쪽으로 눈을 이동시킨다. 
				int offsetX = (int)(Math.random()*3)*xDir;
				//x축으로 이동하는 최대 거리는 3픽셀이다. 
				int offsetY = (int) (Math.random()*7);
				//y축으로 이동하는 최대 거리는 7픽셀이다. 
				p.x +=offsetX;
				if(p.x < 0)
					p.x = 0;
				p.y += offsetY;
				if(p.y > getHeight()) {
					//눈이 떨어져서 패널을 벗어나게 되면 다시 패널의 위에서 시작하게 한다. 
					p.x = (int)(Math.random()*getWidth());
					//다시 시작하는 x의 위치는 패널 내의 랜덤한 위치
					p.y = 5; //다시 시작하는 y의 위치는 패널 내의 5 픽셀 위치 
				}
			}
		}
		class SnowThread extends Thread {
			public void run() {
				while(true) {
					try {
						sleep(300);//0.3초마다 눈이 내린다. 
					} catch (InterruptedException e) {
						return;
					}
					changeSnowPosition();
					repaint();
				}
			}
		}
	}
	static public void main(String[] args) {
		new SnowFrame();
	}
}
