package java_0621;
//06
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("서버 IP");
		String ip = sc.nextLine();
		System.out.println("보낼 메세지");
		String msg = sc.nextLine();
		Socket sk = new Socket(ip, 5005);
		//socket(String host, int port) 의 형태로 객체 생성
		//사용자가 입력한 서버가 ip주소가 인자값이 되어 매개변수  ip에 전달됨
		BufferedWriter bw = 
				new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
		bw.write(msg);
		bw.flush();
		bw.close();
		sk.close();
		
		sc.close();
		System.out.println("보내기 성공");
	}

}
