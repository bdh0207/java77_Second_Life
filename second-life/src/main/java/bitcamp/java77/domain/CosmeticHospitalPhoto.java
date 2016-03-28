package bitcamp.java77.domain;

import java.io.Serializable;

public class CosmeticHospitalPhoto implements Serializable {
	protected int hospitalPhotoNo;
	protected int hospitalNo;
	protected String filePath;
	
	public final int getHospitalPhotoNo() {
		return hospitalPhotoNo;
	}
	public final void setHospitalPhotoNo(int hospitalPhotoNo) {
		this.hospitalPhotoNo = hospitalPhotoNo;
	}
	public final int getHospitalNo() {
		return hospitalNo;
	}
	public final void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	public final String getFilePath() {
		return filePath;
	}
	public final void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
