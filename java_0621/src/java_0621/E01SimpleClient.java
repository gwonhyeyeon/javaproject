package java_0621;
//08
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class E01SimpleClient {

	public static void main(String[] args) {
		OutputStream os;
		BufferedReader br_out;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
	//파일에서 읽어온 데이터를 저장할 변수
			String data = null;
			//내 ip에 포트 5435인 소켓을 생성하며 연결
			Socket s1 = new Socket("localhost", 5435);
			//소켓에 대한 출력 스트림 획득
			os = s1.getOutputStream();
			//플랫폼의 기본 문자 집합을 사용하여 읽을 파일의 이름이 지정된 새 FileReader를 만듭니다
			//write.txt라는 파일에 연결해 데이터를 읽어올 리더 생상
			br_out = new BufferedReader(new FileReader("write.txt"));
			//획득한 출력 스트림에 문자 입력 시 성능 향상을 위해 라이터와 버퍼 연결
			bw = new BufferedWriter(new OutputStreamWriter(os));
			//버퍼에 담긴 문자를 쓰기 위해 프린터라이터 연결
			pw = new PrintWriter(bw, true);
			//write.txt 에서 문자열을 한 줄씩 읽어와 data에 저장
			//읽어올 데이터가 없으면 반복 종료
			while((data = br_out.readLine()) != null) {
				//출력 스트림으로 data에 담긴 문자열을 서버로 전송
				pw.println(data);
			}
			System.out.println("파일을 전송했습니다.");
			//스트림과 소켓을 닫는다.
			pw.close(); s1.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
