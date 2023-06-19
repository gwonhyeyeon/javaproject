package java_hw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

//이게 공유 스레드 
//wait() 
//notify() resume()메서드 만들기 
public class TimerRunnable extends JPanel implements Runnable {
	
	private JLabel timerLabel;
	public boolean isPause = false;
	
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
		
	    this.timerLabel.addMouseListener(new MouseAdapter() {
	          public void mousePressed(MouseEvent e) {
	             if (isPause) {
	                resume();
	             } else {
	                pause();
	             }
	          }
	       });
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
				synchronized (this) {
                    while (isPause) {
                        wait();
                    }
                }
			} catch (InterruptedException e) {
				return;
			}
		}	
	}
	 public synchronized void pause() {
	        isPause = true;
	    }

	 public synchronized void resume() {
	        isPause = false;
	        notify();
	    }
}