package java_0607;

public abstract class Ex_04 implements Ex_03_Myfunction {

	public static void main(String[] args) {
	
		//람다식, 메소드를 편하게 활용하기 위해 추가 된 기능
		//람다식을 활용하면 코드를 많이 줄일 수 있지만 자바에서는 별로 좋아하지 않는다. 
		//인터페이스 객체 = 변수명 -> 메소드 정의
		Ex_03_Myfunction square = (x) -> x*x;
		//square.calc(2)를 하면 인터페이스 메소드가 윗 줄의 식으로 구현되어 결과가 출력된다. 
		System.out.println(square.calc(2));
		Ex_03_Myfunction doubleValue = x -> x * 2;
		System.out.println(doubleValue.calc(2));
		Ex_03_Myfunction increment = x -> x + 1;
		System.out.println(increment.calc(2));
	}

}
