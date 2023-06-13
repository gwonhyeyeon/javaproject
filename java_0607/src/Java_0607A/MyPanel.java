package Java_0607A;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener {
    JButton[][] buttons = new JButton[3][3];
    //가로3 세로3의 버튼을 만든다
    private char turn = 'X';


    public MyPanel() {
        setLayout(new GridLayout(3, 3, 5, 5));
        //row:3, cols:3, hgap:5 -> 각 컴포넌트 사이에 간격(좌우) vgap : 5 컴포넌트 사이에 간격(위아래)
        Font f = new Font("Dialog", Font.ITALIC, 50);
        //폰트는 dialog, 이탤릭체로 표시, size는 50

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(f);
                buttons[i][j].addActionListener(this);//버튼을 이벤트 처리기로 등록
                add(buttons[i][j]);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == buttons[i][j] && buttons[i][j].getText().equals(" ")) {
                    buttons[i][j].setText(String.valueOf(turn));//일어난 이벤트 속성 값을 불러와서 비어있는 버튼의 텍스트를  
                    //turn 변수의 value값으로 나타나게 한다.  
                    if (checkWin(String.valueOf(turn), i, j)) { //마지막에 누른 버튼과 i, j 3개의 버튼이 같으면 
                        System.out.println(turn + "가 이겼음!");
                        // Game over, disable all buttons
                        for (int x = 0; x < 3; x++)
                            for (int y = 0; y < 3; y++)
                                buttons[x][y].setEnabled(false);//누군가 한쪽이 이기게 되면 버튼 비활성화 시키기
                        return;
                    }
                    // Switch turns turn의 value값은 이전에 x 였으면 o o였으면 x로 바뀌도록 삼항연산자 활용하여 턴 
                    turn = (turn == 'X') ? 'O' : 'X';
                }
            }
        }
        // After each move, check if the game is a draw
        if (isDraw()) {
            System.out.println("비겼습니다.");
            // Game over, disable all buttons
            for (int x = 0; x < 3; x++)
                for (int y = 0; y < 3; y++)
                    buttons[x][y].setEnabled(false);
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if (buttons[row][col].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(String mark, int r, int c) {
        return (buttons[r][0].getText().equals(mark) && buttons[r][1].getText().equals(mark) && buttons[r][2].getText().equals(mark)
        		//같은 열에서 (r) 모든 행 1, 2, 3 행에 text가 일치하거나
                || buttons[0][c].getText().equals(mark) && buttons[1][c].getText().equals(mark) && buttons[2][c].getText().equals(mark)
                //같은 행에서 (c) 모든 열 1, 2, 3 열에 모든 text가 일치하거나
                || (r == c && buttons[0][0].getText().equals(mark) && buttons[1][1].getText().equals(mark) && buttons[2][2].getText().equals(mark))
                //열과 행이 같고, 1열1행, 2열2행, 3열3행의 text가 일치하는 경우이거나 (대각선) 
                || (r + c == 2 && buttons[0][2].getText().equals(mark) && buttons[1][1].getText().equals(mark) && buttons[2][0].getText().equals(mark)));
        		//[0,2]에서 시작되는 반대 대각선의 text가 일치하거나 하는 경우에 이긴 것으로 간주 
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.setSize(300, 300);
        f.setVisible(true);
    }
}
//1.비긴 상태 확인 로직 변경: 각 턴에서 '승리' 조건을 먼저 확인하고, 
// 승리하지 않은 경우에만 isDraw()를 호출합니다.
//2.게임 종료 처리: 승리나 무승부 상황이 확인되면 모든 버튼을 비활성화
//3.턴 교체 로직 변경: 기존 코드에서는 버튼을 클릭할 때마다 턴이 바뀌었습니다
//4.승리 조건 체크 로직 개선: 기존 코드에서는 대각선의 승리 조건이 모든 대각선에 대해 동일하게 적용되었음
//  대각선의 승리 조건을 보드의 위치에 따라 동적으로 확인