package cn.edu.sdut.wx4j;

import java.util.Map;

import cn.zr.wx4j.model.menu.Menu;
import cn.zr.wx4j.model.receiveEvent.ReceiveClickMenuEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveLocationEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveLocationSelectEvent;
import cn.zr.wx4j.model.receiveEvent.ReceivePicEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveScanCodeEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveScanEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveViewMenuEvent;
import cn.zr.wx4j.model.receiveMsg.ReceiveImageMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveLinkMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveLocationMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveShortvideoMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveTextMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveVideoMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveVoiceMessage;
import cn.zr.wx4j.open.AbstractWxAdapter;
import cn.zr.wx4j.util.MenuUtils;

public class WxAdapterImpl extends AbstractWxAdapter {
	public Menu initMenu() {
		System.out.println("on create menu");
		return MenuUtils.getSampleMenu();
	}

	public void onReceiveText(ReceiveTextMessage message) {
		System.out.println("onReceiveTextMessage");
	}

	public void onReceiveVoice(ReceiveVoiceMessage message) {
		System.out.println("onReceiveVoice");
	}

	public void onReceiveImage(ReceiveImageMessage message) {
		System.out.println("onReceiveImage");

	}

	public void onClickMenuEvent(ReceiveClickMenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onLocationEvent(ReceiveLocationEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onLocationSelectEvent(ReceiveLocationSelectEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onMassSendJobFinishEvent(Map<String, String> arg0) {
		// TODO Auto-generated method stub

	}

	public void onPicPhotoOrAlbumnEvent(ReceivePicEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onPicSysPhotoEvent(ReceivePicEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onPicWeixinEvent(ReceivePicEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onReceiveLink(ReceiveLinkMessage arg0) {
		// TODO Auto-generated method stub

	}

	public void onReceiveLocation(ReceiveLocationMessage arg0) {
		// TODO Auto-generated method stub

	}

	public void onReceiveShortvideo(ReceiveShortvideoMessage arg0) {
		// TODO Auto-generated method stub

	}

	public void onReceiveVideo(ReceiveVideoMessage arg0) {
		// TODO Auto-generated method stub

	}

	public void onScanCodePushEvent(ReceiveScanCodeEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onScanCodeWaitMsgEvent(ReceiveScanCodeEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onScanWithSubscribeEvent(ReceiveScanEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onScanWithSubscribedEvent(ReceiveScanEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onSubscriptionEvent(ReceiveEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onUnSubscriptionEvent(ReceiveEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void onViewMenuEvent(ReceiveViewMenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	// 还有很多方法暂不列出
}