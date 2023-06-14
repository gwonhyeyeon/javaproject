package java_0613_2;
//ex_04
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//system.out.출력하기 
//-> BufferedReader ...readLine() -> System.out 출력하기 

public class StrandardTest {

	public static void main(String[] args) throws FileNotFoundException {
		String mesg = null;
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		System.out.println("exit : Ctrl+Z");
		try {
			mesg = in.readLine();
			while(mesg != null) {
				System.out.println("읽기 : "+ mesg);
				mesg = in.readLine();
			} 
			in.close();
			ir.close();
		}catch (IOException e) {
			e.printStackTrace();
		}	
	
	}//File file = new File("파일명")
	//File file = new File("파일 경로 ", "파일명");
	//키보드로 입력 System.in -> InputStreamReader(문자)
	//-> BufferedReader..readLine()  -> System.out 출력하기
	
	//파일에 데이터 쓰기 과정
	//키보드 입력 PrintWriter[println()] FileWriter --> write.txt
	//파일에 데이터 읽기 과정
	//write.txt --> FileReader BufferedReader[readLine()] -->모니터 출력
}
