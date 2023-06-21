package java_0621;
//07

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;




public class TranslationServer {

	public static void main(String[] args) throws Exception {
		System.out.println("영어 번역 서버가 실행중입니다.");
		int clientId = 0;
		ServerSocket ss = new ServerSocket(9101);
		//serversocket 객체 생성 후 port값 전달
		try {
			while(true) {
				clientId++;
				Translator t = new Translator(ss.accept(), clientId);
				//Translator객체 생성 후 ss객체로부터 접속을 기다림, clientId를 추가함
				t.start();//스레드의 run()메소드를 실행함
			}
		} finally {
			ss.close();
		}
	}
	private static class Translator extends Thread {
		//스레드의 상속을 받는 Translator 클래스 선언
		private Socket socket;
		private int myId;
		public Translator(Socket socket, int clientId) {
			//매개변수 있는 생성자 생성
			this.socket = socket;
			this.myId = clientId;
		}
		public void run() {//스레드에서 실행할 부분을 구현하는 run()메소드
			 try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//bufferedReader객체 생성 후 소켓의 입력을 가져오고 inputstreamreader를 추가함
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				//printwirter객체 생성 후 소켓의 출력을 추가하고
				// autoflush를 true로 설정해 모든 값을 내보내게 함
				//java.io.PrintWriter;
				// PrintWriter는 Writer를 상속받아 사용해 Writer 대비 다양한 출력방식을 제공함
				//PrintWriter를 사용하는 가장 큰 이유 중 하나는 메서드(print/println/printf)
				//기존 소켓의 출력스트림에 새 printWriter를 만든다. autoflush가 true
				out.println("안녕하세요? 클라이언트 번호는"+ myId + "입니다.");
				//println()메소드 사용해 출력구문 출력
				out.println("단어를 입력하세요");
				while(true) {
					String input = in.readLine();
					//input변수에 BufferedReader로 읽어온 소켓의 입력값을 대입함
					if(input == null) {
						//만약에 input이 아무것도 없다면 즉 BufferedReader로 읽어온 소켓의 입력값이 없다면
						 break;//while문 종료
					}
					if(input.equals("java") == true)
						//만약 BufferedReader로 읽어온 소켓의 입력값이 java와 같은게 사실이라면
						out.println("java -> 자바");
					else 
						out.println("조금 쉬운 단어를 보내주세요.");
				}
			} catch (IOException e) {
				System.out.println("클라이언트 번호 : "+ myId + "처리 실패" + e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("소켓 종료 오류 "+ e);
				}
				System.out.println("클라이언트 번호 : " + myId + "처리 종료");
			}
		}
	}
	

}
