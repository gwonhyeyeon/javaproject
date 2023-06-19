package java_0616;

import javax.swing.JLabel;

public class TimerRunnable implements Runnable {
	private JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public synchronized void run() {
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