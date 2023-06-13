package java_0612_2;

//제너릭(Generic)타입 범위 제한 (Bound)의 종류
//#1. 제너릭 클래스의 타입 제한
//#2. 제너릭 메서드의 타입 제한
//#3. 일반 메서드 매개변수로서의 제너릭 클래스 타입 제한

class Bag<T> {

	private T thing;
	
	public Bag(T thing) {
		this.thing = thing;
	}
	
	public T getThing() {
		return thing;
	}
	public void setThing(T thing) {
		this.thing = thing;
		
	}
	void showType() {
		System.out.println("T의 타입은" + thing.getClass().getName());
	}
}

class Book {
	
}
class PencilCase{
	
}
class Notebook{
	
}

public class Ex_10_BagTest {

	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book()); //생략됨
		//Bag<Book> bag은 제너릭 타입으로 Book을 포함하는 Bag 객체를 참조하는 변수
		//(new Book())은 Bag클래스의 인스턴스(객체)를 생성하면서 Book을 생성한 후 인자로 전달
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		//클래스명 <타입 인자 목록> 변수명 = new 클래스명<타입 인자 목록> (생성자 인자 목록);
		
		 bag.showType();//bag은 Book의 타입을 보여줌 
		 bag2.showType();//bag2 pencilcase의 타입을 보여줌
		 bag3.showType();//bag3는 notebook의 타입을 보여줌
		//bag = bag2;
	}
//자식 클래스의 제너릭 변수의 개수는 부모보다 같거나 클 수 있음
}
