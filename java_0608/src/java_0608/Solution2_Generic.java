package java_0608;
//Ex_03
class Goods<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}	
}

class Apple {
	
	@Override
	public String toString() {
		return "애플오브젝트입니다";
	}	
}
class Pencil {
	
	@Override
	public String toString() {
		return "연필오브젝트입니다";
	}
}

public class Solution2_Generic {
	
	public static void main(String[] args) {
		//#1. Goods를 통해서 Apple객체 추가 및 가져오기
		Goods<Apple> goods1 = new Goods<>();
		goods1.set(new Apple());
		Apple apple = goods1.get();
		System.out.println(apple);
		
		//#2.Goods을 통해서 Pencil 객체 추가 및 가져오기
		Goods<Pencil> goods2 = new Goods<>();
		goods2.set(new Pencil());
		Pencil pencil = goods2.get();
		System.out.println(pencil);
		
		//#3. 잘못 된 타입선언
		Goods<Apple> goods3 = new Goods<>();
		goods3.set(new Apple());
	
		
		//Pencil pencil2 = goods3.get(); //강한타입체크
	}	//toString 메소드가 오버라이드 되지 않았기 때문에 나오는 결과값입니다.
		//toString 메소드는 클래스 이름, @ 기호,
		//그리고 객체의 해시코드를 16진수로 표현한 값을 반환
	//오버라이드는 객체 지향 프로그래밍에서 하위 클래스 또는 자식 클래스가
	//상위 클래스 또는 부모 클래스의 메소드를 재정의하는 행위
	//메소드 오버라이딩은 상속과 밀접한 관계를 가지며,
	//상속 없이는 오버라이드를 수행할 수 없습니다. 
	//object 클래스의 toString() 메소드는 기본적으로 객체의 해시코드를 반환하지만, 
	//이 메소드를 원하는 형태로 재정의(오버라이드)하여 객체의 더 유용한 정보를 반환한다. 
	
}
