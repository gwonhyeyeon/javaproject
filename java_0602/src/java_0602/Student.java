package java_0602;

public class Student {
	String name;
	int grade;
	
	public Student() {
		System.out.println("Student 부모 생성자 호출");
	}
	public String getName() {return name;}
	public int getGrade() {return grade;}
	
	public String getStudInfo() {
		System.out.println("Student 클래스의 getStudInfo() 호출");
		return "이름 : " + name + ",학년"
				+ grade;
	}
}
//super 정의와 용도
//자식 클래스 인스턴스에서 부모 클래스 인스턴스를 가리키는 변수
//1. 부모 생성자 호출 super()
//2. 부모 클래스 멤버 호출 super.age, super.getAage();
