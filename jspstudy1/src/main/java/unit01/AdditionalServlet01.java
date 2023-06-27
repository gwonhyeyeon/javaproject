package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/AdditionalServlet01")
//@WebServlet : 해당 코드의 닉네임이 된다. 
//코드 파일명이 아닌 닉네임을 써서 코드에 대한 보안성도 높이고 
//페이지 명을 간단하게 표현할 수 있다. 
//이것을 URL Mapping 이라고 한다. 
public class AdditionalServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	//자동으로 추가 된 이 라인은 클래스를 구분하기 위한 값으로 사람에게는 주민번호 역할을 한다고 비유한다. 
	//객체의 직렬화와 같이 객체에 저장된 데이터를 일렬로 입출력할 때 
	//jvm은 같은 클래스 이름과 버전id를 가진 객체를 출력한다
	//jvm은 버전id가 다른 객체의 직렬화된 형태와 연결하는 것을 거부한다. 
	//클래스는 명시적으로 serialVersionUID필드를 정의해 클래스 버전에 따른 
	//고유번호를 포함하기 때문이다. 
    public AdditionalServlet01() {
        super();
    }
//Request는 전송받는 객체, Response는 다른 창으로 데이터를 전송해주는 객체 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//요청처리, 응답처리, 예외처리 인자로 넣어준 것이다. 
			int num1 = 20;
			int num2 = 10;
			int add = num1 + num2;
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Addition</title></head>");
			out.println("<body>");
			out.println(num1 + "+" + num2 + "=" + add);
			out.println("</body>");
			out.println("</html>");		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//	
//		doGet(request, response);
	}

}
