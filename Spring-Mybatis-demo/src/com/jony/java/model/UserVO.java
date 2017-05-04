package com.jony.java.model;

import java.util.Date;

public class UserVO {
	private String id ;
	private String workername;
	private String salary;
	private String tel;
	private String mailbox;
	private String department;
	private String qq;
	private Date EmployedDates;
	
	public Date getEmployedDates() {
		return EmployedDates;
	}
	public void setEmployedDates(Date employedDates) {
		EmployedDates = employedDates;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkername() {
		return workername;
	}
	public void setWorkername(String workername) {
		this.workername = workername;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
}
