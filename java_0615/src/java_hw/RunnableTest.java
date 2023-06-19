package java_hw;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

//내일의 과제 isPaused 필드를 사용합니다. 
//resume() 메서드 안에는 synchronized notify() 를 사용합니다. 
//쓰레드 답게 레이블을 클릭 시 addMouseListner() 를 이용합니다
//여기는 메인 
public class RunnableTest extends JFrame {
	
	public RunnableTest () {
		setTitle("Runnable을 구현한 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
			
		JLabel timerLabel = new JLabel();	
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		setSize(250, 150);
		setVisible(true);
			
		th.start();
	}

	public static void main(String[] args) {
		new RunnableTest();
	}
}
