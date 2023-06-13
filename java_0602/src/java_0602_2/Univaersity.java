package java_0602_2;

public class Univaersity extends Student{
	private int courses;
	
	public Univaersity(String name, int grade, int courses, String teacher) {
		super();//Student클래스의 기본 생성자를 호출한다
		System.out.println("University 생성자 호출");
		super.name=name;
		super.grade=grade;
		super.teacher=teacher;
		this.courses=courses;
	}//여기서의 this는 현재 클래스의 인스턴스를 가르킵니다.
	public Univaersity() {
		this("이순신", 2, 20, "홍길동");
	}
	public int getCourses() {
		return courses;
	}
	//overriding 메소드
	public String getStudInfo() {
		System.out.println("University 클래스의 getStudInfo 메소드 호출");
		return "이름은 >> " + name + ", 학년은>>" + grade + ", 신청 학점은>>" + courses;
	}
	//학교명
	public String getTeacher() {
		return "지도 교수님:" + super.teacher;
	}
}
