package java_0612;

import java.util.ArrayList;
import java.util.Scanner;

//ex_04 
//arraylist는 스레드 동기화를 지원하지 않고 조금씩 용량을 늘리는 특징이 있습니다. 
//일반적으로는 arrayList를 사용하는 것이 성능 면에서 더 효율적입니다. 
public class ArrayListEx {
	public static void main(String[] args) {
	//ArrayList 객체 변수 생성
		ArrayList<String> a = new ArrayList<String>();
		//데이터를 입력받기 위해 scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		//for문을 활용해 4개의 데이터 입력
		for(int i=0; i < 4; i++) {
			System.out.println("이름을 입력하세요>>");
			String s = sc.next();
			a.add(s);
		}
		//입력 정보 출력
		for(int i =0; i< a.size(); i++) {
			String name = a.get(i);
			System.out.println(name + " ");
		}
		//가장 긴 문자를 찾아냄
		int longestIndex = 0;
		for( int i= 0; i< a.size(); i++) {
			//arraylist 의 0번째 그 다음값과 순차적으로 비교하여 큰 값 저장
			if(a.get(longestIndex).length() < a.get(i).length())
				longestIndex = i;
		}	
		System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex));
		sc.close();
	}
}
//만일 메서드 내에 특정 클래스의 메서드를 사용하고 싶다면? 제너릭 타입의 범위 제한