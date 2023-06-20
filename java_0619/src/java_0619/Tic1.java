package java_0619;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Tic1 extends JFrame{
	
	private static final long serialVersionUID = 1L; //객체 직렬화
	JLabel title = new JLabel("Tic1 | "); //라벨 인스턴스 생성
	JLabel dispCurrentPlayer = new JLabel("Player 0");
	//현재 플레이어 표시해주는 라벨 인스턴스
	private int score1 = 0;
	private int score2 = 0; //각 플레이어 스코어를 표시해줄 score변수
	JLabel scoreLabel = new JLabel(" | " + score1 + " : " + score2);
	JButton startNewGame = new JButton("새 게임 시작");
	//게임 다시 시작하게 해줄 버튼 인스턴스 생성
	JPanel titleBar = new JPanel(); //각종 JLABEL 이 들어갈 JPanel 인스턴스 생성
	JPanel nineRoom = new JPanel(); //버튼이 들어갈 때 패널 인스턴스 생성
	private final int START_PLAYER = 1;
	private boolean isGameEnd = false;
	//게임 종료 시킬 때 사용할 boolean 타입 변수
	TicTacToeCore ttt = new TicTacToeCore(START_PLAYER);
	
	//tictactoeCore 레퍼런스 타입의 ttt인스턴스 생성, 매개변수 startplayer 
	public Tic1() {
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.drawWindow();
		this.setVisible(true);
	}
	public void drawWindow() {
		titleBar.add(title); titleBar.add(dispCurrentPlayer);
		titleBar.add(scoreLabel); titleBar.add(startNewGame);
		
		dispCurrentPlayer.setText("Player "+ START_PLAYER);
		//해당 인스턴스에 텍스트 세팅
		add(titleBar, BorderLayout.NORTH);
		nineRoom.setLayout(new GridLayout(3,3));
		for(int i = 0; i< 9; i++) {
			JButton tempButton = new JButton("");
			tempButton.setFont(new Font("Impact", Font.PLAIN, 22));
			nineRoom.add(tempButton);
		}
		add(nineRoom, BorderLayout.CENTER);
		MouseListener m1 = new MouseAdapter() {
			//마우스 어댑터의 무명객체 m1에 대입
			public void mousePressed(MouseEvent e) {
				JButton tempButton = (JButton)e.getComponent();
				
				//이벤트의 컴포넌트 tempButton으로 다운 캐스팅
				if(isGameEnd) {return;} //isGameEnd가 true면 이벤트 종료
				if(tempButton.getText().equals("O") || tempButton.getText().equals("X")) {
					JOptionPane.showMessageDialog(nineRoom, "이미 둔 곳입니다.");
					return;
				} else if(ttt.getCurrentPlayerNum() == 1) {
					tempButton.setText("O");
					dispCurrentPlayer.setText("Player" + 2);
				}else {
					tempButton.setText("X"); //해당 버튼에 x 문자열 텍스트 세팅
					dispCurrentPlayer.setText("Player "+ 1);
					//해당 패널에 player1 문자열 세팅
				} ttt.changeTurn();//해당 메소드 실행
				System.out.println("(" + e.getX() + ", "+ e.getY() + ")");
				//해당 이벤트가 발생한 좌표 출력
				int[][] ticArr = new int[3][3];
				for(int i=0; i < ticArr.length; i++) {
					for( int j=0; j < ticArr[0].length; j++) {
						//ticArr 3번 반복
						String pl = ((JButton)nineRoom.getComponent(j + i * 3)).getText();
						//nimeRomme에 j + (i*3)번째로 들어간 컴포넌트의 문자열 값을 pl에 대입 0~8
						if(pl.equals("O")) {
							ticArr[i][j] = 1;
						}
						else if(pl.equals("X")) {
							ticArr[i][j] = 2;
						}
						//pl의 문자열 값이x일때 ticarr[i][j] =2;
						else {
							ticArr[i][j] = 0; //둘다 아니면 0
						}
					}
				}
				int result = ttt.inputCurrentStage(ticArr);
				System.out.println("result : " + result);
				//해당 메소드의 인자로ticarr 배열을 사용하여 result값 반환하고 출력함
				if(result == 1 || result == 2) {
					//result가 1이나 2면 nineRoom패널에 해당 메시지 다이얼로그출력
					JOptionPane.showMessageDialog(nineRoom, "플레이어" + result + "의 승리입니다.");
					if(result == 1) {score1++;}
					else {score2++;}
					scoreLabel.setText(" | " + score1 + " : " + score2);
					//스코어라벨 텍스트를 다시 세팅함
					isGameEnd = true;
				}else if(result == 99) {
					JOptionPane.showMessageDialog(nineRoom, "비겼습니다.");
					isGameEnd = true;} } };
					//nineRoome패널에 해당 메시지 다이얼로그 출력 후 변수 true로 변경
					for(Component c : nineRoom.getComponents()) {
						c.addMouseListener(m1);
							}//해당컴포넌트를 마우스 리스너 m1에 연결
					startNewGame.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							ttt.resetGame(START_PLAYER);	
							isGameEnd = false;
							for(int i=0; i < nineRoom.getComponents().length; i++) {
								((JButton)nineRoom.getComponent(i)).setText("");
								//버튼 내용을 초기화 
							}		
						}
					});
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Thread()
		//여러 이벤트가 동시에 충돌하는 것을 막기 위한 invokeLater메소드
				{
			public void run() {
				new Tic1();
			}
				});
	}
}
