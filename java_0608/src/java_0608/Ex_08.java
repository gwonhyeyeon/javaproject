package java_0608;

class SimplePair<T> {
 
	private T first;
	private T second;
	
	public SimplePair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
}

public class Ex_08 {
	public static void main(String[] args) {
//제네릭 클래스 SimplePair<T>는 타입 파라미터 T를 가지고 여기서 T는 어찌보면
		//SimplePair 객체가 저장할 수 있는 데이터의 타입을 나타내는 placeholder입니다. 
		//T대신 실제 타입인 String을 제공
		SimplePair<String> pair = 
				new SimplePair<String>("apple", "tomato");
		//pair는 두 개의 String 객체를 저장하는 SimplePair 객체를 참조하게 됩니다. 
		//getter 메소드를 통해 데이터 획득
		System.out.println(pair.getFirst());
		System.out.println(pair.getSecond());
	}
}
//클래스명 뒤에 오는 꺾쇠<T>로 표현하면
//클래스 내부의 모든 T는 인수로 부터 전달된 랩퍼 클래스 타입으로 변경된다. 
//만약 Integer 라고 돼있으면 모든 T는 정수형이 되어 활용 가능하다. 
