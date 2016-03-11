package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;

public class CosmeticReviewRecom implements Serializable {
	protected int reviewRecomNo;
	protected int memberNo;
	protected int reviewNo;
	protected Date regDate;
	
	public int getReviewRecomNo() {
		return reviewRecomNo;
	}
	public void setReviewRecomNo(int reviewRecomNo) {
		this.reviewRecomNo = reviewRecomNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
