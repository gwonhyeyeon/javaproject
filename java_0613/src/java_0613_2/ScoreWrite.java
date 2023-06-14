package java_0613_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//열명의 시험 접수를 입력 받아서 파일에 저장하는 예제
public class ScoreWrite {

	public static void main(String[] args) {
		int count = 1;// 몇 번 입력 했는지를 카운트 하는 변수
		String scoreData = "";
		String s = null;
		File file = new File("scoreData.txt");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(new FileWriter(file, false));
			do {
				System.out.println(count + " 번째 점수를 입력하세요.");
				s = in.readLine();
				if(isRealNumber(s)) {
					if(count != 10){
						scoreData += s + ",";//입력한 값이 숫자인지를 체크한다.
					}else {
						scoreData += s;
					}
					count++;	
				}else {
					System.out.println("숫자만 입력 가능합니다.");
				}	
			}while(count <= 10);
			
			out.println(scoreData);
			in.close();
			out.close();
			
		}catch (IOException e) {
			System.out.println("IOException");
		}
		System.out.println("시험점수를 파일로 출력합니다.");
	}

	private static boolean isRealNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
