package cn.edu.sdut.controller;

/**
*获取值
*/
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeChatServletController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("打印req:" + req.toString());
		//String signature = req.getParameter("signature");//该signature来自微信服务器
		//String timestamp = req.getParameter("timestamp");
		//String nonce = req.getParameter("nonce");
		//String echostr = req.getParameter("echostr");

		//打印输出signature
		//System.out.println("ServletController中signature:" + signature.toString());
		//System.out.println("ServletController中timestamp:" + timestamp.toString());
		//System.out.println("ServletController中nonce:" + nonce.toString());
		//System.out.println("ServletController中echostr:" + echostr.toString());
		// 调用逻辑验证
	}
}