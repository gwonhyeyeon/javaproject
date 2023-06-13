package java_0608;

import java.util.ArrayList;

public class ArrayList_02 {

	public static void main(String[] args) {
	//ArrayList 객체 생성
		ArrayList list = new ArrayList();
	//ArrayList에 해당 값 순서대로 추가
		list.add("MILK");
		list.add("BREAD");
		list.add("BUTTER");
		list.add(1, "APPLE");
		list.set(2, "GRAPE");
		list.remove(3);
		for(int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}// 2, 3, 4, 5 번 

//ArrayList<ArrayList_02> list = new ArrayList<ArrayList_02>()
//ArrayList<String> list = new ArrayList<String>();