package java_0605_2;

public class MyOuter1 {
	 private String name;
	 private int age;
	 public MyOuter1(String name, int age) {
		 this.name = name;
		 this.age = age;
	 }
	 public String getName() {
		 return name;
	 }
	 public int getAage() {
		 return age;
	 }
	 public class Inner {
		 private String address;//자신만의 인스턴스 값을 가질 수 있다. 
		
		 //String tel = "010-1111-2222";
		
		 public Inner(String address) {
			 this.address = address;
		 }
		 public String getUserInfo() {
			 return "이름 : " + name + ", 나이 : " + age + ", 주소는 : " + address;
		 }
	 }
}

//내부클래스 : 클래스 내에 선언 된 클래스 
//두 클래스 간에 서로 긴밀한 관계가 있기 때문에 사용