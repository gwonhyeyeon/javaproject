package java_0612_2;
//Vector와 ArrayList 는 모두 동적 배열을 구현
//차이점
//동기화 지원 : Vector는 스레드 동기화(thread-safe)를 지원
//용량 증가 : Vector 는 요소가 추가될 때 내부 배열의 크기를 자동으로 증가
//초기 용량 설정 : Vector는 생성할 때 초기 용량(capacity)을 설정
//레거시 클래스 : Vector는 자바의 초기 버전부터 존재하던 클래스 
//Vector에 객체 삽입
//-add(value) 메소드로 벡터의 맨 뒤에 객체 추가
//-add(index, value)메소드로 벡터의 원하는 위치에 객체 추가
//Vector 에서 객체 삭제
//-remove(index)메소드로 임의의 위치에 있는 객체 삭제
//(삭제 후 빈 공간은 자동으로 하나씩 땡겨짐)

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		//Vector 인스턴스 생성
		Vector<String> vector = new Vector<>();
		//요소 추가
		vector.add("사과");
		vector.add("바나나");
		vector.add("체리");
		
		//요소 개수 출력
		System.out.println("요소 개수 : " + vector.size());
		//요소 접근
		System.out.println("첫 번째 요소 : " + vector.get(0));
		//요소 순회
		for(String element : vector) {
			System.out.println(element);
		}
		//요소 삭제
		vector.remove(1);
		System.out.println("요소 개수 : " + vector.size());
		//vector 객체 생성
		Vector<String> v = new Vector<>();
		v.add("홍길동");
		v.addElement("이순신");      v.addElement("홍길동");
		System.out.println(v);
		for(int i = 0; i< v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
}
