package java_0607;
interface A {
	void abc();
}
class B {
	void bcd() {
		System.out.println("메서드");
	}
}

public class Ex_07_RefOfInstanceMethod_Type1_1 {

	public static void main(String[] args) {
		//#1.인스턴스 메서드 참조 type1 익명이너클래스
		A a1 = new A() {
			@Override
			public void abc() {//'abc'메서드에서 클래스 B의 인스턴스를 생성하여 
				B b = new B();
				b.bcd(); //'bcd'메서드를 호출
			}
		};
		//#2. 람다식
		A a2 = () -> {
			B b = new B();
			b.bcd();
		};
		//#3. 인스턴스 참조 Type1의 표현
		B b = new B();
		A a3 = b::bcd;//b::bcd는 클래스 B의 객체 b의 메서드 bcd를 참조
		//람다식() -> b.bcd()의 축약형
		//인스턴스의 'bcd'메서드를 참조하여 인터페이스 A의 'abc'메서드를 정의
		a1.abc();
		a2.abc();
		a3.abc();
		
	}
}
