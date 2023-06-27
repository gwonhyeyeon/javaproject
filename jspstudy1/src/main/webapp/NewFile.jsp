<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %>

<% Connection conn = null;

String driver = "oracle.jdbc.driver.OracleDriver";

String url = "jdbc:oracle:thin:@localhost:1521:xe";

Boolean connect = false;

try {

 Class.forName(driver);
 conn = DriverManager.getConnection(url, "scott", "tiger");
 
 connect = true;


 conn.close();
 } catch(Exception e) {
	 connect = false;
	 e.printStackTrace();
 }
 
 %>
 <% 
 if(connect == true) {
	 %>
  	연결되었습니다.	
  <% 
  	} else {
  	%>
  	연결에 실패하였습니다.
  <% 
  
  }
  %>
  
<!--   
 show user;

-- 실습할 계정을 만들었습니다.
select * from tab;
-- 작성된 테이블 목록 확인

-- DUAL 테이블이란?
-- DUAL 테이블을 바로 산술 연산의 결과를 한 줄로 얻기 위해서 오라클에서
-- 제공하는 테이블이다.
SELECT * FROM DUAL;
-- dual 테이블은 사용자가 함수(계산)를 실행할 때 임시로 사용하는데 적합
-- 함수에 대한 쓰임을 알고 싶을 때 특정 테이블을 생성할 필요없이 dual 테이블을
-- 이용하여 함수의 값을 return 받을 수 있다. -->