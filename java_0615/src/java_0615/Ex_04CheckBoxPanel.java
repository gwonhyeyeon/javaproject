package java_0615;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex_04CheckBoxPanel extends JPanel implements ItemListener {
//체크 박스 배열 객체 생성
	JCheckBox[] buttons = new JCheckBox[3];
	//이름 문자열 생성
	String[] china = { "jajang", "jjambbong", "tangsuyuk" };
	//이미지 파일 개수에 맞춰 JLabel 3개 생성
	JLabel[] pictureLabel = new JLabel[3];
	//imegeIcon 객체도 3개 생성
	//이미지는 자바프로젝트 소스파일 저장돼 있는 상대경로에 있어야 한다. 
	//상대경로란? 현재 작업폴더(working directory) 위치를 기준으로 상대적인 경로를 표기하는 방식
	//1. C:\Users\JAE WON PARK\Desktop\JAVA1\Test_01_Month 경로에 사진 넣기
	//2. Test_01_Month에 사진 파일 넣기
	ImageIcon[] icon = new ImageIcon[3];
	
	public Ex_04CheckBoxPanel() {
		//JPanel 객체를 4등분해서 표현
		super(new GridLayout(0, 4));
		for( int i = 0; i < china.length; i++) {
			//체크박스 이름 입력
			buttons[i] = new JCheckBox(china[i]);
			//체크박스 아이템 리스너 등록
			buttons[i].addItemListener(this);//현재 객체 Ex_04CheckBoxPanel
			
			pictureLabel[i] = new JLabel(china[i] + ".png");
			icon[i] = new ImageIcon(china[i]+ ".png");
		}//체크박스 생성
		//체크박스 객체를 jpanel 첫 번째 열에 저장
		//↓checkPanel 0,1 이므로 세로로 값이 출력된다. 
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));//행위 개수, 열의 개수
		//0을 사용하면 행의 개수는 자동적으로 조정된다. 열의 개수는 1로 고정된다는 소리이다. 
		//i는 영역범위를 벗어났기 때문에 위에 i랑 다른 것!
		for( int i =0; i< 3; i++) 
			checkPanel.add(buttons[i]); //체크박스를 하나로 묶는다
			//add를 통해 jpanel 객체에 입력
			add(checkPanel);
			add(pictureLabel[0]);
			add(pictureLabel[1]);
			add(pictureLabel[2]);	
	}
	public void itemStateChanged(ItemEvent e) {
		//체크박스 선택 상태가 변하는 경우 호출
		ImageIcon[] image = null;
		//이벤트 객체로부터 체크된 체크박스 객체를 획득
		Object source = e.getItemSelectable();
		for(int i = 0; i < 3; i++) {
			if(source == buttons[i]) {
			//해당 객체가 선택되지 않았다면 
				if(e.getStateChange() == ItemEvent.DESELECTED)
					pictureLabel[i].setIcon(null);
				else 
					//picturelabel 배열 객체에 저장돼 있는 icon을 출력하는 것 즉 해당 이미지
					pictureLabel[i].setIcon(icon[i]);
				//deselected : 체크가 해제되었는지 검사한다. 
			}//체크박스가 체크된 경우 itemevent.selected를
		}//해제된 경우 
	}
	public static void main(String[] args) {
		//jframe 객체 생성
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ex_04CheckBoxPanel panel = new Ex_04CheckBoxPanel();
		panel.setOpaque(true);
		frame.add(panel);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}
}
