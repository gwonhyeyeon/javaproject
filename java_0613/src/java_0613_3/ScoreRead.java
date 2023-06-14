package java_0613_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ScoreRead {

	public static void main(String[] args) {
		int totalScore = 0;
		int count = 0;
		float average = 0.0f;
		File file = new File("scoreData.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			s = in.readLine();
			if(s != null) {
				System.out.println("시험 점수 : " + s);
				StringTokenizer st = new StringTokenizer(s, ", ");
				//주어진 문자열을 구분자(delimiter)를 기준으로 분리하는 역할
				//StringTokenizer의 생성자에 첫 번째 인수로 분리할 문자열을, 두 번째 인수로 구분자를 전달.
			while(st.hasMoreTokens()) {
				totalScore += Integer.parseInt(st.nextToken());
				count++;
			}
			System.out.println("총점 : " + totalScore);
			System.out.println("시험 본 사람 : " + count + " 명");
			
			average = (float) totalScore / count;
			System.out.println("시험 평균 : " + average);
			}
			in.close();
		}catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
