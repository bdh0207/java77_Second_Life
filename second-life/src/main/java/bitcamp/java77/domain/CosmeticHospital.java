package bitcamp.java77.domain;

import java.util.Date;

public class CosmeticHospital {
	protected int hospitalNo;
	protected String name;
	protected String surgeryPart;
	protected String content;
	protected String addr;
	protected String tel;
	protected String link;
	protected Date regDate;
	public int getHospitalNo() {
		return hospitalNo;
	}
	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurgeryPart() {
		return surgeryPart;
	}
	public void setSurgeryPart(String surgeryPart) {
		this.surgeryPart = surgeryPart;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}