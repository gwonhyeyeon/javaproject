package java_0621;
//09
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//객체 스트림을 이용한 지속되는채팅 프로그램 클라이언트 단
public class E02SimpleClient {

	public static void main(String[] args) throws IOException {
		//args 문자열이 비어있으면
		if(args.length == 0) {
			System.out.println("사용법 java SimpleClient [Server_name]");
			System.out.println("server_name을 입력하지 않으셔서 localhost로 접속을 시도합니다. ");
			//문자열 배열 객체 생성 및 0번 인덱스에 내 ip주소 저장
			args = new String[] {"localhost"};
		}
		try {
	//내 IP와 포트 5434로 소켓 생성하며 연결
			Socket s1 = new Socket(args[0], 5434);
			//직접 입력한 문자에 대한 문자 스트림 생성
			BufferedReader in = 
					new BufferedReader(new InputStreamReader(System.in));
			//연결된 소켓으로 객체의 원시 데이터 유형과 그래프들을 주고받는 입출력 스트림 생성
			ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
			System.out.println("접속완료..");
			//서버가 보낸 객체를 읽어 문자열로 변환하여 출력
			System.out.println((String)ois.readObject());
			System.out.println("서버에게 먼저 메시지를 보내십시오!!");
			while(true) {
				System.out.println("<Client> : ");
				//문자 스트림으로 문자열 입력
				String temp = in.readLine();
				//입력한 문자열이 "exit"이면 채팅 종료
				if(temp.equals("exit")) {
					System.out.println("bye~");
					break;
				}
				//입력한 문자열을 출력 스트림으로 서버에게 전송
				oos.writeObject("<Client> : " + temp);
				//서버가 보낸 객체를 읽어 문자열로 변환하여 출력
				System.out.println((String)ois.readObject());
			}
			ois.close();
			s1.close();
		} catch (EOFException eof) {
		     System.out.println("Client로부터 연결이 끊어졌습니다. 종료합니다....");
		} catch (ClassNotFoundException e) {
			  System.out.println("Client로부터 연결이 끊어졌습니다. 종료합니다....");
			  System.exit(0);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
