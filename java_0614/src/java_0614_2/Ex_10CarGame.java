package java_0614_2;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class MyPanel2 extends JPanel {
	BufferedImage img = null;
	//자동차 초기 위치 설정한다. 
	int img_x = 100;
	int img_y = 100;
	
	public MyPanel2() {
		try {
			//해당 경로에 잇는 이미지 파일 객체 생성
			img = ImageIO.read(new File("C://temp//car1.gif"));
			//경로에 이미지 파일이 없을 경우 에러 출력
		} catch (Exception e) {
			System.out.println("no image");
			System.exit(1);
		}
		//무명 클래스는 해당 시점에서 동작한 후 사라지며 다른 부분에서 접근이 불가능 하다
		addKeyListener(new KeyListener() {
		//keyPressed, keyReleased, keyPressed k 소문자로 적어준다. 
			//keyTyped(KeyEvent e) : 문자를 눌렀을 때 호출, 문자키에만 반응합니다.
			//keyReleased(KeyEvent e) : 키보드를 뗏을 때, 호출, 모든 키보드에 반응합니다. 
			//keyPressed(KeyEvent e) : 키보드를 눌렀을 때 , 호출 모든 키보드에 반응합니다. 
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {//방향키를 사용해 이미지 이동
				case KeyEvent.VK_UP:
					img_y -=10;
					break;
				case KeyEvent.VK_DOWN:
					img_y +=10;
					break;
				case KeyEvent.VK_LEFT:
					img_x -=10;
					break;
				case KeyEvent.VK_RIGHT:
					img_x +=10;
					break;

				default:
					break;
				}
				//키보드 이벤트가 진행되면 repaint 메소드가 실행돼 이미지를 실시간으로 업데이트함
				repaint();
			}
		});
	}	
}

public class Ex_10CarGame {
	public static void main(String[] args) {
		new Ex_10CarGame();
	}
}
