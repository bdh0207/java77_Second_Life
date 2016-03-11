package bitcamp.java77.domain;

import java.io.Serializable;

public class CosmeticSearch implements Serializable {
	protected int start;
	protected int end;
	
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
