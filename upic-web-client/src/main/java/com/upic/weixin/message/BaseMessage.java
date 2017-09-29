package com.upic.weixin.message;

public class BaseMessage {

	private String ToUserName; // ���շ����˺�
	private String FromUserName; // ���ͷ����˺�
	private long CreateTime; // ��Ϣ�Ĵ���ʱ��
	private String MsgType; // ��Ϣ����

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
