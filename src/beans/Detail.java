package beans;

import java.util.Date;

public class Detail {
	private User user;
	private Goods goods;
	private Date date;
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Detail(User user, Goods goods, Date date) {
		super();
		this.user = user;
		this.goods = goods;
		this.date = date;
	}
	public Detail(User user) {
		super();
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Detail other = (Detail) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Detail [user=" + user + ", goods=" + goods + ", date=" + date + "]";
	}
	

}
