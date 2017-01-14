package acm_add;

import java.sql.Date;

public class noticeinfobean {
	String heading, path;
	Date date;
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public String getHeading() {
		return heading;
	}
	public String getPath() {
		return path;
	}

}







