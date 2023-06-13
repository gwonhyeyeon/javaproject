package java_0607;

//<T> 로 활용되며, 어떤 변수 타입이 오더라도 활용이 가능하다
//전달받을 변수 타입이 정해지지 않았을 때 사용 가능하다
interface MyFunction<T> {
	//인수에서 전달하는 변수 타입에 따라 String이 될 수도 있고 interger가 될 수도 있다 
	//이런 대문자 변수들을 랩퍼 크랠스라고 하며
	//랩퍼 클래스 변수는 자체로 클래스가 된다. (이미 정의 돼있기 때문에 별도의 선언은 불필요)
	void print(T x);
}

public class Ex_11 {

	public static void main(String[] args) {
		//여기서 변수 타입은 String
		//toStirng 메소드를 객체에 저장된 값을 출력할 수 있다. 
		 MyFunction<String> f1 = (x) -> System.out.println(x.toString());
		 f1.print("ABC");
		 //여기서는 Integer로 서로 다르지만 변수 타입을 제네릭 변수로 받기 때문에 문제 없다. 
		 //toString 메소드는 문자열만 출력 가능하기 때문에
		 //integer변수의 경우 별도의 작업을 거쳐야 출력이 가능하다
		 //랩퍼 객체로 변환은 valueof 메소드를 (boxing)
		 //int 변환은 parseInt()를 활용한다 (unboxing)
		 MyFunction<Integer> f2 = (x) -> System.out.println(x.toString());
		 f2.print(Integer.valueOf(100));
		 //제네릭은 결국 타입인가요?
		 //제네릭은 자바에서 데이터 타입을 파라미터화(Parameterize) 할 수 있는 방법을 제공하는
		 //프로그래밍 기법입니다. 그 자체로 타입은 아니지만, 클래스나 인터페이스, 메서드를 정의할 때 
		 //사용하는 타입 매개변수를 가리킵니다. T K V N E 제네릭의 타입변수 
	}
}
