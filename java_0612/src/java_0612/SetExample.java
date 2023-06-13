package java_0612;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//EX_06
//SET은 요소의 순서를 유지하지 않고 중복을 허용하지 않는 자료구조입니다. 
public class SetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		//set요소들을 순회하기 위해 Iterator객체를 생성합니다. 
		set.add("apple");
		set.add("banana");
		set.add("cherry");
		
		//Set을 순회하면서 요소를 가져오기
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}//hashset은 순서를 유지하지 않는 자료구조이므로 요소들이 출력되는
		//순서는 예측할 수 없습니다. list구조에 비해 속도가 느리다. 
		//set은 비선형 구조이기에 순서가 없으면 그렇기에 인덱스도 존재하지 않는다. 
		//set은 한 칸씩 저장공간을 늘리지 않고 약 2배로 늘리기에 여기서 과부하가 많이 발생한다.
	}

}
