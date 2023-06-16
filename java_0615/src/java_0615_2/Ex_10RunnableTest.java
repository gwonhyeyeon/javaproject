package java_0615_2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;




class TimerRunnable implements Runnable {
	private JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		int n = 0;
		//텍스트 라벨의 숫자가 1초 간격으로 무한히 올라감
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
}
public class Ex_10RunnableTest extends JFrame {
	
	public Ex_10RunnableTest () {
		setTitle("Runnable을 구현한 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		setSize(250, 150);
		setVisible(true);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);
		th.start();
	}

	public static void main(String[] args) {
		new Ex_10RunnableTest();
	}
}
//내일의 과제 isPaused 필드를 사용합니다. 
//resume() 메서드 안에는 synchronized notify() 를 사용합니다. 
//쓰레드 답게 레이블을 클릭 시 addMouseListner() 를 이용합니다

//동기화(synchronized)의 의미 
//하나의 작업이 완전히 종료된 후 다른 작업 수행
//비동기식 : 하나의 작업 명령 이후(완료와 상관없이) 바로 다른 작업 명령을 수행
//동기화(synchrozied)의 필요성
//-두개의 Thread가 하나의 객체를 공유하는 경우

