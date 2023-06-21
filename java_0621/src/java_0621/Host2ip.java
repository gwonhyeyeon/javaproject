package java_0621;
//01
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Host2ip {

	public static void main(String[] args) throws IOException{
		String hostname = "www.naver.com";
		//www문자열을 hostname변수이름 선언
		try {//네이버주소를 주소클래스에 담아서 address에 대입
			InetAddress address = InetAddress.getByName(hostname);
			//InetAddress아이피 주소를 표현하는 클래스 
			System.out.println("IP주소 : " + address.getHostAddress());
			//address만 입력하면 www.아이피주소 같이나오지만
			//getHost 같이 사용하면 아이피주소만 나옴		
		} catch (UnknownHostException e) {
			System.out.println(hostname + "의 IP주소를 찾을 수 없습니다. ");
		}
	}
}//www주소가 없는 경우 출력 InetAddress를 사용안헀기 때문 
