package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;

public class CosmeticMember implements Serializable {
	protected int memberNo;
	protected String id;
	protected String pwd;
	protected String name;
	protected String email;
	protected String gender;
	protected int birrh;
	protected String posNo;
	protected String addrDef;
	protected String addrDet;
	protected String tel;
	protected String cPart;
	protected char recEmail;
	protected String cont;
	protected Date regDate;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getBirrh() {
		return birrh;
	}
	public void setBirrh(int birrh) {
		this.birrh = birrh;
	}
	public String getPosNo() {
		return posNo;
	}
	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}
	public String getAddrDef() {
		return addrDef;
	}
	public void setAddrDef(String addrDef) {
		this.addrDef = addrDef;
	}
	public String getAddrDet() {
		return addrDet;
	}
	public void setAddrDet(String addrDet) {
		this.addrDet = addrDet;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getcPart() {
		return cPart;
	}
	public void setcPart(String cPart) {
		this.cPart = cPart;
	}
	public char getRecEmail() {
		return recEmail;
	}
	public void setRecEmail(char recEmail) {
		this.recEmail = recEmail;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
