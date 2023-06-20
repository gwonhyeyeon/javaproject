package java_0619;

public class ConsumerThread extends Thread{
	E01MyLabel bar;
	
	public ConsumerThread(E01MyLabel bar) {
	this.bar = bar;
	}
	public void run() {
		while (true) {
			try {
				sleep(200);
				bar.consume();
			} catch (InterruptedException e) {
				return;
			}
		}	
	}
}
