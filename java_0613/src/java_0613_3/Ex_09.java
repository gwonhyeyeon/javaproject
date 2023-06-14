package java_0613_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex_09 {

	public static void main(String[] args) throws IOException {
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			int c;
			//아웃풋 스트림을 활용해 data.bin 파일 생성(프로젝트 폴더 안에 생성됨)
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin")));
			out.writeDouble(3.14);
			out.writeInt(100);
			//writeUTF() 메소드는 문자열 UTF-8의 변형된 형식으로 출력
			out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다. ");
			//flush() : 버퍼를 수동으로 비우기, 남은 것이 있다면 전부 비운다. 
			//버퍼에 잔류하는 모든 바이트를 출력한다. 
			out.flush();
			//먼저 버퍼된 파일 출력 바이크 스트림을 생성하고 이것을 생성자의 매개변수로 전달
			//data.bin 파일에 저장된 내용을 읽어드림
			in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));
			//data.bin 객체에 저장된 내용을 저장 형식에 맞춰 읽어들임
			System.out.println(in.readDouble());
			System.out.println(in.readInt());
			System.out.println(in.readUTF());
		} finally {
			//try-catch문에서  fially는 무조건 실행된다. 마지막으로 반드시!!
			//코드가 정상 작동되면 finally를 통해 input, output 객체들을 종료시킨다. 
			if(in != null) {
				in.close();
			}if(out != null) {
				out.close();
			}
		}
	}
}
