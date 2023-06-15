package java_0614;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex_05KeyCode extends JFrame{
	
	private JLabel la = new JLabel("start!!");
	
	public Ex_05KeyCode() {
		setTitle("Key Code에서 f1키 : 초록색, %키 노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		//addKeyListener 메소드를 통해 키보드 이벤트추가 
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		setSize(300, 150);
		setVisible(true);
		//키 이벤트 포커스를 받을 컴포넌트가 여러 개일 때 우선순위 지정
		//키 이벤트는 포커스가 위치해 있어야 발생한다. 
		//setVisible(true)다음에 써줘야 한다. 
		c.setFocusable(true);
	}
	//키 이벤트 관련 클래스 
	//KeyAdapter 클래스를 활용해 코드 간략화
	 class MyKeyListener implements KeyListener {
		 
			@Override
			public void keyPressed(KeyEvent e) {
				//입력된 키보드 키의 코드 번호값 획득
				//키값 그대로 획득 하려면 getKeyChar() 메소드 활용
				la.setText(e.getKeyText(e.getKeyCode()));
				//키보드 이벤트의 e의 keycode를 받은 후 그것을 텍스트로 바꾸고, 
				//그것을 변수 la에 저장함
				//getKeyChar : 키의 문자(유니코드)알아내기
				Container contentPane = (Container) e.getSource();
				if( e.getKeyChar() == '%')//%가 입력됐을 때 배경색을 바꿈
					contentPane.setBackground(Color.YELLOW);
				//getKeyCode : 입력된 키의 가상 키 값 알아내기 
				//f1이 입력 됐을 때 배경색을 바꿈
				else if (e.getKeyCode() == KeyEvent.VK_F1)
					contentPane.setBackground(Color.GREEN);
			}
			@Override
			public void keyTyped(KeyEvent e) {	}
			@Override
			public void keyReleased(KeyEvent e) {}
		}

	public static void main(String[] args) {
		new Ex_05KeyCode();
	}
}
//가상키 Virtual Key
//유니코드든 아니든(제어키) 모든 키에 자바의 가상 키 코드가 정의되어 있음
//가상 키 코드는 KeyEvent  클래스에 상수로 선언
//VK_0~VK_9 0에서 9까지의 키 유니코드값과 동일하다. 
