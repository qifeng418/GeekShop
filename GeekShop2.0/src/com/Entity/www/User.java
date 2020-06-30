package com.Entity.www;

public class User {
	private String user_id;
	private String username;
	private String email;
	private String password;
	private String gender;
	private int age;
	private boolean activated;
	
	public User() {
		this.user_id = null;
		this.username = null;
		this.email = null;
		this.password = null;
		this.gender = null;
		this.age = 0;
		this.activated = true;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", age=" + age + ", activated=" + activated + "]";
	}
	
}
