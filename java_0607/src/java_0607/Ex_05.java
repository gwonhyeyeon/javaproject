package java_0607;

import java.util.Arrays;

public class Ex_05 {

	public static void main(String[] args) {
		String[] strings = { "로마에 가면 로마법을 따르라.","시간이 금이다.","펜은 칼보다 강하다"};
//Array.sort : 내림차순 정리
		//타입, 매개변수 -> 실행문 - 실행문;
		//아래 식은 문자열의 수가 적은 순으로 배열의 순서를 바꾸는 식이다. 
		Arrays.sort(strings, (first, second) -> first.length() - second.length());
		//for문을 활용해 정렬 된 문자열을 출력
			for(String s : strings)
				System.out.println(s);
	}
}//인터페이스 구현한 부분을 람다식으로 바꾸어 할당(대입)한 것이다. 
//람다식은 기본적으로 함수를 만들어 사용하는 것이다. 
//배열을 정렬하는 데 사용될 Comparator 객체 : 람다식 객체
//Comparator의 compare() 메소드 구현
//compare() 메소드는 두 개의 인자를 받아, 첫 번째 인자가 두 번째 인자보다
//"작으면" 음수, "같으면" 0, "크면" 양수를 반환합니다. 문자열의 길이가 짧은 순으로 정렬
//sort(strings, (first, second) -> strings(메소드의 첫번째 인자) 배열
//(first, second) 람다식은 두 번째 인자이다( 매개변수들) -> 메소드의 내용

