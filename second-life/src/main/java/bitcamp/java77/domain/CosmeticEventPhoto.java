package bitcamp.java77.domain;

import java.io.Serializable;

public class CosmeticEventPhoto implements Serializable {
	protected int eventPhotoNo;
	protected int eventNo;
	protected String filePath;
	
	public final int getEventPhotoNo() {
		return eventPhotoNo;
	}
	public final void setEventPhotoNo(int eventPhotoNo) {
		this.eventPhotoNo = eventPhotoNo;
	}
	public final int getEventNo() {
		return eventNo;
	}
	public final void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public final String getFilePath() {
		return filePath;
	}
	public final void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
