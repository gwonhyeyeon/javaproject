package java_0602_2;

public abstract class Student {
	String name;
	int grade;
	String teacher;
	public Student() {
		System.out.println("Student 생성자 호출");
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public String getStudInfo() {
		System.out.println("Student 클래스의 getStudInfo()메소드 호출");
		return "이름은 : " + name + ",학년은 " + grade;
	}
	//학생의 담임선생님의 이름을 구하는 추상 메서드
	public abstract String getTeacher();
}
