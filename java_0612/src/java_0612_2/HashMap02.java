package java_0612_2;

import java.util.HashMap;
import java.util.Scanner;

//EX_07
public class HashMap02 {

	public static void main(String[] args) {
//학생 이름과 Student 객체를 쌍으로 저장하는 HashMap 컬렉션 생성
		HashMap<String, Student> map = new HashMap<>();
		
		//3명의 학생 저장
		map.put("박샘이", new Student(1, "010-111-1111"));
		map.put("홍준이", new Student(2, "010-222-2222"));
		map.put("김솔비", new Student(3, "010-333-3333"));
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("검색할 이름?");
			//사용자로부터 이름 입력 받아 name변수 저장
			String name = sc.nextLine();
			//입력 값이 exit면 while문 탈출
			if(name.equals("exit"))
				break;
			//입력한 이름(key)에 해당하는 Student 객체(value)검색하여 student 변수 저장
			Student student = map.get(name);
			//key에 해당하는 value가 없으면 이름과 없는 사람 출력
			if(student == null)
				System.out.println(name + "은 없는 사람입니다.");
		//있으면 해당 객체 안의 id와 전화번호 출력
			else {
				System.out.println("id : "+ student.id + ", 전화 : " + student.tel);
			}
			
		}
		sc.close();
	}
}
