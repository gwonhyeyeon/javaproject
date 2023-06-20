package java_0619;
//EX01
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class E01MyLabel extends JLabel {
	int barSize;
	int maxBarSize;
	
	//생성자 : maxBarSize 받아서 초기화
	
	E01MyLabel(int maxBarSize){
		this.maxBarSize = maxBarSize;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.MAGENTA);
		
		int width = (int)(((double) (this.getWidth()))/maxBarSize*barSize);
		//위의 값 0이 아니면 속이 채워지고 가로 크기가 위의 값인 사각형 그릭
		//즉 라벨 위에 width 크기 만큼 마젠다색 사각형 그림
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized void fill() {
		if( barSize == maxBarSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint();
		//notify() : 일시정지 상태인 하나의 스레드를 실행 대기 상태로 변화시킴
		//공유 객체에 접근한 하나의 스레드가 일시 정지라면 다시 실행 대기 상태로 만듦
		notify();		
	}
	synchronized void consume() {
		//fill메소드와 비슷한 로직이지만
		//얘는 barSize가 0이면 접근한 스레드 일시정지 시키고
		if(barSize == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}	
		barSize--;
		repaint();
		notify();
	}
}
