<%@ page import = "utils.CookieManager" %>
<%@ page import = "utils.JSFunction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String save_check = request.getParameter("save_check");
	
	if("must".equals(user_id) && "1234".equals(user_pw)) {
		//로그인 성공
		if(save_check != null && save_check.equals("Y")) {
			CookieManager.makeCookie(response, "loginId", user_id, 86400);
		} //HttpServletResponse 객체, 생성할 쿠키의 이름, 쿠키에 저장할 값, 쿠키의 유효기간
		else{
			CookieManager.deleteCookie(response, "loginId");
		}
		JSFunction.alertLocation("로그인에 성공했습니다.", "idSaveMain.jsp", out);
		
	} else {
		//로그인 실패
		JSFunction.alertBack("로그인에 실패했습니다.", out);
	}
%>
