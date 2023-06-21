package java_0621;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TranslationClient extends JFrame implements ActionListener{
	
	private BufferedReader in;
	private PrintWriter out;
	private JTextField field;
	private JTextArea area;
	public TranslationClient() throws Exception, IOException {
		setTitle("클라이언트");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		field = new JTextField(50); //filed객체에 50 크기를 지정함
		field.addActionListener(this); //field 객체에 acitonListener를 추가함
		
		area = new JTextArea(10, 50);
		area.setEditable(false);
		add(field, BorderLayout.NORTH);
		//글을 쓰는 jtextField객체의 레이아웃을 BorderLayout 으로 선언하고 북쪽에 위치하게 함
		add(area, BorderLayout.CENTER);
		//텍스트가 보여지는 jtextArea객체의 레이아웃을 BorderLayout 으로 선언하고 중앙에 위치
		//127.0.0.1(로컬 호스트를 뜻함)
		Socket socket = new Socket("localhost", 9101);
		//localhost의 ip주소로 9100 포트를 객체에 추가함
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		area.append(in.readLine() + "\n");
		//jtextArea 객체에 읽어들인 문자열을 끝에 추가함
		area.append(in.readLine() + "\n");
		//appned() : 읽어들인 문자열을 JTextArea 끝에 추가한다. 			
	}
	public void actionPerformed(ActionEvent arg0) {//액션이 발생하면 실행됨
		out.println(field.getText());
		//PrintWriter객체에 JTextField객체에서 가져온 text를 추가함
		String response = null; //response변수 선언 후 초기화
		try {
			response = in.readLine();
			//response변수에 BufferedReader로 읽어온 문자열 라인의 값을 추가함
		} catch (IOException e) {
			e.printStackTrace();
		}
		area.append(response + "\n");
		//jtextArea객체의 맨 끝에 response변수에 지정된 문자열 라인을 추가함
	}

	public static void main(String[] args) throws Exception{
		TranslationClient client = new TranslationClient();
	}

}
