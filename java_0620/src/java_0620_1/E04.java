package java_0620_1;

import javax.swing.JFrame;



public class E04 extends JFrame {
	public E04() {
		setTitle("지그재그");
		add(new MyPanel());
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new E04();
	}
}
