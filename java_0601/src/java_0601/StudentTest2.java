package java_0601;


public class StudentTest2 {

	public static void main(String[] args) {
		Student s2= new Student("이순신", 3);
		Student s= new Student("홍길동");
		
		String name=s.getName();
		int grade = s.getGrade();
		
		System.out.println("첫 번째 학생의 이름은 "+ name +" , 학년은" + grade);
		
		name = s2.getName();
		grade = s2.getGrade();
		System.out.println("두 번째 학생의 이름은 " + name + ", 학년은 "+ grade);
	}
}
