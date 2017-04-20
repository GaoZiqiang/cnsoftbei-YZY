package cn.edu.sdut.service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;

import cn.edu.sdut.msg.ImageMessage;
import cn.edu.sdut.msg.TextMessage;

public class CoreService {

	// 文本消息处理器
	public static String processRequest(HttpServletRequest request) throws IOException {
		return CoreService.textMsgDispatcher(request);
	}

	//文本消息处理
	public static String textMsgDispatcher(HttpServletRequest request) throws IOException {
		String message = null;
		Map<String, String> map;
		try {
			// 获取来自client的消息
			map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

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

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	//图片消息处理
	public static String imageMsgDispatcher(HttpServletRequest request) {
		String message = null;
		Map<String, String> map;
		try {
			// 获取来自client的消息
			map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
            String mediaId = map.get("mediaId");
            String picUrl = map.get("picUrl");
            String msgId = map.get("msgId");
			if ("text".equals(msgType)) {
				ImageMessage image = new ImageMessage();
				image.setFromUserName(toUserName);
				image.setToUserName(fromUserName);
				image.setMsgType("image");
				image.setCreateTime(new Date().getTime());
				image.setMediaId(mediaId);
				image.setPicUrl(picUrl);
				image.setMsgId(msgId);
				if (content.equals("高晗")) {
					image.setContent("高晗 is a good boy");
				} else {
					image.setContent("您发送的消息是:" + content);
				}

				message = MessageUtil.msgToXml(image);// message来接收,为什么不行?
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return message;
	}
}
