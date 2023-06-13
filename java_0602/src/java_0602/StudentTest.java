package java_0602;

public class StudentTest {

	public static void main(String[] args) {
		//Student s = new Student(); //추상클래스는객체 생성이 불가능하다. 
		String singsang = null;
		Elementary e = new Elementary("이순신", 2);//upcasting
		University u = new University("홍길동", 3, 20);
		
		singsang=e.getStudInfo();
		System.out.println("학생 정보 : " +  singsang);
		singsang=u.getStudInfo();
		System.out.println("학생 정보 : " + singsang + ", 수강학점: " + u.getCourses() + "점");
	}
}
