package java_0602_2;

//-'기능이 없고, 선언만 되어 있다'라는 의미

//예)
//추상 클래스 정의 .. 클래스 선언 시 abstract로 지정된 클래스
//추상 클래스 특징
//추상 클래스는 인스턴스 생성이 불가능하다. new() 로 직접 인스턴스 안된다. 
//-추상 클래스는 멤버 : 멤버변수, 멤버 메서드, 생성자, 추상 메서드
//-추상 메서드가 없어도 추상 클래스로 선언할 수 있다. 
//-클래스의 멤버에 추상 메서드가 있으면 그 클래스는 반드시 추상 클래스로 선언해야 한다. 
//- 업캐스팅 타입으로 사용 가능하다.
//추상클래스의 용도
//하위 클래스에서 구현해야 하는 기능을 상위 클래스의 추상 메서드의 형식을 빌려와
//하위 클래스에서 구현하는 방법으로 통일성과 강제성을 띈다. 표준화가 가능하다. 

public class StudentTest {

	public static void main(String[] args) {
		//Student s = new
		Student st = new Univaersity("홍길동", 3, 22, "홍명보");
		Elementary m = new Elementary("이순신", 2, "홍명보");
		String ss = null;
		
		ss = st.getStudInfo();
			
		System.out.println("학생이름 " + st.getName());
		System.out.println(st.getTeacher());
		System.out.println(m.getTeacher());
		System.out.println(ss);//변수에 담아서 return 값을 출력한다. 

	}

}
