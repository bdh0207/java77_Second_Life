package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CosmeticWish implements Serializable {
	protected int wishNo;
	protected int reviewNo;
	protected int memberNo;
	protected String memberId;
	protected String title;
	protected String content;
	protected int viewCnt;
	protected Date regDate;
	protected List<CosmeticReviewPhoto> reviewPhoto;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public List<CosmeticReviewPhoto> getReviewPhoto() {
		return reviewPhoto;
	}
	public void setReviewPhoto(List<CosmeticReviewPhoto> reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}
	public int getWishNo() {
		return wishNo;
	}
	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
