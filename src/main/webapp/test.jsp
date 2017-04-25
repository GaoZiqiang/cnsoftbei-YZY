<%@ page import="javax.naming.*"%>
<%@ page import="Java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/");
DataSource ds = (DataSource)envContext.lookup("jdbc/YZYWeiXinDS");
Connection conn = ds.getConnection();
conn.close();
%>