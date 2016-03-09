package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CosmeticReview implements Serializable {
	protected int reviewNo;
	protected int memberNo;
	protected int hospitalNo;
	protected String title;
	protected String content;
	protected int viewCnt;
	protected String sugeryPart;
	protected char status;
	protected Date regDate;
	protected List<CosmeticReviewPhoto> reviewPhoto;
	
	public List<CosmeticReviewPhoto> getReviewPhoto() {
		return reviewPhoto;
	}
	public void setReviewPhoto(List<CosmeticReviewPhoto> reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
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
	public int getHospitalNo() {
		return hospitalNo;
	}
	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
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
	public String getSugeryPart() {
		return sugeryPart;
	}
	public void setSugeryPart(String sugeryPart) {
		this.sugeryPart = sugeryPart;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
