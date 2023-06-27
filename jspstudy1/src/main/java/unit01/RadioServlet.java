package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RadioServlet() {
        super();   
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		//라디오 버튼을 활용한 변수는 묶음 처리됨
		String gender = request.getParameter("gender");
		String chk_mail= request.getParameter("chk_mail");
		String content = request.getParameter("content");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("당신이 입력한 정보입니다.<br>");
		out.print("성별 : <br>");
		out.print(gender);
		out.print("</b><br>메일 정보 수신 여부 : <b>");
		out.print(chk_mail);
		out.print("</b><br>가입 인사 : <b><pre>");
		out.print(content);
		out.print("</b></pre><a href='javascript:history.go(-1)'> 다시 </a>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
