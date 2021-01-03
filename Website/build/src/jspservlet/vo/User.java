package jspservlet.vo;

public class User {
	private String username;
	private String password;
	private String password1;
	private String paypassword;
	private String email;
	private String loginstate;
	public String getPaypassword() {
		return paypassword;
	}
	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}
	public String getLoginstate() {
		return loginstate;
	}
	public void setLoginstate(String loginstate) {
		this.loginstate = loginstate;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
