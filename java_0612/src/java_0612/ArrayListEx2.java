package java_0612;
//ex_05
import java.util.ArrayList;

public class ArrayListEx2 {

	public static void main(String[] args) {
	//ArrayList 객체 변수 생성
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> cha = new ArrayList<>();
		ArrayList<Integer> kyo = new ArrayList<>();
		ArrayList<Integer> hap = new ArrayList<>();
		
		//변수 입력, list1과 2에 데이터를 입력하고 교집합 합집합 차집합 계산
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		//addAll(value).해당값을 ㅁ두 넣는다
		//removeAll(value): 해당 값을 모두 뺀다
		//차집합 : list1에서 list2랑 겹치는 값 제거
		cha.addAll(list1);// cha(1, 2,3,4)
		cha.removeAll(list2);//cha(1, 2)
		//합집합 : ;list1과 2의 값 모두 포함 (중복 없이)
		hap.addAll(cha); //hap(1,2)
		hap.addAll(list2);//hap(1,2,3,4,5,6,)
		//교집합 : list1과 2가 겹치는 값만 포함
		kyo.addAll(list1);//kyo(1,2,3,4)
		kyo.removeAll(cha);//kyo(3, 4)

		System.out.println("교집합 : " + kyo);
		System.out.println("합집합 : " + hap);
		System.out.println("차집합 1-2 : " + cha);
	}
}
