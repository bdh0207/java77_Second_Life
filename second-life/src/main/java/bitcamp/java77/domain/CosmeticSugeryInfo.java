package bitcamp.java77.domain;

import java.io.Serializable;
import java.util.Date;

public class CosmeticSugeryInfo implements Serializable {
	protected int sugeryNo;
	protected int wishNo;
	protected String hospitalName;
	protected String doctorName;
	protected String sugeryWay;
	protected int sugeryPrice;
	protected String sugeryPart;
	protected Date sugeryDate;
	protected Date regDate;
	
	
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public int getSugeryNo() {
		return sugeryNo;
	}
	public void setSugeryNo(int sugeryNo) {
		this.sugeryNo = sugeryNo;
	}
	public int getWishNo() {
		return wishNo;
	}
	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
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
	public String getSugeryPart() {
		return sugeryPart;
	}
	public void setSugeryPart(String sugeryPart) {
		this.sugeryPart = sugeryPart;
	}
	public Date getSugeryDate() {
		return sugeryDate;
	}
	public void setSugeryDate(Date sugeryDate) {
		this.sugeryDate = sugeryDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
