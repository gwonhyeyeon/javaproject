package java_0612;

//Ex_01
//arrayList 특징
//객체(데이터)순서가 지정된다
//모든 타입의 객체를 저장할 수 있다. 
//저장하는 객체(데이터)의 개수에 ㅈ제한이 없다. 
//arraylist는  list인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트이다.

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
//문자열만 저장할 수 있는 arraylist 객체 생성
		ArrayList<String> al = new ArrayList<>();
		//add(value): ArrayList 삽입 메소드
		al.add("watermelon");
		al.add("apple");
		al.add("banana");
		al.add("watermelon");
		al.add("Jujube");
		al.add("banana");
		//size() : ArrayList 저장된 데이터의 개수를 반환하는 메소드
		System.out.println("Count : " + al.size());
		print(al);
		//set(index, value) 해당 인덱스에 저장된 데이터 변경하는 메소드
		//기존의 요소를 덮어 씌우는 역할
		al.set(1,  "kiwi");
		print(al);
		al.set(4, "peach");
		print(al);
		//get(index) : 해당 인덱스에 저장된 데이터를 반환
		System.out.println("Index3 : "+ al.get(3));
		//contains(value) : 해당 값이 저장되어 있는 지 확인
		System.out.println("banana : " + al.contains("banana"));
		//indexof(value) : 해당 값이 저장되어 있다면 그 위치(index) 반환
		System.out.println("banana : " + al.indexOf("banana"));
		//lastIndexof(value) :
		//해당 값이 여러 개 저장되어 있다면 제일 마지막에 저장된 위치(index) 반환
	 System.out.println("banana: "+ al.lastIndexOf("banana"));
	 		//arrayList 안의 값들을 확인하여 banana가 있다면
			// strawberry로 바꾸는 로직
			for(int i=0; i< al.size(); i++) {
				if(al.get(i).equals("banana"))
						al.set(i, "strawberry");
						print(al);
			}
						
//문자열만 저장할 수 있는 arrayList를 매개변수로 전달 받아
		//set 인터페이스는 요소의 순서를 유지하지 않으며,
			//인덱스의 요소를 검색하는 get(index)메서드를 제공하지 않습니다. 
			//get(index) 메서드는 list 인터페이스와 그 구현체들인 arrayList, LinkedList
			//등에서 사용할 수 있습니다. 
			//Set은 요소의 순서를 유지하지 않는 자료구조이기 때문에 순서에 의존하여 요소를 가져오는 것은
			//보장되지 않습니다. 따라서 set요소를 순서대로출력하거나
			//특정 인덱스의 요소를 가져오려면 iterator 를 사용하거나 foreach 루프를 활용해야 합니다. 
	}
	private static void print(ArrayList<String> al) {
		for(String str : al)
			System.out.print(str + "\t");
		System.out.println();		
	}
}
