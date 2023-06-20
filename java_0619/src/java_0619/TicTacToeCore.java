package java_0619;

public class TicTacToeCore {
	
	private int currentPlayerNum; //현재 플레이어를 표기하는 int형 변수
	private boolean isGameOver = false;
	private int[][] endStage;
	private int currentTurn = 1; //현재 턴에 해당하는 변수
	
	public TicTacToeCore(int currentPlayerNum) {
		this.currentPlayerNum = currentPlayerNum;
	}
	//생성자, 해당 코드에서는 start_player의 값을 매개변수로 받았음
	
	public void changeTurn() {
		currentPlayerNum = (currentPlayerNum == 1) ? 2 : 1;		
	}
	//currentPlayerNum이1 이면 2로 2면 1로 변경시켜주는 메서드
	public int getCurrentPlayerNum() {
		return currentPlayerNum;
	}
	public void setCurrentPlayerNum(int currentPlayerNum) {
		this.currentPlayerNum = currentPlayerNum;
	}
	public int[][] getEndStage() {
		return endStage;
	}//endStage의 getter

//@param currentStage //return값에 따른 실행 루틴을 주석처리해서 알려줌
//@return -99 : 게임종료됨, 1: 플레이어 1 승리, 2: 플레이어 2 승리, 0: 진행중
//99: 비김(draw)

	private boolean isThisPlayerWin(int playerNum, String rowFrag, 
			String colFrag, String diaFrag1, String diaFrag2) {
		String p = String.valueOf(playerNum);
		//playerNum의 값을 문자열 p에 저장
		boolean result = false; //Boolean 타입 변수 선언 및 false로 초기화
		String[] arr = {rowFrag, colFrag, diaFrag1, diaFrag2};
		//인자 값들을 arr배열에 대입
		for(int i = 0; i< arr.length; i++) {//배열의 길이만큼 반복
			result = !arr[i].contains("0") && arr[i].equals(p + p + p);
			if(result)
				return result;		
		}
		return result;
	}
	public int inputCurrentStage(int[][] currentStage) {
		//해당 코드에선 원소가 0,1,2 로 이루어진 ticArr을 인자로 받음
		if(isGameOver) {return -99;}//게임이 끝났다면 더이상 진행하는 의미가 없으므로
		for(int i = 0; i< currentStage.length; i++) {
			//매개 변수로 쓰인 2차원 배열 currentStage의 row 길이만큼 반복
			String rowStr = ""; String colStr = "";
			String diaStr1 = ""; String diaStr2 = "";
			// 각종 String 변수 초기화
			for(int j = 0; j < currentStage[i].length; j++) {
				//currentStage의 column길이만큼 반복
				rowStr += (currentStage[i][j] + "");
				colStr += (currentStage[j][i] + "");
			}
			for(int j = 0; j < currentStage.length; j++) {
				//currentStage의 row길이만큼 반복
				diaStr1 += currentStage[j][j];
				diaStr2 += currentStage[j][2 - j];
			}
			if(isThisPlayerWin(2, rowStr, colStr, diaStr1, diaStr2)) {
				// 해당 매개변수로 메소드 호출하여 받은 return 값이 true면 if문 실행
				isGameOver = true;
				endStage = currentStage;//게임오버를 true, endStage를 현재 스테이지로 할당
				return 2;
			}
			else if(isThisPlayerWin(1, rowStr, colStr, diaStr1, diaStr2)) {
				isGameOver = true;
				endStage = currentStage;
				return 1;
			}else if( currentTurn == 9) { return 99;}
			else {continue;}
			
			}
		currentTurn++;
		return 0;
		}
	public void resetGame(int currentPlayerNum) {// 초기 상태로 되돌리는 메소드 
		this.isGameOver = false;
		this.currentPlayerNum = currentPlayerNum;
		this.endStage = null;
		this.currentTurn = 1;
	}
}