<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String chkVal = request.getParameter("inactiveToday");
    
    if( chkVal != null && chkVal.equals("1")) {  //인풋 체크박스에 체크가 되면서 넘어온 value값 1이 들어오면 
    	Cookie cookie = new Cookie("PopupClose", "off"); //쿠키 생성 "popupClose"이름의 쿠키를 생성 
    	cookie.setPath(request.getContextPath()); //경로 설정
    	cookie.setMaxAge(60*60*24); //유지 기간 설정
    	response.addCookie(cookie); //응답객체에 추가 
    	out.println("쿠키 : 하루 동안 열지 않음");
    }
    %>
