package java_0613;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//EX_02
public class Suffle {
//suffle 카드를 섞고 있다. 
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i <= 10; i++) 
			list.add(i);
		//collections.suffle 메소드를 활용해 랜덤으로 데이터를 출력하는 예지
		 Collections.shuffle(list);
		 System.out.println(list);
	}
}
