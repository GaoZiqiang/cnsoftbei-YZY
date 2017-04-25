package cn.edu.sdut.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import cn.edu.sdut.msg.TextMessage;

public class MessageUtil {

	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";

	/**
	 * 
	 * xml转换成Map
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();

		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);

		Element root = doc.getRootElement();

		List<Element> list = root.elements();

		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}

	/**
	 * mesaage转换成xml
	 * 
	 * @param <T>
	 */
	public static String msgToXml(TextMessage message) {
		XStream xstream = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}

	/**
	 * event
	 */
	public static void msgDispatcher() {

	}

	// 拼接参数
	public static String initText(String toUserName, String fromUserName, String content) {
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);

		return msgToXml(text);
	}

	public static String commonText(String toUserName, String fromUserName, String content) {
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent("您发送的消息为: " + content);

		return msgToXml(text);
	}
	// 主菜单
	public static String menuText() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("欢迎您的关注!请按照菜单提示进行操作:\n\n");
		buffer.append("1.课程介绍\n");
		buffer.append("2.慕课网介绍\n");
		buffer.append("回复?调出此菜单");
		return buffer.toString();

	}

	// 菜单1
	public static String firstMenu() {
		StringBuffer buffer1 = new StringBuffer();
		buffer1.append("菜单一内容");
		return buffer1.toString();
	}

	// 菜单2
	public static String secondMenu() {
		StringBuffer buffer2 = new StringBuffer();
		buffer2.append("菜单二内容");
		return buffer2.toString();
	}

}
