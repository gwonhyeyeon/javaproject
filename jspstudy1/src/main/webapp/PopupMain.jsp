<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String popupMode = "on"; //레이어 팝업 띄울지 여부 

Cookie[] cookies = request.getCookies();
if(cookies != null) {
	for(Cookie c : cookies){
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		if(cookieName.equals("PopupClose")){ //쿠키 이름 중에 "popupclose"와 같다면
			popupMode = cookieValue; // 팝업모드를 쿠키value값으로 바꾼다. 
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 팝업 관리 ver 0.1</title>
<style>
	div#popup {
		position : absolute; top: 100px; left : 50px; color: yellow;
		width: 270px; height: 100px; background-color : gray;
		
	}
	div#popup>div {
		position : relative; background-color: #ffffff; top: 0px;
		border: 1px solid gray; padding : 10px; color: black;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
 $(function() {
	 $('#closeBtn').click(function() {
		 $('#popup').hide();
		 var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
		 //chkVal 변수에는 input창 중에 checkbox id가 inactiveToday 인 곳에 체크가 되었을 때의
		 //value 값 "1"을 담는다.
		 $.ajax({ //비동기 처리 방식 이벤트 발생하자마자 바로 해당 jsp에 담겨있는 함수로 발동할 수 있도록 설정 
			 url : './PopupCookie.jsp', // popupCookie.jsp 로 넘어간다. 
			 type : 'get', // 전송 방식은 get 방식
			 data : {inactiveToday : chkVal},// 넘어가는 데이터는 inactiveToday와 chkVal에 담긴 value="1"
			 dataType : "text", // 데이터 타입은 text
			 success : function(resData) { 
				 if(resData != '') location.reload();
				 //요청을 성공받았을 때 넘어오는 데이터 값이 null값이 아니라면 reload()시킨다. 
			 }
		 });
	 });
 });
</script>
</head>
<body>
	<h2>팝업 메인 페이지(ver 0.1)</h2>
	<%
		for(int i=0; i<= 10; i++) {
			out.print("현재 팝업창은" + popupMode + "상태입니다.</br>");	
		} 
		if(popupMode.equals("on")){
			
		%>
		<div id="popup">
			<h2 align = "center">공지사항 팝업입니다.</h2>
			<div align = "right"><form name="popFrm">
				<input type="checkbox" id="inactiveToday" value="1" />
				 하루 동안 열지 않음
				<input type="button" value="닫기" id="closeBtn"  />
				</form></div>
			</div>
			<%	
		}
			%>
</body>
</html>