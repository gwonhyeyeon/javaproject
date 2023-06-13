package java_0608;
//EX_11
//try/catch문으로 예외 처리하지 않은 경우
//1. 예외가 발생하면 JVM에게 예외를 던진다 throws
//2. JVM은 발생한 예외를 분석한 후 ArrayIndexOutofBoundException 객체를 생성한다. 
//3. JVM은 생성된 예외 객체를 발생된 곳으로 던진다. 

public class ArrayUtil {

	public void call() throws Exception {
		System.out.println("call 메서드 시작");
		int [] num = new int[2];
		num[0] = 1;
		num[1] = 2;
		num[2] = 3; //예외발생
		System.out.println("call 메서드 종료");
	}
}
////try/catch문으로 예외 처리 한 경우
//1. 예외가 발생하면 JVM에게 예외를 던진다 throws
//2. JVM은 발생한 예외를 분석한 후 ArrayIndexOutofBoundException 객체를 생성한다. 
//3. JVM은 생성된 예외 객체를 발생된 곳으로 던진다. 
//4. JVM이 던진 예외 객체를 catch블록이 잡는다. 
//5. 예외 처리를 한 후 프로그램이 정상 종료한다. 
