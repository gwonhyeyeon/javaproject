package java_0613_1;

import java.util.ArrayList;

public class Player {
	
	//arraylist사용해서 만들기
	 
	ArrayList<Card> list = new ArrayList<>();
	private Card card;
	
	public void getCard(Card card) {
		list.add(card);
	}
	public void showCards() {
		System.out.println(list);
	}
}
//스트림은 프로그램과 외부 매체와의 통로 역할을 한다
//파일 열기 (1단계)
//-읽기용 : FileInputStream 변수명 = FileInputStream("파일명(경로포함)")
//-쓰기용 : FileOutputStream 변수명 = FileOutputStream("파일명(경로포함)")
//파일 처리 (2단계)
//데이터를 쓰거나 파일로부터 데이터를 읽어올 수 있는 상태 
//파일 닫기 (3단계)
//-변수명.close();
//(1) 스트림은 데이터를 송수신하기 위한 통로의 개념으로서 입력 혹은 출력 단방향으로만 진행된다. 
//(2) 스트림은 1바이트를 처리하는 바이트 스트림과 2바이트를 처리하는 문자 스트림으로 나뉜다. 
//(3) 바이트 스트림 : FileInputStream, FileOutputStream 등
//(4) 문자 스트림 : BufferReader, BufferedWriter, FileReader, FileWriter 등
//(5) 한글은 유니코드이기 때문에 2바이트 단위이므로 문자 스트림을 사용하는 것이 편리하다.
//char 단위의 입력 Reader 출력은  Writer
//FileInputStream 생성자
//FileInputStream (File file)
//FileInputStream(String name)