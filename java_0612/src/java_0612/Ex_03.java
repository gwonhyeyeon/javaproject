package java_0612;

import java.util.ArrayList;

public class Ex_03 {

	public static void main(String[] args) {
//MyStudent 객체만 넣을 수 있는 ArrayList 객체 생성
		ArrayList<MyStudent> list = new ArrayList<MyStudent>();
		//arraylist에 "이순신"으로 초기화된 mystudent 객체 삽입
		list.add(new MyStudent("이순신"));
		list.add(new MyStudent("홍길동"));
		//arrayList에 저장된 mystudent객체를 빼오기 위해
		//mystudent타입의 변수 생성 후  get() 메소드로 arraylist의 첫 번째 값 대입
		//MyStudent s = list.get(0);
		// mystudent s =( mystudent)list.get(0);//제너릭 없으면 이렇게 함
		//저장된 이름을 출력한다
		//System.out.println("학생 이름 : " + s.getName());
		String name = list.get(0).getName();
		String name1= list.get(1).getName();
		System.out.println("학생 이름 : " + name);
		System.out.println("학생 이름 : " + name1);
	}
}

//문 - 홍길동을 추가해보니 이순신 다음에 홍길동 나오게 해보세요