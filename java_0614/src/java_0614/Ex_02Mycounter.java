package java_0614;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ex_02Mycounter extends JFrame implements ActionListener{
	
	private JLabel label, label1;
	private JButton increaseButton, stopButton;
	private int count = 0;
	private Timer timer;
	
	public Ex_02Mycounter() {
		JPanel panel = new JPanel();
		label = new JLabel("Counter");
		panel.add(label);
		
		label1 = new JLabel("" + count);
		label1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 100));	
		panel.add(label1);
		
		increaseButton = new JButton("자동 증가");
		panel.add(increaseButton);
		increaseButton.addActionListener(this);
		//현재 객체
		//현재객체인 EX_02MYCOUNTER 객체를 이벤트 리스너로 등록
		//따라서 버튼이 클릭되었을 때 actionPerformed 메서드가 호출되어
		//현재 객체의 동작을 수행하게 됩니다. 
		
		stopButton = new JButton("멈춤");
		panel.add(stopButton);
		stopButton.addActionListener(this);
		
		add(panel);
		
		setSize(500, 300);
		setTitle("My Counter");
		setVisible(true);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == increaseButton) {//이벤트가 발생한 객체를 반환하는 메서드 
			//자동 증가 시작, e.getSource() 를 사용하면 어떤 버튼이 클릭되었는지를 알 수 있음
			if(timer == null) {
				timer = new Timer(1000, new ActionListener() {	//1초, 익명 클래스 생성 그리고 재정의
					@Override
					public void actionPerformed(ActionEvent e) {
						count++;
						label1.setText("" + count);
					}
				});
			
				timer.start();
			}
		}else if(e.getSource() == stopButton) {
			//자동증가 멈춤
			if(timer != null) {
				timer.stop();
				timer = null;
			}
		}
	}
	public static void main(String[] args) {
		new Ex_02Mycounter();//클래스 객체를 생성 : 생성자 호출 -> 객체가 생성된다. 
	}
}
//class MymouseListener implements MouseListener {
//아래의 5개 메소드를 개발자가 구현해야함
//public void mousePressed(MouseEvent e); //마우스 버튼이 눌러지는 순간 호출
//public void mouseReleased(MouseEvent e); //눌러진 마우스 버튼이 떼어지는 순간 호출
//c.addMouseListener(new MyMouseListener());
//만약 interface MouseListener 을 사용하면, 리스너 작성시 추상 메소드를 모두 구현해야 한다
//즉) mousePressed()만 사용하려고 해도 나머지 4개를 무조건 적어야 하는 부담이 생긴다 
//이럴때 어댑터 클래스를 사용한다. 
//어댑터 클래스란? 리스너의 모든 메소드가 단순 리턴하도록 구현해 놓은 클래스 
//ex) 마우스 리스너를 예를 들었을 때
//class MouseAdapter implements
//			MouseListener, MouseMotionListener, MouseWheeListener {} 이므로
//			활용하지 않는 추상 메서드 구현하지 않아도 된다. 
//리스너 인터페이스에서 대응하는 어댑터 클래스가 전부 있는 건 아니다
//keyListener 은 keyAdapter가 있다. MouseAdapter도 있다. 
//ActionListener는 대응 어댑터가 없다. 
