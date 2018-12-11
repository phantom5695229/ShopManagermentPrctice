package dao;

import java.util.ArrayList;

import beans.Goods;
import beans.User;

public interface IGoodsDao extends BaseDao<Goods>{
	ArrayList<Goods> queryByName(String name);
	ArrayList<Goods> queryByPrice(int min,int max);
	ArrayList<Goods> sortByPrice();
	ArrayList<Goods> sortByCount();
	boolean beBought(User user,Goods Goods,int c);
}
