package java_0615;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class MyCounter extends JFrame implements ActionListener{
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;
	private Timer timer;
	int delay = 10;
	
	public MyCounter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		//jpanel 객체를 생성하는데 
		JPanel panel = new JPanel();
		//배치관리자를 지정하지 않겠다.
		panel.setLayout(null);
		//panel.setLayout(new FlowLayout());
		//이렇게 적으면 버튼이 숫자와 나란이 옆으로 출력
		//labels은 text문구 배열에 크기가 3
		labels = new JLabel[3];
		numbers = new int[3];
		//for문을 이용해 labels에 값 지정하기
		for(int i = 0; i< 3; i++) {
			//numbers가 출력되는데 numbers는 아래 actionPerformed 메소드에서 확인
			labels[i]= new JLabel("" + numbers[i]);
			labels[i].setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 100));
			labels[i].setSize(100,100);
		//labels의 x값은 배열의 index만큼 곱해주면
			//옆으로 나란히 출력할 수 있다. 설정 안하면 겹쳐서 출력
			labels[i].setLocation(100 + 100 * i, 20);
			panel.add(labels[i]);
		}	
		button = new JButton("슬롯");
		button.setSize(250, 50);
		button.setLocation(100,150);
		panel.add(button);
		//버튼 눌렀을 때 actionListener발생
		button.addActionListener(this);
		add(panel);
		setTitle("My Game");
		setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent event) {
			if(timer == null) {
				timer = new Timer(delay, new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					for( int i = 0; i < 3; i++) {
						numbers[i] = (int) (Math.random()* 10);
						labels[i].setText("" + numbers[i]);
					}
				}	
			});
			timer.start();
		}else {
			timer.stop();
			timer = null;
			checkResult();
	}
	}			
	private void checkResult() {
		if(numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
			JOptionPane.showMessageDialog(this,"승리!");
		}else {
			JOptionPane.showMessageDialog(this, "패배!");
		}		
	}

//	@Override
//	public void actionPerformed(ActionEvent event) {
//		for( int i = 0; i < 3; i++) {
//			//numbers 랜덤으로 숫자를 출력한다. 0~9.999999까지의 난수
//			//깔끔하게  int형으로 형변환 해주기
//			numbers[i] = (int) (Math.random() * 10);
//			//setText : 랜덤으로 만든 숫자를 출력하기 위한 코드
//			labels[i].setText(("" + numbers[i]));
//		}
//	}
		
}

public class Ex_02SlotMachine {

	public static void main(String[] args) {
		new MyCounter();
	}

}
