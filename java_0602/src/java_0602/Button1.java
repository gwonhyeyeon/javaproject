package java_0602;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
//awt가 먼저 발전된 것이 swing
import javax.swing.JFrame;
//swing 게임ui만들 때 사용한다

public class Button1 extends JFrame{
	public Button1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("대박");
		setLayout(new FlowLayout());
		Button btn1 = new Button("가위");
		Button btn2 = new Button("바위");
		Button btn3 = new Button("보");
		add(btn1);//버튼추가
		add(btn2);
		add(btn3);
		btn1.setBackground(Color.cyan);
		btn3.setForeground(Color.RED); //보 색깔만 레드
		btn2.setEnabled(false); //바위 사용안함
		setBackground(Color.PINK);
		setForeground(Color.BLUE);
		setSize(200, 200);
		setVisible(true);//보여주는 값을 참으로 해서 보여주겠다. 	
	} //인코딩 문제로 한글이 꺨수 있습니다.. 해결바람

	public static void main(String[] args) {
		new Button1();
		//main() 메소드에서 button1클래스 생성
		//button1() 생성자가 실행되므로 windows창이 출력
	}
}//awt와 swing패키지 등 어떤 언어보다 강력한 gui라이브러리를 제공하여,
//gui를 쉽게 구성할 수 있도록 해준다. 
