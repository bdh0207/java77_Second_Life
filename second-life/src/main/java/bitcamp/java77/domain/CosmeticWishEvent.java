package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;

public class CosmeticWishEvent implements Serializable {
	protected int wishNo;
	protected int eventNo;
	protected int memberNo;
	protected Date regDate;
	
	public final int getWishNo() {
		return wishNo;
	}
	public final void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}
	public final int getEventNo() {
		return eventNo;
	}
	public final void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public final int getMemberNo() {
		return memberNo;
	}
	public final void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public final Date getRegDate() {
		return regDate;
	}
	public final void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
