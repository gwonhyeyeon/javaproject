package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
//request->jsp에서 전달받는 변수값
		PrintWriter out = response.getWriter();
//response -> 출력값
		out.print("<html><body>");
		out.println("당신이 입력한 정보입니다.<br>");
		out.println("아이디 : ");
		out.println(id);
		out.println("<br> 비밀번호 : ");
		out.println(pwd);
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
//뒤로가기
		out.print("</body></html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
/*
 * request.getParameter() 웹(Web) 환경은 HTTP 프로토콜 위에서 동작하고 있다. 
 * HTTP 프로토콜이란? 클라이언트가 서버에 무언가 (보통 웹페이지)를 요청(request)하면, 
 * 서버가 이 요청에 해당하는 것을 응답(response) 해주는 구조로 되어있다.
 * 
 * HTTP가 요청을 보낼 때 , 파라미터를 함께 끼워 보낼 수 있다. 
 * 예를들어 로그인 할 때 로그인 폼(form : 양식)을 입력하고 버튼을 누른다. 
 * 그러면 HTTP 요청 안에 폼 내용이 함께 끼워져서 서버로 날라가게 되는 것! 
 * 로그인 폼 내용이 바로 , HTTP 요청의 파라미터(Parameter)가 되는 것이다.
 * 
 * HTTP 요청의 파라미터 값을 얻기 위해서 사용하는 것이 바로 request.getParameter()
 *  메소드이다. 가령, 
 *  로그인 폼에 id를 입력하는 <input type = “text” name=“id”>가 있다면 
 *  서블릿에서 String id = request.getParameter(“id”)와 같은 방식으로, 
 *  클라이언트가 입력한 ID가 뭐였는지 알아낼 수 있다.
 * 
 * 로그인에 성공했다면 클라이언트의 회원 정보를 DB에 읽어서 페이지에 뿌려줘야한다. 
 * 그러려면 서블릿은 회원 정보를 JSP에게 보내줘야 하는데
 * 어떻게?? 바로 다른 곳으로 정보를 넘겨주기 위해 
 * request 객체의 속성(attribute)를 사용한다. 
 * 가령, 회원정보 중에서 '취미'를 JSP에게 넘겨주기 위해서, 
 * 서블릿에서 request.setAttribute("hobby", strHobby); 로 속성을 집어넣고, 
 * JSP에서 <% String strHobby = (String)request.getAttribute("hobby"); %> 
 * <% String hobby = (String)request.getAttribute("hobby"); %> 
 *  로 속성을 얻는 것
 */



