package dao;

import beans.User;

public interface IUserDao extends BaseDao<User>{
	boolean regist(String id,String pw);
	boolean login(String id,String pw);
	boolean charge(int money);
	boolean logout();
}
