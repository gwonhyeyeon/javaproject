package java_0608;
//Ex_09
//다중 catch문의 특징
//- 자바 명령문이 많아지면 발생할 수 있는 Exception의 종류도 많아진다. 
//- 다중 catch문은 순차적으로 해당 예외를 체크한 후에 예외 처리를 한다. 
//다중 catch문 구현 시 Exception 계층 구조에서 상위 클래스 타입 매개변수를
//가지는 catch문은 뒤에(아래줄에) 위치시켜야 한다. 
//최상위 : Exception 상위 : IOException 하위 : FileNotFoundException
//finally문 -- 예외 발생 유무와 상관없이 실행하는 부분 
public class ExceptionTest1 {

	public static void main(String[] args) {
		try {
			int [] num = new int[2];
			num[0] = 1;
			num[1] = 2;
			num[2] = 3; //ArrayIndexOutBoundsException 발생
			//num[1] = 3/0; ArithmeticException 발생
			System.out.println("Hello");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 처리");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("World");
	}
}
