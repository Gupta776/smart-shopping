package com.smartshopping.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity
@Table(name="user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	@NotNull
	private int id;
	@Column(name = "us_first_name")
	@NotNull
	private String firstName;
	@NotNull
	@Column(name = "us_last_name")
	private String lastName;
	@Column(name = "us_age")
	@NotNull
	private int age;
	@Column(name = "us_gender")
	@NotNull
	private String gender;
	@Column(name = "us_contact_number")
	@NotNull
	private long contactNumber;
	@Column(name = "us_user_id")
	@NotNull
	private String userName;
	@NotNull
	@Column(name = "us_password")
	private String password;
	@NotNull
	@Column(name = "us_user_type")
	private String userType;
	@NotNull
	@Column(name = "us_status")
	private String status;
	@NotNull
	@Column(name = "us_secret_question_1")
	private String secretQuestion1;
	@NotNull
	@Column(name = "us_secret_answer_1")
	private String secretAnswer1;
	@NotNull
	@Column(name = "us_secret_question_2")
	private String secretQuestion2;
	@NotNull
	@Column(name = "us_secret_answer_2")
	private String secretAnswer2;
	@NotNull
	@Column(name = "us_secret_question_3")
	private String secretQuestion3;
	@NotNull
	@Column(name = "us_secret_answer_3")
	private String secretAnswer3;
	@NotNull
	@Column(name="us_reward_points")
	private int finalRewardPoints;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "cart", joinColumns = @JoinColumn(name = "ct_us_id"), inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
//	private List<MenuItem> menuItemList;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(int id, String firstName, String lastName, int age, String gender, long contactNumber, String userName,
		String password, String userType, String status, String secretQuestion1, String secretAnswer1,
		String secretQuestion2, String secretAnswer2, String secretQuestion3, String secretAnswer3,
		int finalRewardPoints) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.gender = gender;
	this.contactNumber = contactNumber;
	this.userName = userName;
	this.password = password;
	this.userType = userType;
	this.status = status;
	this.secretQuestion1 = secretQuestion1;
	this.secretAnswer1 = secretAnswer1;
	this.secretQuestion2 = secretQuestion2;
	this.secretAnswer2 = secretAnswer2;
	this.secretQuestion3 = secretQuestion3;
	this.secretAnswer3 = secretAnswer3;
	this.finalRewardPoints = finalRewardPoints;
}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSecretQuestion1() {
		return secretQuestion1;
	}
	public void setSecretQuestion1(String secretQuestion1) {
		this.secretQuestion1 = secretQuestion1;
	}
	public String getSecretAnswer1() {
		return secretAnswer1;
	}
	public void setSecretAnswer1(String secretAnswer1) {
		this.secretAnswer1 = secretAnswer1;
	}
	public String getSecretQuestion2() {
		return secretQuestion2;
	}
	public void setSecretQuestion2(String secretQuestion2) {
		this.secretQuestion2 = secretQuestion2;
	}
	public String getSecretAnswer2() {
		return secretAnswer2;
	}
	public void setSecretAnswer2(String secretAnswer2) {
		this.secretAnswer2 = secretAnswer2;
	}
	public String getSecretQuestion3() {
		return secretQuestion3;
	}
	public void setSecretQuestion3(String secretQuestion3) {
		this.secretQuestion3 = secretQuestion3;
	}
	public String getSecretAnswer3() {
		return secretAnswer3;
	}
	public void setSecretAnswer3(String secretAnswer3) {
		this.secretAnswer3 = secretAnswer3;
	}
	
	public int getFinalRewardPoints() {
		return finalRewardPoints;
	}

	public void setFinalRewardPoints(int finalRewardPoints) {
		this.finalRewardPoints = finalRewardPoints;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender="
				+ gender + ", contactNumber=" + contactNumber + ", userName=" + userName + ", password=" + password
				+ ", userType=" + userType + ", status=" + status + ", secretQuestion1=" + secretQuestion1
				+ ", secretAnswer1=" + secretAnswer1 + ", secretQuestion2=" + secretQuestion2 + ", secretAnswer2="
				+ secretAnswer2 + ", secretQuestion3=" + secretQuestion3 + ", secretAnswer3=" + secretAnswer3
				+ ", finalRewardPoints=" + finalRewardPoints + "]";
	}

	
	
}
