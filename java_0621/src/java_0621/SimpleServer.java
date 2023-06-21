package java_0621;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {
		BufferedWriter bw;
		PrintWriter pw = null;
		OutputStream os;
		ServerSocket serverSocket;
		Socket s1 = null;
		InetAddress ipAddrs = null;
		String connectedClient = null;
		String outMessage = null;
		
		try {
			serverSocket = new ServerSocket(5434);
			System.out.println("서버 실행 중....");
			while(true) {
				//클라이언트의 접속을 인지 시에 accept() 메소드를 호출해서 소켓 객체를 생성한다.
				s1 = serverSocket.accept();
				os = s1.getOutputStream();
				ipAddrs = s1.getInetAddress();
				connectedClient = ipAddrs.toString();
				bw = new BufferedWriter(new OutputStreamWriter(os));
				pw = new PrintWriter(bw, true);
				pw.println(connectedClient + "에서 서버에 접속하셨습니다. ");
				pw.close(); s1.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
