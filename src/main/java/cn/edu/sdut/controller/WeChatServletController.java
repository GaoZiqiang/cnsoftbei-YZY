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

import cn.edu.sdut.msg.TextMessage;
import cn.edu.sdut.service.CheckUtil;
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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 设置一下相应的格式
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();// 获取resq的数据流
		Map<String, String> map;
		try {
			// 获取来自client的消息
			map = MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

			String message = null;
			if ("text".equals(msgType)) {
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				if (content.equals("高晗")) {
					text.setContent("高晗 is a good boy");
				} else {
					text.setContent("您发送的消息是:" + content);
				}

				message = MessageUtil.msgToXml(text);// message来接收,为什么不行?
			}
			out.println(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}
}
