package java_0622;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




//여러 클라이언트들의 채팅 중개 서버
public class ChattingServer extends JFrame{
//각 클라이언트들의 접속 스레드를 담는 리스트
	
		private ArrayList<MultiServerThread> list;
		private Socket socket;
		private JTextArea ta;
		private JTextField tf;
		private ServerSocket serverSocket = null;
		
		//생성자
		public ChattingServer() {
			setTitle("다중 채팅 서버");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ta = new JTextArea();
			ta.setEditable(false);
			//텍스트 영역을 스크롤 팬에 담아 이전 텍스트 내역 확인할 수 있게 하고
			//슼트롤 팬에 프레임에 삽
			add(new JScrollPane(ta));
			//jscrollpane (스크롤 창의 뷰포트에 표시할 구성 요소 보기) :
			//구성 요소의 내용이 보기보다 클 때마다 가로 및 세로 스크롤 막대가 모두 나타나는
			//지정된 구성 요소의 내용을 표시하는 JScrollpane을 만든다
			
			//한줄 텍스트 영역 생성 후 입력 불가로 설정
			tf= new JTextField();
			tf.setEditable(false);
			//한줄 텍스트 영역을 프레임 남쪽에 삽입
			add(tf, BorderLayout.SOUTH);
			setSize(300, 300);
			setVisible(true);
			
			//유저들 접속 리스트 생성
			list = new ArrayList<MultiServerThread>();
			try {
			//포트 5000 서버 소켓
				ServerSocket serverSocket = new ServerSocket(5000);
				MultiServerThread mst = null;
				//서버 실행 상태 플래그 실행중으로 변경
				boolean isStop = true;
				//서버 실행 중 확인 메시지에 한줄 텍스트 영역에 셋팅
				tf.setText("서버 정상 실행중입니다 관리자님!!!");
				//서버 실행 상태 출력
				 System.out.println("isStop : " + isStop);
				 //서버가 실행중이라면
				 while(isStop) {
					 //유저 연결 시 소켓 생성
					 socket = serverSocket.accept();
					 //해당 유저에 대한 채팅 중개 스레드 생성
					 mst = new MultiServerThread();
					 //스레드를 리스트에 넣고 시작
					 list.add(mst);
					 mst.start();				 
				 }
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		public static void main (String[] args) {
			new ChattingServer();
		}
		public class MultiServerThread extends Thread {
			InputStream is;
			BufferedReader br_in;
			BufferedWriter bw;
			PrintWriter pw;
			OutputStream os;
			String message;
			//스레드 동작
			public void run() {
				System.out.println("MultiServerThread is called");
				boolean isStop = false;
				try {
					//연결된 소켓에 대한 입출력 스트림 생성
					is = socket.getInputStream();
					os = socket.getOutputStream();
					//입출력 스트림에 대한 문자 스트림 및 버퍼 적용
					br_in = new BufferedReader(new InputStreamReader(is));
					bw = new BufferedWriter(new OutputStreamWriter(os));
					//출력 스트림에 대한 프린터 적용
					pw = new PrintWriter(bw, true);
		//스레드가 실행중이면			
					while(!isStop) {
					//소켓으로 읽어온 메시지를 저장하고
						message = br_in.readLine();
						//메시지를 "#"문자를 구분자로 나눠 배열에 담는다
						String[] str = message.split("#");
						//배열의 두 번째 인덱스가 "exit"이면
						if(str[1].equals("exit")) {
							//해당 메시지를 모든 유저에게 전송하고
							broadCasting(message);
							//스레드 정지
							isStop = true;
							//아니면 모든 메시지를 모든 유저에게 전송한다. 
						} else {
							broadCasting(message);
						}
					}
					//리스트에서 이 유저의 스레드를 삭제하고
					list.remove(this);
					//해당 유저 ip주소와 메시지를 여러줄 텍스트 영역에 추가한다. 
					ta.append(socket.getInetAddress() + "IP주소의 사용자께서 종료하셨습니다.\n");;
					//한줄 텍스트 영역에 현재 list 크기로 접속 중인 유저 수를 셋팅한다. 
					tf.setText("남은 사용자 수 : " + list.size());
				} catch (Exception e) {
					//비정상 종료시 
					list.remove(this);
					ta.append(socket.getInetAddress() + "IP주소의 사용자께서 비정상 종료하셨습니다.");
				}
			}
			//리스트에서 접속 중인 모든 유저에게 메시지 전송 메소드 실행하는 메소드\
			public void broadCasting(String message) {
				System.out.println("broadcasting is called");
				for(MultiServerThread ct : list) {
					ct.send(message);
				}
			}
			//해당 메시지를 전송하는 메소드
			public void send(String message) {
				pw.println(message);
			}
		}
	}


