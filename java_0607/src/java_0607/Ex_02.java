package java_0607;

interface Repairable {
	
}
//유닛이 갖는 공통 성질을 가진 최상위 클래스 
class Unit {
	int hitPoint;
	final int MAX_HP;
    /*Reparable*/ String u;
    
    Unit(int hp){
    	MAX_HP = hp;
    	//System.out.println(hp);
    }
}
//유닛의 큰 범주를 나누는 클래스 
class GroundUnit extends Unit {
	public GroundUnit(int hp) {
		super(hp);
	}
}
//유닛의 큰 범주를 나누는 클래스 
class AirUnit extends Unit{
	public AirUnit(int hp) {
		super(hp);
	}
}
//세부 유닛 클래스
//상위 클래스의 성질을 상속 받음
class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
		}
	@Override
	public String toString() {
		return "Tank";
	}
}
//세부 유닛 클래스, 상위 클래스의 성질을 상속 받음
class Marine extends GroundUnit{
	public Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
}
//세부 유닛 클래스 
class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	//repair라는 세부동작이 추가 되어있다. 
	void repair(Repairable r) {
		//Unit name = new Unit(r);
		//instanceof 현재 레퍼런스가 어떤 클래스형의 객체 주소를 참조하고 있는 지 
		//알고 싶을 때 사용
		if(r instanceof Unit) {//r이 unit 타입의 인스턴스를 가리키는 경우 true
			//아닌 경우 false를 반환한다. 
			Unit u = (Unit) r; //r이 가르키는 객체를 unit타입으로 캐스팅한다
			//r이 unit타입의 객체를 가리키는 경우에만 r을 unit으로 캐스팅하여 u에 할당하도록 하고
			//그렇지 않으면 아무것도 안한다 이는 r이 unit일 경우에만 특정작업을 수행한다는 말이다.
			
			while(u.hitPoint != u.MAX_HP) {
				u.hitPoint++;
			}
		//System.out.println("Tank 수리 완료");
			System.out.println(u.toString()+ "수리완료");
		}
	}
}
public class Ex_02 {
	public static void main(String[] args) {
		//각 유닛의 객체 생성
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		//scv에 있는 repair 동작 수행
		//r객체 변수 tank는 Repairable 인터페이스에 의해 동작이 일어나야 하는데
		//본 코드는 이러한 동작이 없으므로 아무 일도 발생한다. 않는다. 
		scv.repair(tank);
		//System.out.println(tank);
		System.out.println("Tank의 hp: " + tank.MAX_HP);
		System.out.println("Marine의 hp: " + marine.MAX_HP);
		System.out.println("SCV의 hp: " + scv.MAX_HP);
	}
}
