package java_0607;

class Point {
	private int x, y;

	public 	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "x= " + x + " y= " + y;
	}
}

//object 클래스
//모든 클래스의 최상위(부모)클래스
//선언할 필요 없이 모든 클래스에 강제 상속 되어 있다. 


public class Ex_01 {
//매개변수로 object 변수를 받는다. object는 모든 객체 변수를 받는 다는 뜻으로
//어떤 타입의 객체가 올 지 모르겠다면 변수 타입을 object라고 해놓으면 해결 가능하다. 
//단 내부에서 활용할 때는 객체 형변환이 필요할 것이다.
	public static void print(Object obj) {
		//클래스 이름, 패키지명.객체의 클래스명 이런 식으로 돼 있다. 
		System.out.println(obj.getClass().getName());
		//해시코드 값, 객체를 식별하는 하나의 정수 값, 주소값이다.
		System.out.println(obj.hashCode());
		//객체의 정보를 문자열로 만들어 출력
		System.out.println(obj.toString());
		//객체 출력, toString 메소드를 활용한 것과 동일한 결과
		System.out.println(obj);

	}
	public static void main(String[] args) {
		//point 클래스에 좌표를 입력 하면서 객체 호출, 안하면 아랫줄 동작 불가
		Point p = new Point(2, 3);
		//static메소드이므로 객체 생성 없이 바로 사용 가능, static메소드는 이탤릭체로 바뀐다. 
		print(p);
	}

}
