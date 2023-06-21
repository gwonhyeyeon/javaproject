package java_0621;
//06
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5006);
			System.out.println("서버 가동중");
			while(true) {
				Socket client = ss.accept();//클라이언트로부터 접속을 기다림
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				//reader 한글로 보낼 때
				System.out.println(client.getInetAddress() + " > " + br.readLine());
				//getInetAddress : 웹 주소의 ip주소를 읽는 메소드
				br.close();
				client.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
