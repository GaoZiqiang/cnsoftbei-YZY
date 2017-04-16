package cn.edu.sdut.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import cn.edu.sdut.msg.ImageMessage;
import cn.edu.sdut.msg.TextMessage;

public class ImageMsgUtil {
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
	 * @Description: 图片消息对象转换成xml
	 * @param @param
	 *            imageMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016年3月9日 上午9:25:51
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	public static void imageDispatcher(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}
