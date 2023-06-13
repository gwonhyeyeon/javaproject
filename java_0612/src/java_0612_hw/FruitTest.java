package java_0612_hw;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class FruitTest {

	public static void main(String[] args) {
		
		String [] fruit = {"사과", "바나나", "귤", "수박", "사과", "사과", "귤", "수박","수박", "바나나",
				"귤", "사과", "사과", "수박", "귤", "바나나", "바나나", "사과", "귤", "귤"};
		
		HashMap<String, Integer> map = new HashMap<>();
		
		String fruitName = null;//과일이름
	
		for(int i =0; i < fruit.length; i++) {
			if(map.containsKey(fruit[i])) {
			int value = (int)map.get(fruit[i]);
			map.put(fruit[i], value + 1);
			
			}else {
				map.put(fruit[i], 1);
			}
				
	}
		System.out.println("과일 개수 출력하기");
		System.out.println("===================");
		Iterator ite = map.entrySet().iterator();
		while(ite.hasNext()) {
		Map.Entry entry= (Map.Entry)ite.next();
		int value = (int)entry.getValue();
		System.out.println(entry.getKey() + " : " + value + "개");
			
		}

	}
}

