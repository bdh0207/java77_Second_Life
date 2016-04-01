package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;

public class CosmeticCounsel implements Serializable {
	protected int counselNo;
	protected int hospitalNo;
	protected int memberNo;
	protected String name;
	protected int age;
	protected String surgeryPart;
	protected String tel;
	protected String content;
	protected int groupNo;
	protected Date regDate;
	protected String email;
	 
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final int getCounselNo() {
		return counselNo;
	}
	public final void setCounselNo(int counselNo) {
		this.counselNo = counselNo;
	}
	public final int getHospitalNo() {
		return hospitalNo;
	}
	public final void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public final int getMemberNo() {
		return memberNo;
	}
	public final void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}
	public final String getSurgeryPart() {
		return surgeryPart;
	}
	public final void setSurgeryPart(String surgeryPart) {
		this.surgeryPart = surgeryPart;
	}
	public final String getTel() {
		return tel;
	}
	public final void setTel(String tel) {
		this.tel = tel;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final int getGroupNo() {
		return groupNo;
	}
	public final void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public final Date getRegDate() {
		return regDate;
	}
	public final void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
