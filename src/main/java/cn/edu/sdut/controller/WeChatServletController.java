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

import cn.edu.sdut.msg.TextMessage;
import cn.edu.sdut.service.CheckUtil;
import cn.edu.sdut.service.CoreService;
import cn.edu.sdut.service.MessageUtil;

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
		try {
			Map<String,String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			if("text".equals(msgType)) {
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				text.setContent("您发送的消息是:" + content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
   

	}
}