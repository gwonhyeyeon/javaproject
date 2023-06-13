package java_0601;

public class Student {
	String name;
	int grade;
	
	public String getName() {
		return name;	
	}	
	public int getGrade() {
		return grade;	
	}
	public Student(String name, int grade) {
		this.name = name;
		this.grade=grade;
	}
	public Student(String name) {
		this.name = name;
		grade=1;
	}
	public Student() {
		System.out.println("디폴트 생성자 호출");
	}
}
