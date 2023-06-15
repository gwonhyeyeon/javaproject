package java_0614;
//마우스 클릭에 따른 JLabel 객체 조정
//Follow 문구의 좌표값을 얻어서 마우스 클릭하면 
//문구가 마우스 찍은 곳으로 움직이게!
//JLabel 객체 생성 후 문자 입력

import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Ex_04 extends JFrame{
	
	private JLabel la = new JLabel("Follow");
	
	public Ex_04() {
		
		//jframe설정
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//swing에서 모든 컴포넌트를 받을 수 있는 컨테이너 객체 생성.
		Container c = getContentPane();
		//jframe 객체에 마우스 이벤트 설정
		c.addMouseListener(new MyMouseListener());
		//배치관리자 제거
		//setLayout 메소드에 null을 입력해
		//내부 요소들의 정렬 방식을 지정하지 않는다. 
		c.setLayout(null);
		//이후 JLabel 객체의 정보를 지정한다. 
		 la.setSize(50, 20);
		 la.setLocation(30, 30);
		 //jframe rorcpdp dlqfur
		 c.add(la);
		 setSize(500, 500);
		 setVisible(true);
	}
class MyMouseListener implements MouseListener {
		//마우스가  클릭되면
		public void mousePressed(MouseEvent e) {
			//이벤트가 어떤 사건, x좌표 y좌표 하나하나
			//마우스가 눌렀을 떄 그 좌표값을 알아야 되는데 그 값을 어떻게 얻어오지?
			//get값을 가져온다. x좌표값을 가져온다. 
			//set은 입력받은 값을 출력한다. 
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}

		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	public static void main(String[] args) {
		new Ex_04();
	}
}
//사용자의 키보드 조작에 따른 이벤트 발생
//키를 누르는 순간, 누른 키를 떼는 순간, 누른 키를 떼는 순간(UNICODE키 경우에만)
//
//★키 이벤트를 받을 수 있는 조건
//모든 컴포넌트가 가능하지만, 현재 포커스(focus)를 가진 컴포넌트
//
//포커스란?
//컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
//<컴포넌트에 포커스 설정하는 방법>
//setVisivle(true) //스윙 프레임 출력 이후에 포커스를 추가해야 한다. 
//component.setFocusable(true);
//component가 포커스를 받을 수 있도록 설정
//자바 플랫폼 마다 실행 환경의 초기화가 다를 수 있기 때문에 필요한 코드이다. 

