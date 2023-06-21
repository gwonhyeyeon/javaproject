package java_0621_2;
//11
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ReceiveThread_PerClient extends Thread {
	Socket socket;
	//생성자로 소켓 받아서 멤버 초기화
	public ReceiveThread_PerClient(Socket socket) {
		this.socket = socket;
	}
	//스레드 동작
	public void run() {
		try {
//받은 소켓으로 입력 스트림 얻어서 문자 입력 스트림 버퍼 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				//스트림으로 전달 받은 메시지 한 줄 저장
				String str = br.readLine();
				//받은 메시지가  null이면 종료
				if(str == null)
					break;
				//전달받은 메시지를 내 화면에 출력
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
