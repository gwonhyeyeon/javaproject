package java_0602_2;

public class Elementary extends Student {
	public Elementary(String name, int grade, String teacher) {
		System.out.println("Elementary 생성자 호출");
		super.name = name;
		//super는 student 클래스에 정의된 name, grade, teacher 필드를 가리킵니다. 
		super.grade = grade;
		super.teacher = teacher;
	}
	public Elementary() {
		this("이순신", 3, "홍길동");//현재 객체, 즉 현재 인스턴스를 참조
		//Elementary (String name, int grade, String teacher)를 호출합니다.
		System.out.println("Elementary 생성자 호출");
	}
	public String getTeacher() {
		return "담임 선생님 :" + super.teacher;
	}//student 클래스의 teacher 필드를 참조합니다. 
}
//this() 생성자를 호출하는 특별한 키워드라고 보면 됩니다. 
//this()를 사용하면 같은 클래스 내의 다른 생성자를 호출할 수 있습니다. 
//이는 생성자 오버로딩, 생성자 체이닝(Constructor Chaining)이라고 합니다. 