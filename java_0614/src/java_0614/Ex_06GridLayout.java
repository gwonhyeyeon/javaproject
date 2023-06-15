package java_0614;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex_06GridLayout extends JFrame {
	
	public Ex_06GridLayout() {
		//jframe 타이틀, 닫기 설정
		setTitle("GridLayout 테스트 입니다.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//4행 2열의 그리드 레이아웃 객체 생성
		GridLayout grid = new GridLayout();
		grid.setVgap(5);
		//jframe에 컴포넌트 넣을 ContentPane 가져오기
		Container c = getContentPane();
		//레이아웃 적용
		c.setLayout(grid);
		//JFrame 각 컴포넌트 삽입
		//컨텐트 팬에 JLabel 컴포넌트를 추가합니다. 
		c.add(new JLabel("이름")); 
		c.add(new JTextField("")); 
		c.add(new JLabel("학번")); 
		c.add(new JTextField("")); 
		c.add(new JLabel("학번")); 
		c.add(new JTextField("")); 
		c.add(new JLabel("과목")); 
		c.add(new JTextField("")); 
		
	//jframe 사이즈, 가시성 설정
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex_06GridLayout();
	}
}
