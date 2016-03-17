package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CosmeticReviewComment implements Serializable {
	protected int commentNo;
	protected int reviewNo;
	protected int memberNo;
	protected String content;
	protected Date regDate;
	protected List<CosmeticMember> member;
	
	public List<CosmeticMember> getMember() {
		return member;
	}
	public void setMember(List<CosmeticMember> member) {
		this.member = member;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
