package Model;

import javax.persistence.Embeddable;

@Embeddable
public class Reviews {

	private String user;
	private String rev;
	
	public Reviews() {}
	public Reviews(String user, String rev) {
		super();
		this.user = user;
		this.rev = rev;
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRev() {
		return rev;
	}
	public void setRev(String rev) {
		this.rev = rev;
	}
	
}
