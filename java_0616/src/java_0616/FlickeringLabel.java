package java_0616;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

class EX1FlickeringLabel extends JLabel implements Runnable{
	
	private long delay;
	
	public EX1FlickeringLabel (String text, long delay) {
		//부모 클래스 jlabel 에 받아온 문자열을 라벨 텍스트로 삽입
		super(text);
		this.delay = delay;
		setOpaque(true);
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		int n = 0;
		while(true) {
			if(n==0)
				setBackground(Color.YELLOW);
			else {
				setBackground(Color.GREEN);
			}
			//베경 색 변경 후 n값 변경
			if (n == 0) {
				n = 1;
				
			}else {
				n =0;
			}try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
	
}

public class FlickeringLabel extends JFrame{
	public FlickeringLabel() {
		setTitle("Ex_02FlickeringLabel 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		EX1FlickeringLabel flabel = new EX1FlickeringLabel("깜빡", 500);
		JLabel label = new JLabel("안깜빡");
		EX1FlickeringLabel fLabel2 = new EX1FlickeringLabel("여기도 깜빡", 300);
		c.add(flabel);
		c.add(label);
		c.add(fLabel2);
		
		pack();
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new FlickeringLabel();
	}
}
