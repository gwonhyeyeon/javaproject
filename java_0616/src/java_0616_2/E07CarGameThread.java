package java_0616_2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class E07CarGameThread extends JFrame{//프레임 상속
	
	class MyThread extends Thread {//스레드 상속, 이너 클래스 
		private JLabel label; //라벨 선언
		private int x, y = 0;
		
		public MyThread(String fname, int x, int y) {
			this.x = x;
			this.y = y;
			label = new JLabel(); //라벨 인스턴스 생성
			label.setIcon(new ImageIcon(fname));
			//해당 문자열 이름을 가진 파일을 상대경로로 이미지 아이콘으로 생성, 라벨에 아이콘으로 세팅
			label.setBounds(x, y, 100, 100); // x, y 위치에 100*100 크기로 배치 
			add(label);//프레임에 라벨 추가
		}
		public void run() {
			for (int i = 0; i < 200; i++) {
				x += 10 * Math.random(); // x는 랜덤하게 계속 수가 더해짐
				label.setBounds(x, y, 100, 100);
				repaint();// update, paint
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//해당 예외 발생 시 순차적으로 추적
		}		
	}
	public E07CarGameThread() {//외부 클래스 생성자
		 setTitle("CarRace");
		 setSize(1150, 200);
		 setLayout(null); //프레임명, 사이즈 , 레이아웃관리자 없음
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창종료시 프로그램 종료
		 (new MyThread("jajang.png", 100, 0)).start();//x축과 y축의 좌표
		 (new MyThread("jjambbong.png", 100, 50)).start();
		 (new MyThread("tangsuyuk.png", 100, 100)).start();
		 //무명객체 스레드 실행 3개 
		 setVisible(true); //프레임 보이게 설정		
	}	
	public static void main(String[] args) {
		new E07CarGameThread();
	}
}
