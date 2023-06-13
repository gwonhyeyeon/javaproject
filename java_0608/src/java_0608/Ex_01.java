package java_0608;

class Point4 {
	int x, y;
	
	public Point4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
//==연산자는 참조 타입에서는 두 참조가 동일한 객체를 가리키고 있는지 비교한다.
public class Ex_01 {

	public static void main(String[] args) {
//a,b,c 모두 저장되는 값은 같지만 객체의 저장 위치가 다르므로
//c = a 로 대입 연산을 받은 a, c만 완전히 같은 값을 갖는다
//a와 b는 별도의 객체로 각각 할당되어 다른 주소를 가지지만 
//c는 a객체를 그대로 참조하기 때문이다
		Point4 a = new Point4(2, 3);
		Point4 b = new Point4(2, 3);
		Point4 c = a;
				
				if(a == b)
					System.out.println("a == b");
				if(a == c) 
					System.out.println("a == c");
				if(b == c)
					System.out.println("b == c ");
	}
}
