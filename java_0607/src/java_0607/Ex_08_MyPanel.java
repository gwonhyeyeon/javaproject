package java_0607;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex_08_MyPanel extends JPanel implements ActionListener {
	JButton[][] buttons = new JButton[3][3];
	private char turn = 'X';
	
	public Ex_08_MyPanel() {
		setLayout(new GridLayout(3, 3, 5, 5));
		Font f = new Font("Dialog", Font.ITALIC, 50);
		
		for(int i = 0; i< 3; i++) {
			
			for(int j=0; j < 3; j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setFont(f);
				buttons[i][j].addActionListener(this);
				add(buttons[i][j]);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i< 3; i++) {
			for(int j=0; j < 3; j++) {
				if(e.getSource() == buttons[i][j] && 
						buttons[i][j].getText().equals(" ") == true) {
					if(turn == 'X') {
						buttons[i][j].setText("X");
						turn = 'O';
						if(checkWin("X", i, j))
							System.out.println("X가 이겼음!");
						else if(isDraw())
							System.out.println("비겼습니다. ");
					} else {
						buttons[i][j].setText("O");
						turn = 'X';
						if(checkWin("O", i, j))
							System.out.println("O가 이겼음!");
						else if(isDraw())
							System.out.println("비겼습니다.");
					}
				}
			}
		}
	}
	public boolean isDraw() {
		for(int row =0; row < 3; ++row) {
			for( int col = 0; col < 3; ++col) {
				if(buttons[row][col].getText().equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean checkWin (String mark, int r, int c) {
		return(	   buttons[r][0].getText().equals(mark) 
				&& buttons[r][2].getText().equals(mark)
				&& buttons[r][3].getText().equals(mark)
				|| buttons[0][3].getText().equals(mark)
				&& buttons[1][c].getText().equals(mark)
				&& buttons[2][c].getText().equals(mark)
				|| buttons[0][0].getText().equals(mark)
				&& buttons[1][1].getText().equals(mark)
				&& buttons[2][2].getText().equals(mark)
				|| buttons[0][2].getText().equals(mark)
				&& buttons[1][1].getText().equals(mark)
				&& buttons[2][0].getText().equals(mark));
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Ex_08_MyPanel());
		f.setSize(300, 300);
		f.setVisible(true);
	}
}

//1. 비긴 상태 확인 로직 변경 : 각 턴에서 '승리'조건을 먼저 확인하고,
//승리하지 않은 경우에만 isDraw()를 호출합니다. 
//2. 게임종료 처리 : 승리나 무승부 상황이 확인되면 모든 버튼을 비활성화
//3. 턴 교체 로직 변경 : 기존 코드에서는 버튼을 클릭할 때마다 턴이 바뀌었습니다.
//4. 승리 조건 체크 로직 개선 : 기존 코드에서는 대각선의 승리 조건이 모든 대각선에 대해 동일하지 
