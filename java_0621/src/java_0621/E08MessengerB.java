package java_0621;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java_0621.E08MessengerA.MyFrame;

public class E08MessengerB {
	
	protected JTextField textField;
	protected JTextArea textArea;
	//DatagramSocket : 데이터그램 패킷을 보내고 받기 위한 소켓 클래스
	//데이터그램 소켓은 패킷 전달 서비스를 위한 송신 또는 수신 지점
	//데이터그램 소켓에서 보내거나 받은 각 패팃은 개별적으로 주소가 지정되고 라우팅 됩니다. 
	//한 시스템에서 다른 시스템으로 전송된 여러 패킷은 다르게 라우팅 될 수 있으며
	//순서에 관계없이 도착할 수 있습니다. 
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	final int myPort = 5555;
	final int otherPort = 2222;
	public E08MessengerB() throws IOException{
//프레임 객체 생성
		 new MyFrame();
		 //localhost(도메인명)의 ip주소를 inetaddress로 반환
		 address = InetAddress.getByName("localhost");
		 System.out.println(address);
		 //수신용 포트번호로 데이터그램 소켓 생성 및 연결
		 socket = new DatagramSocket(myPort);		 
	}
	//받은 데이터 처리 프로세스
	public void process() {
		while(true) {
			try {
	//데이터에 담을 바이트 배열 생성
				 byte[] buf = new byte[256];
				 //buf배열의 길이만큼의 패킷을 받아 buf배열에 저장하는 데이터그램패킷 객체 생성
				 packet = new DatagramPacket(buf, buf.length);
				 //연결된 소켓으로 받아온 데이터를 패킷 객체에 받는다
				 socket.receive(packet);
				 /*
				  * 소켓.recieve(데이터그램패킷)이 소캣에서 데이터그램 패킷을 받습니다. 
				  * 이 메서드가 반환되면 DatagramPacket의 버퍼는 수신된 데이터로 채워집니다. 
				  * 데이터그램 패킷에는 보낸 사람의 IP주소와 보낸 사람 컴퓨터의 포트 번호도 포함됩니다. 
				  * 이 메서드는 데이터그램이 수신될 때까지 차단됩니다. 데이터그램 패킷 객체의 길이 필드는
				  * 수신된 메시지의 길이를 포함합니다. 메시지가 패킷 길이보다 길면 메세지가 잘립니다. 
				  * 보안관리자가 있는 경우 보안 관리자의 checkAccept메소드가 허용하지 ㅇ낳으면
				  * 패킷을 수신할 수 없습니다. 
				  * textArea에 받아온 메시지를 추가한다.
				  * */
				 textArea.append("Recieved : " + new String(buf) + "\n");
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}
	//프레임 및 이벤트 내부 클래스 
	class MyFrame extends JFrame implements ActionListener{
		public MyFrame() {
			super("MessengerB");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//열개수(문자개수)30인 jtextfield 생성 및 이벤트 지정
			textField = new JTextField(30);
			textField.addActionListener(this);
			textArea = new JTextArea(10, 30);
			textArea.setEditable(false);
			//textField를 프레임 아래쪽에 추가 
			//borderlayout.page_end 구성 요소는 레이아웃 콘텐츠의 마지막 줄 다음에 삽입 됨
			//왼쪽에서 오른쪽 및 아래 방향의 south와 동일
			add(textField, BorderLayout.PAGE_END);
			add(textArea, BorderLayout.CENTER);
			
			pack();
			setVisible(true);
		}
		//액션이벤트
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 //textField 에 입력된 문자열을 가져온다 
			 String s = textField.getText();
			 //문자열의 바이트 데이터를 바이트 배열 버퍼에 담는다
			 byte[] buffer = s.getBytes();
			 DatagramPacket packet;
			 //데이터그램 패킷을 생성한다
			 //데이터를 보내거나 받을 때 활용되며, 데이터를 묶는 클래스
			 //데이터를 보낼때는 아래와 같이 객체 생성하여 4가지 인수가 필요하고
			 //new datagramPacket(보낼 데이터바이트 버퍼, 보낼 바이트 길이, 보낼 곳 ip주소 , 보낼 곳 포트 번호);
			 //보낼 바이트 길이는 보낼바이트 버퍼에 담긴 바이트 길이보다 짧아야한다.
			  packet = new DatagramPacket(buffer, buffer.length, address, otherPort);
			  try {
				  //연결된 소켓으로 작성한 문자열의 바이트 데이터 전송
				   socket.send(packet);
				
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			  //textArea에 내가 보낸 메시지 추가
			  textArea.append(" SENT : " + s + "\n");
			  //바로 다음 메시지를 입력할 수 잇게 작성했던 ㅁ누자를 드래그 처리한다. 
			  textField.selectAll();
			  //현재 코드에선 ↓이겅 벗어도 동작이 됨
			  //캐럿의 위치를 textArea의 문자모델(getDocument)의 문자(getLengh)위치에 설정한다. 
			  //즉 캐럿을 textArea에 입력된 문자의 마지막에 위치시킨다.
			  //보내거나 받는 문자열의 마지막에 "\n"의 줄바꿈 이스케이프 문자가 있기 때문에
			  //텍스트를 입력할 커서를 textField 
			  textArea.setCaretPosition(textArea.getDocument().getLength());
		 }
	}
	public static void main(String[] args) throws IOException{
		//gui 구현과 메시지를 보내는 이벤트 분배 스레드 
		E08MessengerB n = new E08MessengerB();
		//상대방의 메시지를 받아 GUI 컴포넌트 내용을 업데이트 하는 메인 스레드 
		n.process();

	}


}
