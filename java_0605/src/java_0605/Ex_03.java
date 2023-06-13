package java_0605;

interface MobilePhoneInterface extends PhoneInterface{
	void sendSMS();
	void recieveSMS();
}

interface MP3Interface {
	public void play();
	public void stop();
}

class PDA {
	public int calculate(int x, int y) {
		return x + y;
	}
}
//클래스는 클래스도 상속 받고 인터페이스도 동시에 상속 받을 수 있다. 
//자바에서 인터페이스는 다중상속을 허용한다.
class Smartphone extends PDA implements MobilePhoneInterface, MP3Interface {
	@Override
	public void sendCall() {
		System.out.println("따르릉 따르릉~~~");
	}
	@Override
	public void receiveCall() {
		System.out.println("전화 왔어요");
	}
	@Override
	public void sendSMS() {
		System.out.println("문자갑니다.");
	}
	@Override
	public void recieveSMS() {
		System.out.println("문자왔어요.");
	}
	@Override
	public void play() {
		System.out.println("음악 연주합니다.");
	}
	@Override
	public void stop() {
		System.out.println("음악 중단합니다.");
	}
	public void schedule() {
		System.out.println("일정관리합니다.");
	}
}

public class Ex_03 {

	public static void main(String[] args) {
		Smartphone phone = new Smartphone();
		phone.printLogo();
		phone.sendCall();
		phone.play();
		System.out.println("3과 5를 더하면" + phone.calculate(3, 5));
		phone.schedule();
	}
}

//인터페이스를 사용하는 가장 큰 이유는?
//객체가 다양한 자료형(타입)을 가질 수 있기 때문이다.
//클래스들이 그 기능을 서로 다르게 구현할 수 있도록 하는 클래스의 규격 선언이며,
//클래스의 다형성을 실현하는 도구이다. 
