package java_0601_Rentcar;

public class RentTest {

	public static void main(String[] args) {
		
		//회원가입하기
		Member member = new Member();
		member.member_main();
		
		
		//렌트카를 조회한다.
		//Car car = new Car();
		//car.checkCarInfo();
			
		//예약을 한다
		Reserve reserve = new Reserve();
		reserve.reserveCar();
		//reserve.modReserveInfo();
		//reserve.cancelReserveInfo();
	}

}
