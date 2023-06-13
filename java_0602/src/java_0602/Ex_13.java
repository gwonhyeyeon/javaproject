package java_0602;

public class Ex_13 {
	String title;
	String author;
	//아래 생성자의 매개변수 수가 다르다
	
	//작자미상일 경우 활용한다
	//즉, input 값, 매개변수가 하나일 때 활용
	public Ex_13(String t) {
		title = t;
		author = "작자미상";
	}
	//아래 생성자는 작자를 알 때 사용한다
	//즉, input 값 매개 변수가 두개 일 때 활용
	 public Ex_13(String t, String a) {
		 title = t;
		 author = a;
	 }
	 public static void main(String[] args) {
		 //두 클래스 모두 객체를 생성했을 므로 static 사용하지 않아도 된다. 
		 //아래 두 객체는 서로 가는 방향이 다르다. 매개변수 수에 맞춰 간다
		 Ex_13 littlePrinc = new Ex_13("어린왕자", "생택쥐페리");
		 Ex_13 loveStory = new Ex_13("춘향전");
		 System.out.println(littlePrinc.title + " " + littlePrinc.author);
		 System.out.println(loveStory.title + " " + loveStory.author);
		 
	 }
}
