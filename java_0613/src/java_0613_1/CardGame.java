package java_0613_1;

public class CardGame {

	public static void main(String[] args) {
//Deck객체를 생성하고
		//Deck기본 생성자를 실행하면, for문을 활용해 카드 정보들이 저장된다. 
		Deck deck = new Deck();
		//객체를 활용해 shuffle 메소드를 실행한다, 랜덤으로 저장된 값 중 하나를 획득함
		deck.shuffle();
		//카드를 획득하는 Player객체 생성
		Player p1 = new Player();
		Player p2 = new Player();
		
		//getcard메소드를 실행해 덱에서 카드 정보를 arraylist 객체에 저장함. 
		//get카드는 카드를 가져온다, 추출한다.
		//get카드가 이미 메소드 그럼 getcard.안에 들어있는 매개변수는 뭐를 가리키는 건가?
		//deck 객체가 있는 클래스의 deal메소드를 살펴보자
		p1.getCard(deck.deal());
		p2.getCard(deck.deal());
		p1.showCards();
		p2.showCards();
	}//키보드로 입력 System.in InputStreamReader(문자) BufferedReader..readLine()
}//system.out.출력하기 
//-> BufferedReader ...readLine() -> System.out 출력하기 

