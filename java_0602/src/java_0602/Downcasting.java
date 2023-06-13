package java_0602;
//다운캐스팅: 자식 클래스의 타입으로 부모 클래스의 객체를 참조하는 것
//다운캐스팅은 기본적으로 업캐스팅된 객체에만 적용 가능하며,
//이를 통해 자식 클래스의 필드와 메소드에 접근한다, 명시적으로 타입변환을 해야한다.
//다운캐스팅의 경우는 자료 손실의 가능성이 존재한다. 
//다운캐스팅은 항상 안전하게 이루어지지 않으므로, instanceof를 사용하여
//실제 참조하는 객체가 해당 클래스의 인스턴스 인지 확인하는 것이 좋습니다. 
class Parent {
	public void sayHello() {
		System.out.println("Hello from parent");
	}
}
class Child extends Parent {
	public void sayHello() {
		System.out.println("Hello from child");
	}
	public void sayGoodbye() {
		System.out.println("Goodbye from Child");
	}
}

public class Downcasting {

	public static void main(String[] args) {
		Parent p = new Child(); //업캐스팅 자식을 부모로 바꾸는 것 
		p.sayHello();
		
		if(p instanceof Child) { //p를 child의 인스턴스를 참조
			Child c = (Child) p; //다운 캐스팅 부모를 자식으로 바꾸는 것 
			c.sayGoodbye();
		}
	}
}
