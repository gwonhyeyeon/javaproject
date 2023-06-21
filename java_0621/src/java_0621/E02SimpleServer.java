package java_0621;
//09
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class E02SimpleServer {

	public static void main(String[] args) {
		try {
			System.out.println("서비스 하기 위해 준비중입니다. ");
			//프롬프트 5434의 서버소켓 생성
			ServerSocket s = new ServerSocket(5434);
			System.out.println("서버가 동작중입니다.");
			//클라이언트 연결 요청 시 연결된 소켓 획득
			Socket s1 = s.accept();
			//직접 입력한 문자에 대한 문자 스트림 생성
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			//연결된 소켓으로 객체의 원시 데이터 유형과 그래프를 주고받는 입출력 스트림 생성
			ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
			//출력 스트림에 문자열 객체를 입력하여 클라이언트에게 전송
			oos.writeObject("Simple Server에 접속하신 것을 환영합니다.");
			while(true) {
				//클라이언트가 보낸 객체를 읽어 문자열로 반환하여 출력
				System.out.println((String)ois.readObject());
				System.out.println("<Server> : ");
				//클라이언트에게 보낼 문자열 입력
				String temp = in.readLine();
				//입력 문자열이 exit이면 연결 종료
				if(temp.equals("exit")) {
					System.out.println("bye");
					break;
				}
				//입ㄹ겨한 문자열을 클라이언트에게 전송
				oos.writeObject("<Server> : " + temp);
			}
			oos.close();   s1.close();   s.close();
			//EOFException 예외
			//ObjectOutputStream/ObjectInputStream 클래스를 사용하여 객체를 직렬화,
			//역직렬화하는 과정에서 readObject 메소드에 의해 발생
			//이런 문제의 원인 readObject 메소드가 읽을 데이터가 없는 경우 null을 반환하지 않고, 
			//EOFException 예외를 반환하기 떄문에 아래와 같이 예외처리를 하든가
			//아니면 readObject() 로 읽을 데이터의 마지막에 null을 넣고
			//readObject()로 null을 읽을 시 읽기를 종료하는 로직을 짜야한다. 
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
