package acm_add;

import java.sql.Date;

public class attendencestuinfo {
	String user_name ,attendence, column_name, date;
	Date attend;
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setAttendence(String attendence) {
		this.attendence = attendence;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setAttend(Date attend) {
		this.attend = attend;
	}
	public Date getAttend() {
		return attend;
	}
	public String getDate() {
		return date;
	}
	public String getColumn_name() {
		return column_name;
	}
	public String getAttendence() {
		return attendence;
	}
	public String getUser_name() {
		return user_name;
	}

}
