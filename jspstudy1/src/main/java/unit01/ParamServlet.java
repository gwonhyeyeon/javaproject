package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//매핑 지정하고, 새로운 매핑이 설정되면 기존 매핑은 주석처리 하도록 하자
//@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParamServlet() {
		super();
	}
//response : 응답(리턴값) request : 요청
//doGet 메소드만 활용
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/html;charset=UTF-8");
	response.getWriter().append("Served at: ").append(request.getContextPath());
//response 변수 UTF-8 적용
//request 객체에 실려온 데이터를 획득하는 메소드 getParameter("id")
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
//int 변수 언박싱
		PrintWriter out = response.getWriter();
//stream 객체생성, 응답값 읽어들임
		out.print("<html><body>");
		out.println("당신이 입력한 정보입니다.<br>");
		out.println("아이디 : ");
		out.println(id);
		out.println("<br>나 이 : ");
		out.println(age);
//자바스크립트로 부터 이전 페이지로 이동하는 링크를 만들어 줌
//javascript:history.go(-1) 이게 이전 페이지로 돌아가는 명령어인듯
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
