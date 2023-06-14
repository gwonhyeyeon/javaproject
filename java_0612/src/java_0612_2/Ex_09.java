package java_0612_2;
//Comparable<T> 인터페이스 : compareTo(T obj) 추상 메서드를 활용할 수 있음
//Numutil은 comparable을 상속 받는 타입만 전달 받을 수 있고, 인터페이스 

class NumUtil<T extends Comparable<T>> implements Maximum<T>{
	//제네릭 타입 배열 Field
	private T[] value;
	//생성자 : 멤버 변수 초기화
	public NumUtil(T[] value) {
		this.value = value;
	}
//상속 받은 인터페이스 Maximum의 max()메소드 구현
	//배열 ;요소 중 가장 큰 값을 찾는 메소드
	public T max() {
		//변수 v에 멤버 변수 value 배열의 첫 번째 같을 저장
		T v = value[0];
		for(int i=0; i< value.length; i++) {
			if(value[i].compareTo(v) > 0)
				v= value[i];
//value[i]의 값이 더 크면 v변수 값이 저장, 가장 큰 값 추출
			//compare to 메소드는 현재 객체와 매개변수로 전달받은 객체의 유니코드 순서를 비교하여
			//작으면 음수, 같으면 0, 크면 양수로 반환
			 
		}
		return v;
	}
}
interface Maximum<T extends Comparable<T>> {
	//제너릭 인터페이스 선언, comparable을 상속 받는 타입만 전달 받음
	T max();
	//제너릭 타입<? extends 상위 타입> : Upper Bounded Wildcards (상위 클래스 제한)
//상위타입 이하. 상위타입의 클래스나 인터페이스 그리고 그것을 상속 받은 하위 것만 올 수 있다. 
		
	//제너릭 타입<?> : unbounded wildcards(제한없음)
	//-<? extends Object>의 요약어로 object 클래스의 하위 클래스 
	//즉 모든 클래스가 올 수 있다. 
	
	//제너릭 타입<? super 하위타입> : Lower Bounded Wildcards(하위 클래스 제한)
	//-하위 타입 이상. 즉 하위타입의 클래스나 인터페이스 그리고 
}

public class Ex_09 {

	public static void main(String[] args) {
		Integer[] inum = { 1, 2, 3, 4, 5};
		Double [] dnum = { 1.0, 2.0, 3.0, 4.0, 5.0};
		String [] snum = {"1", "2", "3", "4", "5"};
		//각 기본 타입의 제네릭 객체 생성 및 위에서 생성한 배열로 초기화
		NumUtil<Integer> iutil = new NumUtil(inum);
		//inum은 결국 인수이다. 객체를 생성하고 초기화하는 과정에서 사용되는 배열 인수이다. 
		NumUtil<Double> dutil = new NumUtil(dnum);
		NumUtil<String> sutil = new NumUtil(snum);
		//각 객체마다 초기화환 배열의 제일 큰 값 출력
		System.out.println("inum 최대값 : " + iutil.max());
		System.out.println("dnum 최대값 : " + dutil.max());
		System.out.println("snum 최대값 : " + sutil.max());
	}
}
