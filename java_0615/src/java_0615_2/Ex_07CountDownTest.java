package java_0615_2;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex_07CountDownTest extends JFrame{
	
	private JLabel label;
	
	class MyThread extends Thread {
		
		public void run() {
			for( int i = 10; i >=0; i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText(String.valueOf(i));
			}
			System.exit(0);
		}	
	}
	Ex_07CountDownTest() {
		setTitle("카운트다운");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//초기 jlabel 객체 상태 지정
		label = new JLabel("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		//jframe.에 입력
		add(label);
		setVisible(true);
		
		MyThread t = new MyThread();
		t.start();
	}
	public static void main(String[] args) {
		new Ex_07CountDownTest();
	}
}
