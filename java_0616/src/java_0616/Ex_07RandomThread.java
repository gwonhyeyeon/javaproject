package java_0616;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

public class Ex_07RandomThread extends Thread{
	
	private Container contentPane;
	private boolean flag = false;
	
	public Ex_07RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}
	//스레드 종료 메소드 : 플래그 전환
	void finish() {
		flag = true;
	}
	@Override
	public void run() {
		while(true) {
			int x = (int) (Math.random() * contentPane.getWidth());
			int y = (int) (Math.random() * contentPane.getHeight());
			//라벨 생성 및 크기와, 위에서 생성한 좌표로 위치 셋팅
			JLabel label = new JLabel("Java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();
			try {
				Thread.sleep(300);
				if(flag == true) {
					//컨텐트팬 안의 모든 컴포넌트 제거 후 
					contentPane.removeAll();
					//라벨 생성하여 finish빨간 글자로
					
					//크기와 마지막으로 생성한 랜덤 x, y 좌표로 지정
					label = new JLabel("finish");
					label.setSize(80, 20);
					label.setLocation(x, y);
					label.setForeground(Color.RED);
					//컨텐트팬에 넣고 다시 그리고 
					contentPane.add(label);
					contentPane.repaint();
					return;
				}
			} catch (InterruptedException e) {
				return;
			}			
		}
	}	
}
