package dao;

import java.util.ArrayList;

import beans.Detail;
import beans.User;

public interface IDetailDao extends BaseDao<Detail>{
	ArrayList<Detail> showDetail(User user);
}
