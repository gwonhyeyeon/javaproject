package java_0602;

public class MethodOverridingEx {
	static void paint(Shape p) {
		p.draw(); //p가 가리키는 객체 내에 오버라이딩 된 draw()호출
		//동적 바인딩: 메서드를 오버라이드(재정의)하는 데 사용
		//실제 참조되는 인스턴스(자식 클래스)의 타입에 따라 결정됩니다
	}

	public static void main(String[] args) {
		Line line = new Line();
		paint(line);
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}

}
class Shape{//슈퍼 클래스
	public Shape next;
	public Shape() { next = null; }
	public void draw() {
		System.out.println("Shape");
	}
}
class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}
class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}