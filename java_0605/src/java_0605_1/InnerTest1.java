package java_0605_1;

public class InnerTest1 {

	public static void main(String[] args) {
		MyOuter1 myouter = new MyOuter1("홍길동", 20);
		System.out.println(myouter.getName());
		System.out.println(myouter.getAage());
		MyOuter1.Inner inner = new MyOuter1.Inner("세종시 세종구");
		System.out.println("고객정보 >> " + inner.getUserInfo());

	}
//문> static을 안쓰고 고객정보 >> 이름 : 홍길동, 나이 : 20 주소까지 출력
}
