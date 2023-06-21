package java_0621_2;
//단통방 같이 여러 클라이언트가 메시지로 대화하게 하는 스레드 클래스 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class PerClient extends Thread{
/*동기화된 arrayList를 생성하여 PrintWriter만 들어갈 수 있는 List로 업 캐스팅
 * static으로 지정하여 객체 생성이 안되어 perClient객체들의 고유 데이터로 설정하고 
 * 각 클라이언트 별로 생성도니 PrintWriter를 담아서
 * 한명의 클라이언트가 메시지 전송하면 모든 클라이언트한테 전달한다. 
 * 클라이언트들이 메시지를 입력한 순서대로 전달하기 위해 동기화 설정을 한 것이다. 
 * colloections.synchronizedList(List) :
 * 지정된 목록이 지원하는 동기화된(스레드로부터 안전한) 목록을 반환
 * */
	static List<PrintWriter> List = Collections.synchronizedList(new ArrayList<>());
	/** 
	 * Server class에서 사람들이 접속할 때마다 하나씩 Thread class가 추가되게 한다. 
	 * 이 때 미완성 Thread class를 살펴보면
	 * class PerClient extends Thread { static List<PrintWriter>
	 * 								List = Collection.synchronizedList(new ArrayList<>());
	 * 여기서 ArrayList<printWriter>();는 모든 클라이언트에 대한 출력 스트림을 모아놓은
	 * 리스트를 계속 추가하기 위한 List
	 * 
	 */
	 Socket client; PrintWriter pw;
	 //생성자로 전달받은 클라이언트와 연결된 소켓을 멤버로 초기화하고,
	 //해당 클라이언트와 연결된 출력 스트림을 생성하여 공유 list에 저장
	 public PerClient(Socket client) throws IOException {
		 this.client = client;
		 pw = new PrintWriter(client.getOutputStream());
		 List.add(pw);
	 }
	 //스레드 동작
	 public void run() {
		 String name = "";
		 try {
			//연결 클라이언트에 대한 문자 입력 스트림 버퍼 생성
			 BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			 //처음으로 전달 받은 클라이언트 닉네임을 저장
			 name = br.readLine();
			// sendAll() 메소드로 연결 된 모든 클라이언트에게 입장 메시지 전달
			 sendAll("#" + name + "님이 입장하셨습니다. ");
			 while(true) {
				 //클라이언트의 메시지를 한줄 받아서 저장한다
				 String msg = br.readLine();
				 //받은 메시지가 null이면 종료
				 if(msg == null)
					 break;
				 //sendall메소드로 클라이언트가 전송한 메시지를 다른 클라이언트에게 전달
				 sendAll(name + ">" + msg);
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			//해당 클라이언트가 채팅방을 나가면(소켓 연결을 끊으면)
			//공유 리스트의 PrintWriter 객체를 삭제 후 퇴장 메시지를 전체 전달
			List.remove(pw);
			sendAll("#" + name + "님이 퇴장하셨습니다. ");
			try {
				client.close();
			} catch (Exception e2) {
				
			}
		}
		 //연결 된 모든 클라이언트에게 메시지 전달 메소드
	 }
	 void sendAll(String msg) {
		 //공유 리스트에 저장된 모든 PrintWriter 객체를 하나씩 가져와서
		 for(PrintWriter p : List) {
			 p.println(msg); p.flush();
		 }
	 }
}
