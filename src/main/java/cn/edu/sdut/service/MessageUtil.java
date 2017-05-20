package cn.edu.sdut.service;

import java.io.IOException;
import java.io.InputStream;
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
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException {

		Map<String, String> map = new HashMap<String, String>();
		InputStream inputStream;
		SAXReader reader;
		try {
			inputStream = request.getInputStream();
			reader = new SAXReader();
			Document doc = reader.read(inputStream);
			org.dom4j.Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for (Element e : list) {
				map.put(e.getName(), e.getText());
			}
			inputStream.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static String msgToXml(TextMessage textMessage) {
		XStream xstream = new XStream();
		return xstream.toXML(textMessage);

	}
}
