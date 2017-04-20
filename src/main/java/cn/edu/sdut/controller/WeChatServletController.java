package cn.edu.sdut.controller;

/**
*获取值
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import cn.edu.sdut.service.CheckUtil;
import cn.edu.sdut.service.CoreService;

public class WeChatServletController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		// 调用逻辑验证
		PrintWriter out = resp.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.println(echostr);
		}
		out.close();
		out = null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        PrintWriter out = response.getWriter();// 获取resq的数据流
  
        // 调用核心业务类接收消息、处理消息  
        String respMessage = CoreService.processRequest(request);  
          
        // 响应消息  
        
        out.print(respMessage);  
        out.close();  
   

	}
}
