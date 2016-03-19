package bitcamp.java77.domain;

import java.io.Serializable;

public class CosmeticCounsel implements Serializable {
	protected String name;
	protected int age;
	protected String tel;
	protected String sway;
	protected String content;
	
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
	public String getSway() {
		return sway;
	}
	public void setSway(String sway) {
		this.sway = sway;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
