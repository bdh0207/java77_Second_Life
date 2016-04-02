package bitcamp.java77.domain;

import java.io.Serializable;

public class CosmeticCounselPhoto implements Serializable {
	protected int counselPhotoNo;
	protected int counselNo;
	protected String filePath;
	
	public final int getCounselPhotoNo() {
		return counselPhotoNo;
	}
	public final void setCounselPhotoNo(int counselPhotoNo) {
		this.counselPhotoNo = counselPhotoNo;
	}
	public final int getCounselNo() {
		return counselNo;
	}
	public final void setCounselNo(int counselNo) {
		this.counselNo = counselNo;
	}
	public final String getFilePath() {
		return filePath;
	}
	public final void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
