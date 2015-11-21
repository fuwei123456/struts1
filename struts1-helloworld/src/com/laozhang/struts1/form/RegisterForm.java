package com.laozhang.struts1.form;

import org.apache.struts.action.ActionForm;

public class RegisterForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//添加一些页面属性
	private String user;
	private String pwd;
	private int gender; //1代表男， 0代表女
	private String email;
	private String[] hobbies; //字符串数组
	private String education; //学历
	private String introduce; //自我简介
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public RegisterForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterForm(String user, String pwd, int gender, String email,
			String[] hobbies, String education, String introduce) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.gender = gender;
		this.email = email;
		this.hobbies = hobbies;
		this.education = education;
		this.introduce = introduce;
	}
	
	

}
