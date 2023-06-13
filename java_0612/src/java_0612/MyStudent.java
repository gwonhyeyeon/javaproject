package java_0612;
//Ex_03 클래스 파일
public class MyStudent {

	//Field
	String name;
	//Constructor : 멤버 변수 초기화
	public MyStudent(String name) {
		this.name = name;
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
