package java_0602;

class Animal {
	public void makeSound() {
		System.out.println("Test is making a sound");
	}
}
class Dog extends Animal{
		@Override
		public void makeSound() {
			System.out.println("Dog is barking");
		}
		public void wagTail() {
			System.out.println("Dog is wagging its tail");
		}
	}//부모 클래스를 선언하고 자식클래스를 생성하여 부모는 자식을 사용할 수 있다. 
public class Upcasting {
		public static void main (String args[]) {
			Animal myAnimal = new Dog(); //Upcasting
			myAnimal.makeSound();
			//myAnimal.wagTail() //error
			// 업캐스팅은 특히 다형성을 활용할 때 주로 사용
		}
	}
//다형성이란, 부모 클래스 타입의 참조 변수가 자식 클래스 타입의 객체를 참조하도록 할 때, 
//같은 메소드를 호출하더라도 자식 클래스에 따라 다른 동작을 하는 기능을 말합니다.
//좋은 점 : 코드를 유연하게 작성할 수 있다. 