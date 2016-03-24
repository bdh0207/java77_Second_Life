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
	protected int recomCnt;
	protected String sugeryPart;
	protected char status;
	protected String hospitalName;
	protected String doctorName;
	protected String sugeryWay;
	protected int sugeryPrice;
	protected Date sugeryDate;
	protected Date regDate;
	protected List<CosmeticReviewPhoto> reviewPhoto;
	protected List<CosmeticReviewComment> reviewComment;
	protected CosmeticMember member;
	
	public int getRecomCnt() {
		return recomCnt;
	}
	public void setRecomCnt(int recomCnt) {
		this.recomCnt = recomCnt;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSugeryWay() {
		return sugeryWay;
	}
	public void setSugeryWay(String sugeryWay) {
		this.sugeryWay = sugeryWay;
	}
	public int getSugeryPrice() {
		return sugeryPrice;
	}
	public void setSugeryPrice(int sugeryPrice) {
		this.sugeryPrice = sugeryPrice;
	}
	public Date getSugeryDate() {
		return sugeryDate;
	}
	public void setSugeryDate(Date sugeryDate) {
		this.sugeryDate = sugeryDate;
	}
	
	public CosmeticMember getMember() {
		return member;
	}
	public void setMember(CosmeticMember member) {
		this.member = member;
	}
	public List<CosmeticReviewComment> getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(List<CosmeticReviewComment> reviewComment) {
		this.reviewComment = reviewComment;
	}
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
