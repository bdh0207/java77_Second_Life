package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;

public class CosmeticCounsel implements Serializable {
	protected int hospitalNo;
	protected String name;
	protected int age;
	protected String tel;
	protected String surgeryWay;
	protected String content;
	protected String email;
	protected Date regDate;
	
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final int getHospitalNo() {
		return hospitalNo;
	}
	public final void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public final String getSurgeryWay() {
		return surgeryWay;
	}
	public final void setSurgeryWay(String surgeryWay) {
		this.surgeryWay = surgeryWay;
	}
	public final Date getRegDate() {
		return regDate;
	}
	public final void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
