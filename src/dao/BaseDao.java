package dao;

import java.util.ArrayList;

import beans.Goods;

public interface BaseDao <T>{
	boolean save(T t);
	boolean delete(String name);
	boolean replace(String name,String newName,int newCount,int newPrice);
	ArrayList<T> queraAll();
}
