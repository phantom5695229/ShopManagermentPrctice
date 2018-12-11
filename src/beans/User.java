package beans;

public class User {
	private String uid;
	private String pw;
	private boolean status;
	private int money;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uid) {
		super();
		this.uid = uid;
		this.money = 0;
		this.status = false;
	}
	
	public User(String uid, String pw) {
		super();
		this.uid = uid;
		this.pw = pw;
		this.money = 0;
		this.status = false;
	}
	public User(String uid, String pw, boolean status, int money) {
		super();
		this.uid = uid;
		this.pw = pw;
		this.status = status;
		this.money = money;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", pw=" + pw + ", status=" + status + ", money=" + money + "]";
	}
	
	
	
}
