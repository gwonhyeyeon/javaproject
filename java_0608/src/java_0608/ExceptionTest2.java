package java_0608;
//EX_10
//throws 처리 방식
// public [리턴 타입] 메서드명 ([매개변수]) throws 예외 클래스명 {
//예외 발생 시 발생한 예외를 메서드를 호출한 곳으로 전달하여 예외 처리를 한다. 
//-최초 메서드를 호출한 main() 메서드에서 try/catch 문으로 예외처리를 한다. 
//RumtimeException 계열은 throws할 필요가 없다. 
public class ExceptionTest2 {

	public static void main(String[] args) {
		try {
			int[] num = new int[2];
			num[0] = 1;
			num[1] = 2;
			//num[2] = 3; //예외발생
			System.out.println("Hello ");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 오류 발생");
		}finally { //무조건 하기 때문에 생략이 가능하다.
			System.out.println("오류 발생 유무와 무관하게 반드시 수행된다 ");
		}
		System.out.println("World");
	}
}
