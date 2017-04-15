package cn.edu.sdut.servlet;

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

import cn.edu.sdut.po.TextMessage;
import cn.edu.sdut.util.CheckUtil;
import cn.edu.sdut.util.MessageUtil;

public class WeChatServlet extends HttpServlet {
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
				text.setContent("您发送的消息是:" + content);
				message = MessageUtil.textMessageToXml(text);// message来接收
			}
			out.println(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}
}
