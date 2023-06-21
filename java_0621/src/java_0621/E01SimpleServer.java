package java_0621;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//08
public class E01SimpleServer {

	public static void main(String[] args) {
		InputStream is;
		PrintWriter pw = null;
		ServerSocket serverSocket;
		Socket s1 = null;
		String data;
		BufferedReader br_in;
		try {
//플랫폼의 기본 문자 집합을 사용하여 이름이 지정된 FileWriter를 구성합니다. 
			//out.txt라는 파일에 데이터를 입력하는 라이터(파일 없으면 만듦)
			 FileWriter writer = new FileWriter("out.txt");
			 //포트 5435서버 소켓 생성
			 serverSocket = new ServerSocket(5435);
			 System.out.println("서버 실행 중");
			 //클라이언트의 연결 요청 시 연결된 소켓 획득
			 s1 = serverSocket.accept();
			 //소켓에 대한 입력 스트림 획득
			 is = s1.getInputStream();
			 //획득한 입력 스트림에 문자 읽을 시 성능향상을 위해 리더와 버퍼 연결
			 br_in = new BufferedReader(new InputStreamReader(is));
			 //writer 파일에 문자를 입력하기 위한 프린트 라이터 생성
			 pw = new PrintWriter(writer, true);
			 //서버에서 보낸 데이터를 한 줄씩 읽어 data에 저장
			 //받은 데이터가 없으면 반복 종료
			 while((data = br_in.readLine()) != null) {
				 //받은 데이터를 "out.txt"파일에 입력
				 pw.println(data);
			 }
			 //스트림과 소켓 닫기 
			 pw.close();
			 s1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
