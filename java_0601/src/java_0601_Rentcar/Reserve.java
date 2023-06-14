package java_0601_Rentcar;


import java.time.LocalDate;
import java.util.Scanner;

public class Reserve {

	private String resCarNumber;
	private String useBeginDate;
	private String returnDate;
	LocalDate now = LocalDate.now();
	
	public void reserveCar() {
		Scanner scannerCar = new Scanner(System.in);
		System.out.println("차종을 고르세요(아반떼/소나타/k8/k5/쏘렌토)");
		resCarNumber = scannerCar.next();
		System.out.println("시작일자를 선택하세요(yyyy-mm-dd)");
		useBeginDate = scannerCar.next();
		String regex = "^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])";

		boolean check = useBeginDate.matches(regex);

		if (check == false) {
			System.out.println("입력 된 날짜는 형식에 맞지 않습니다.");			
		} else {
			System.out.println("종료일자를 선택하세요(yyyy-mm-dd)");
		}
				
		returnDate = scannerCar.next();
		
		boolean check1 = returnDate.matches(regex);
		
		if (check1 == false) {
			System.out.println("입력 된 날짜는 형식에 맞지 않습니다.");		
		} 
		
		if( check == false || check1 == false) {
			System.out.println("작성 된 날짜 형식이 맞지 않습니다. 다시 입력하세요");
			
		}else {
			System.out.println(resCarNumber + "가" + useBeginDate + "부터" + returnDate + "까지 예약 완료 되었습니다.");
			System.out.println("예약날짜 : " + now);
		}
		
	}

	public void modReserveInfo() {
		Scanner scannerCar = new Scanner(System.in);
		System.out.println("수정하시겠습니까?(Y/N)");
		String selectedAnswer = scannerCar.next();
		if(selectedAnswer.equalsIgnoreCase("y")){
			
			System.out.println("차종을 고르세요(아반떼/소나타/k8/k5/쏘렌토)");
			resCarNumber = scannerCar.next();
			System.out.println("시작일자를 선택하세요(yyyy-mm-dd)");
			useBeginDate = scannerCar.next();
			String regex = "^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])";

			boolean check = useBeginDate.matches(regex);

			if (check == false) {
				System.out.println("입력 된 날짜는 형식에 맞지 않습니다.");
			} else {
				System.out.println("종료일자를 선택하세요(yyyy-mm-dd)");
			}
			returnDate = scannerCar.next();
			
			boolean check1 = returnDate.matches(regex);
			
			if (check1 == false) {
				System.out.println("입력 된 날짜는 형식에 맞지 않습니다.");
			} 
			if( check == false || check1 == false) {
				System.out.println("작성 된 날짜 형식이 맞지 않습니다. 다시 입력하세요");
				
			}else {
				System.out.println(resCarNumber + "가" + useBeginDate + "부터" + returnDate + "까지 예약 수정 완료되었습니다.");
				System.out.println("예약날짜 : " + now);
			}		
		}
	}
	public void cancelReserveInfo() {
		System.out.println("예약이 취소되었습니다.");
	}

}
