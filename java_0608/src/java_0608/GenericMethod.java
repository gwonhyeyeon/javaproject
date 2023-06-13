package java_0608;


//EX_07
class GenericMethods {
	
	public <T> T method1(T t) {
		return t;
	}	
	public <T> boolean method2(T t1, T t2) {
		return t1.equals(t2);
	}
	public <K, V> void method3(K k, V v) {
		System.out.println(k + ":" + v);
	}	
}

public class GenericMethod {

	public static void main(String[] args) {
		GenericMethods gm= new GenericMethods();
		String str1 = gm.<String>method1("안녕");
		String str2 = gm.method1("안녕");
		System.out.println(str1);
		System.out.println(str2);
		
		boolean bool1 = gm.<Double>method2(2.5, 2.5);
		boolean bool2 = gm.method2(2.5, 2.5);
		System.out.println(bool1);
		System.out.println(bool2);
		
		gm.<String, Integer>method3("국어", 80);
		gm.method3("국어", 80);
	}

}

//제네릭 타입 변수명 두 개인 경우
//접근 지정자<T, V>T메서드 이름 (T t, V v) {
//타입 T를 사용한 코드
//}
//매개변수에만 제네릭을 사용된 경우
//접근지정자 <T> void 메서드 이름(T t) {
//타입 T를 사용한 코드
//제네릭 메서드 내부에서는 참조변수 t의 메서드로
//object클래스의 메서드만 사용 가능 예> equals() 가능하다
//리턴타입에만 제네릭을 사용되 ㄴ경우
//접근 지정자 <T> T메서드 이름 (int a) 
//접근 
