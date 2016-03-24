package bitcamp.java77.domain;

import java.io.Serializable;

public class CosmeticSearch implements Serializable {
	protected int start;
	protected int end;
	protected int reviewNo;
	protected int eventNo;
	public static String wordType;
	
	public static String getWordType() {
		return wordType;
	}
	public static void setWordType(String wordType) {
		CosmeticSearch.wordType = wordType;
	}
	public final int getEventNo() {
		return eventNo;
	}
	public final void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
