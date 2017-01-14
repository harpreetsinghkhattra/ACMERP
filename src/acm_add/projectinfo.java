package acm_add;

import java.sql.Date;

public class projectinfo {
	String username, description, projectname,username1,username2,username3;
	Date finaldate, initialdate;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public void setFinaldate(Date finaldate) {
		this.finaldate = finaldate;
	}
	public void setUsername1(String username1) {
		this.username1 = username1;
	}
	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	public void setUsername3(String username3) {
		this.username3 = username3;
	}
	public void setInitialdate(Date initialdate) {
		this.initialdate = initialdate;
	}
	public Date getInitialdate() {
		return initialdate;
	}
	public String getUsername1() {
		return username1;
	}
	public String getUsername2() {
		return username2;
	}
	public String getUsername3() {
		return username3;
	} 
	public Date getFinaldate() {
		return finaldate;
	}
	public String getProjectname() {
		return projectname;
	} 
	public String getDescription() {
		return description;
	}
	public String getUsername() {
		return username;
	}
	

}
