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
import cn.edu.sdut.service.MessageUtil;

public class WeChatServletController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");//该signature来自微信服务器
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		//打印输出signature
		System.out.println("ServletController中signature:" + signature.toString());
		System.out.println("ServletController中timestamp:" + timestamp.toString());
		System.out.println("ServletController中nonce:" + nonce.toString());
		System.out.println("ServletController中echostr:" + echostr.toString());
		// 调用逻辑验证
		PrintWriter out = resp.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.println(echostr);//返回微信服务器
		}
		out.close();
		out = null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		try {
			Map<String,String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message = null;
			if("text".equals(msgType)) {
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				text.setContent("您发送的消息是:" + content);
				message = MessageUtil.msgToXml(text);
			}
			out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
		
   

	}
}