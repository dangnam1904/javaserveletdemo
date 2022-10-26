package jweb.p.a101.model;

import java.time.LocalDate;

public class Member {
	private int id;
	String firstName,lastName,useName,password, phone, email,description;
	LocalDate createDate, updateTime;
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
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDate getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", useName=" + useName
				+ ", password=" + password + ", phone=" + phone + ", email=" + email + ", description=" + description
				+ ", createDate=" + createDate + ", updateTime=" + updateTime + "]";
	}
	/**
	 * @param useName
	 * @param password
	 */
	public Member(String useName, String password) {
		this.useName = useName;
		this.password = password;
	}
	/**
	 * 
	 */
	public Member() {
	}
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param useName
	 * @param password
	 * @param phone
	 * @param email
	 * @param description
	 * @param updateTime
	 */
	public Member(int id, String firstName, String lastName, String useName, String password, String phone,
			String email, String description, LocalDate updateTime) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.useName = useName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.updateTime = updateTime;
	}
	
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 * @param description
	 */
	public Member(String firstName, String lastName, String phone, String email, String description) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.description = description;
	}
	/**
	 * @param id
	 * @param useName
	 * @param password
	 */
	public Member(int id, String useName, String password) {
		this.id = id;
		this.useName = useName;
		this.password = password;
	}
	
}
