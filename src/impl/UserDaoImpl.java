package impl;

import java.util.ArrayList;

import beans.User;
import dao.IUserDao;

public class UserDaoImpl implements IUserDao{
	ArrayList<User> users = new ArrayList<User>();
	User loginUser;
	
	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	@Override
	public boolean save(User t) {
		users.add(t);
		return true;
	}

	@Override
	public boolean delete(String name) {
		return false;
	}

	@Override
	public boolean replace(String name,String newName,int newCount,int newMoney) {
		return false;
	}

	@Override
	public ArrayList<User> queraAll() {
		return users;
	}

	@Override
	public boolean regist(String id, String pw) {
		User temp = new User(id,pw);
		users.add(temp);
		return true;
	}

	@Override
	public boolean login(String id, String pw) {
		User temp = new User(id,pw);
		if (users.contains(temp)) {
			int index = users.indexOf(temp);
			users.get(index).setStatus(true);
			loginUser = users.get(index);
			return true;
		}
		return false;
	}

	@Override
	public boolean charge(int money) {
		for (int i = 0; i < users.size() ; i++) {
			User temp = users.get(i);
			if (temp.isStatus()) {
				temp.setMoney(temp.getMoney()+money);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean logout() {
		for (int i = 0; i < users.size() ; i++) {
			User temp = users.get(i);
			if (temp.isStatus()) {
				temp.setStatus(false);
				loginUser = null;
				return true;
			}
		}
		return false;
	}
}
