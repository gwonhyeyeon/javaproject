package java_0605_2;



public class InnerTest {

	public static void main(String[] args) {
		MyOuter1 myOuter = new MyOuter1("홍길동", 20);
		MyOuter1.Inner inner = myOuter.new Inner("세종시 세종구");
		//myouter 인스턴스에 대한 inner 인스턴스를 생성합니다. 
		System.out.println("고객정보 >> "+ inner.getUserInfo());

	}//인스턴스 내에 또 다른 인스턴스를 만든겁니다. 내부 클래스 중첩클래스 라고 한다.

}
