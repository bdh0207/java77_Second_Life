package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CosmeticEvent implements Serializable {
	protected int eventNo;
	protected int hospitalNo;
	protected String title;
	protected String content;
	protected int viewCnt;
	protected Date regDate;
	protected List<CosmeticEventPhoto> eventPhoto;
	protected List<CosmeticMember> member;
	protected String hospitalName;
	
	public final String getHospitalName() {
		return hospitalName;
	}
	public final void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public final int getEventNo() {
		return eventNo;
	}
	public final List<CosmeticEventPhoto> getEventPhoto() {
		return eventPhoto;
	}
	public final void setEventPhoto(List<CosmeticEventPhoto> eventPhoto) {
		this.eventPhoto = eventPhoto;
	}
	public final List<CosmeticMember> getMember() {
		return member;
	}
	public final void setMember(List<CosmeticMember> member) {
		this.member = member;
	}
	public final void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public final int getHospitalNo() {
		return hospitalNo;
	}
	public final void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final int getViewCnt() {
		return viewCnt;
	}
	public final void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public final Date getRegDate() {
		return regDate;
	}
	public final void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
