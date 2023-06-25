package java_0623;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.util.List; //임포트 에러가 났다. 
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//뷰 : 데이터 및 객체의 입력, 그리고 보여주는 출력을 나타낸다. 
//데이터를 기반으로 사용자들이 볼 수 있는 화면이다.
//1. 화면에서 발생한 이벤트와 입력 데이터들을 컨트롤러에 전달한다.
//사용자에게 보여지는 화면을 만드는 부분이라 생각하자

public class MovieWindow extends JFrame implements ActionListener {

	// ↓ 화면에 출력되는 결과 메시지
	String resultMsg = null;
	// ↓ 사용자의 입력을 받는 텍스트 필드 30글자까지
	JTextField tMovieTitle = new JTextField(30);
	// ↓ 작성한 결과를 저장하기 위해 눌러야 하는 버튼
	JButton btnTitleInsert = new JButton("영화제목 추가");
	// ↓ 누르면 파일에 값이 저장되는 버튼
	JButton btnSave = new JButton("영화제목 파일 저장");
	// ↓ List 컨트롤은 여러 데이터를 관리할 때 쓰인다.
	// List 컴퍼넌트는, 텍스트 항목의 스크롤 리스트를 사용자에 대해서 표시한다.
	// 즉 저장한 데이터들을 순서대로 관리하는 것.
	List movieList = new List();
	// 컨트롤러 객체를 생성한다.
	MovieController controller = new MovieController();
	// ↓ 누르면 JFrame이 버튼생성
	JButton btnExit = new JButton("종료");

	// JFrame 생성자
	public MovieWindow() {
		setTitle("영화정보 관리 화면");
		// super("영화정보 관리 화면");

		// JTextArea 같은 역할
		// 배경색을 핑크로 한다.
		movieList.setBackground(Color.pink);

		// 파넬 객체 생성
		Panel p = new Panel();
		p.add(new Label("영화제목 입력"));
		p.add(tMovieTitle);
		p.add(btnTitleInsert);
		p.add(btnSave);

		// 위에 p에 추가한 객체들은 상단에
		add(BorderLayout.NORTH, p);
		// 영화제목 입력 받은 내용은 중간에
		add(BorderLayout.CENTER, movieList);
		// 종료 버튼은 맨 아래에
		add(BorderLayout.SOUTH, btnExit);
		// setBounds : 절대 위치와 크기를 조절한다.
		setBounds(0, 0, 800, 600);
		setVisible(true);
		// Listener와 연결한다.
		movieList.addActionListener(this);
		btnTitleInsert.addActionListener(this);
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String mTitle = e.getActionCommand();
		// 만약에 영화제목 추가 버튼을 누르면
		if (e.getSource() == btnTitleInsert) {
			// System.out.println("영화제목 추가하기");
			// 텍스트필드에 입력한 영화제목을 가지고 온다.
			mTitle = tMovieTitle.getText().trim();
			// ↓ 리스트에 영화제목을 추가하는 메소드
			controller.addTitle(mTitle, movieList);
			// 버튼을 클릭하면 텍스트 입력창에 글자 없어지기
			tMovieTitle.setText("");
			// 팝업창에 뜨는 문구
			resultMsg = "영화 제목을 추가했습니다.";

		} else if (e.getSource() == btnSave) {
//System.out.println("파일 저장");
//↓ 리스트에 있는 영화제목들을 파일에 저장하는 메소드 
			controller.saveTitles(movieList);
//팝업창에 뜨는 문구
			resultMsg = "영화제목을 파일에 저장했습니다.";

		} // 종료 버튼 클릭시 JFrame 화면이 종료된다.
		else if (e.getSource() == btnExit) {
			System.exit(0);

		} else {
//↓ 리스트 제목을 더블 클릭시 제목을 지운다.
			controller.delTitle(mTitle, movieList);
			resultMsg = "영화제목을 삭제했습니다.";
		}
		// 다이얼로그 처리 결과를 보여준다.
		// JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
		JOptionPane.showMessageDialog(this, resultMsg, "메시지 박스", JOptionPane.INFORMATION_MESSAGE);
		if (e.getSource() == btnExit)
			System.exit(1);
	}
	public static void main(String[] args) {
		new MovieWindow();
	}
}
