package java_0620;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E09BulletGameFrame extends JFrame{
	
	public E09BulletGameFrame() {
		setTitle("사격 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		p.startGame();
	}
	public static void main(String[] args) {
		new E09BulletGameFrame();
	}
}
class GamePanel extends JPanel {
	TargetThread targetThread = null;
	JLabel baseLabel = new JLabel();
	JLabel bulletLabel = new JLabel();
	JLabel targetLabel;
	
	public GamePanel() {
		setLayout(null);
		baseLabel.setSize(40,40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);
		//배경색 검정 //배치관리자 없음, 사이즈, 불투명
		ImageIcon img = new ImageIcon("chicken.jpg");
		targetLabel = new JLabel(img); //img를 라벨 객체에 담아 targetlabel
		targetLabel.setSize(img.getIconWidth(), img.getIconWidth());
		//이미지의 크기를 사이즈로 사용
		bulletLabel.setSize(10, 10);
		bulletLabel.setOpaque(true);//bulletLabel 사이즈 설정,불투명
		bulletLabel.setBackground(Color.RED);
		add(baseLabel);
		add(targetLabel);
		add(bulletLabel);	
	}//배경색 빨강, 각종 라벨들 패널에 추가 
	public void startGame() {
		baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40);
		bulletLabel.setLocation(this.getWidth()/2-5, this.getHeight()-50);
		targetLabel.setLocation(0,0);
		//베이스, 총알, 타겟의 위치 설정 베이스와 총알은 사진크기를 기반으로 설정
		targetThread = new TargetThread(targetLabel);
		targetThread.start(); baseLabel.requestFocus();
		baseLabel.addKeyListener(new KeyAdapter() {
			//베이스 라벨에 키리스너 추가 어댑터 사용, 무명 클래스 
			BulletThread bulletThread = null; //블릿스레드 레퍼런스타입 변수 생성
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '\n') { //엔터키 입력받을 때 
					if(bulletThread == null || !bulletThread.isAlive()) {
						//스레드 객체가 비었거나 스레드가 죽어있을때
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread);
						bulletThread.start();	
					} } } }); }
	class TargetThread extends Thread {//스레드 상속
		JComponent target;
		public TargetThread(JComponent target) {//생성자, 위치설정 및 메소드 호출
			this.target = target;
			target.setLocation(0,0);
			target.getParent().repaint();
		}
		public void run() {//런 메서드
			while(true) {//무한반복				
				int x = target.getX()+2;
				int y = target.getY()+2; 
			    if(x > 80)
			    	y = target.getY() -2;
			    if(x > 160)
			    	y = target.getY() +2;
			    if( x> 240)
			    	y= target.getY() -2;
			    if(x > 320)
			    	y = target.getY() +2;
				System.out.println(x);
				System.out.println(y);
				if(x > GamePanel.this.getWidth())
					target.setLocation(0,0);
				else 
					target.setLocation(x, y);
				try {
					sleep(20);
				} catch (InterruptedException e) {
					
				}
				
			}
		}	
	}
	class BulletThread extends Thread {//스레드 상
		JComponent bullet, target;
		Thread targetThread;
		public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
			this.bullet = bullet;
			this.target = target;
			this.targetThread = targetThread;
		}
		public void run() {
			while(true) {
				if(hit()) {
					target.setLocation(0,0);
					targetThread.interrupt();
					bullet.setLocation(bullet.getParent().getWidth()/2 -5,
					bullet.getParent().getHeight() - 50);
					return;
				}else {
					int x = bullet.getX();
					int y = bullet.getY() - 5; //hit가 false면 y위치 변화
				if(y < 0) {//y가 위치를 넘어서면 미사일 스레드를 종료하고 미사일 객체를 원위치 시킴
					bullet.setLocation(bullet.getParent().getWidth()/2 -5,
					bullet.getParent().getHeight() - 50);
					return;
				}
				bullet.setLocation(x, y); //위치 변경
				}
				try {
					sleep(20);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		}
		
private boolean hit() {
	if(targetContains(bullet.getX() + bullet.getWidth() -1, bullet.getY()) || target.contains(bullet.getX() +bullet.getWidth() -1, bullet.getY() + bullet.getHeight() -1) || targetContains(bullet.getX(), bullet.getY() +bullet.getHeight() -1))
		return true;
	else 
		return false;
	
}
private boolean targetContains(int x, int y) {
	if(((target.getX() <= x) && (target.getX() +target.getWidth() -1 >= x))&& ((target.getY() <= y) &&(target.getY() + target.getHeight() -1 >= y)))
		return true;
	else {
		return false;
	}
}
	}
}
