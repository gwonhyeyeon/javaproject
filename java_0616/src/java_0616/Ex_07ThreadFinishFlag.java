package java_0616;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Ex_07ThreadFinishFlag extends JFrame {
	
	private Ex_07RandomThread th;
	
	public Ex_07ThreadFinishFlag() {
		setTitle("Ex_07ThreadFinishFlag");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		setSize(300, 200);
		setVisible(true);
		th = new Ex_07RandomThread(c);
		th.start();
	}

	public static void main(String[] args) {
		new Ex_07ThreadFinishFlag();
	}

}
