package bitcamp.java77.domain;

import java.util.Date;

public class CosmeticQnA {
	protected int qNo;
	protected int mNo;
	protected String title;
	protected String content;
	protected String qPart;
	protected Date regDate;
	
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getqPart() {
		return qPart;
	}
	public void setqPart(String qPart) {
		this.qPart = qPart;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
