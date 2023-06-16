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

public class Ex_03SlotMachine extends JFrame implements ActionListener{
	
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;
	private Timer timer;
	private int count = 0;
	
	public Ex_03SlotMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		labels = new JLabel[3];
		numbers = new int[3];
		
		for(int i= 0; i < 3; i++) {
			labels[i] = new JLabel("" + numbers[i]);
			labels[i].setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 100));
			labels[i].setSize(100,100);
			labels[i].setLocation(100 + 100 * i , 20);
			panel.add(labels[i]);	
		}
		button = new JButton("슬롯");
		button.setSize(250,50);
		button.setLocation(100,150);
		button.addActionListener(this);
		panel.add(button);
		
		add(panel);
		setTitle("슬롯 머신");
		setVisible(true);		
		}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(timer == null ) {
			timer = new Timer(100, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i < 3; i++) {
						numbers[i] = (int) (Math.random() * 10);
						labels[i].setText("" + numbers[i]);
					}
					count++;
					if(count >= 10 && numbers[0] == 7 && numbers[1] == 7 && numbers[2] == 7) {
						stopSlotMachine();
						JOptionPane.showMessageDialog(Ex_03SlotMachine.this, "승리!");
					}
				}
			});
			timer.start();
		}
	}
	private void stopSlotMachine() {
		timer.stop();
		timer = null;
		count = 0;		
	}
	public static void main(String[] args) {
		new Ex_03SlotMachine();
	}
}
