package java_0608;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex_05 {
	public static void main(String[] args) {
//문제>>
//StringTokenizer 클래스 사용
//변수명 query
//구분자 &
	StringTokenizer query = new StringTokenizer("name=kitae@addr=seoul&age=21", "&");
	while (query.hasMoreTokens()) {
		System.out.println(query.nextToken());
		HashMap m = new HashMap();
		//hashMap은 키-값 쌍으로 데이터를 저장하는 자료구조입니다. 
		//map으로 해봄(entry로 출력하면 키=값 형태가 되기 때문)
		m.put("name", "kitan");
		m.put("addr", "seoul");
		m.put("age", "21");//집합(Set)은 중복을 허용하지 않습니다. 
		Set s = m.entrySet();//키-값 쌍의 집합(Set)을 얻고, 저장한다.
		Iterator Iter = s.iterator();
		while(Iter.hasNext())
			System.out.println(Iter.next());
		}//hashMap은 각 키를 유일하게 갖기 때문에 키-값 쌍도 유일합니다. 		
	}
}
