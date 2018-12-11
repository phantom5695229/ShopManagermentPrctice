package impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import beans.Detail;
import beans.Goods;
import beans.User;
import dao.IGoodsDao;

public class GoodsDaoImpl implements IGoodsDao{
	ArrayList<Goods> goodses = new ArrayList<Goods>();
	DetailDaoImpl ddi;
	UserDaoImpl udi;
	
	
	public GoodsDaoImpl(DetailDaoImpl ddi, UserDaoImpl udi) {
		super();
		this.ddi = ddi;
		this.udi = udi;
	}

	@Override
	public boolean save(Goods t) {
		goodses.add(t);
		return true;
	}

	@Override
	public boolean delete(String name) {
		Goods temp = new Goods(name);
		int index = goodses.indexOf(temp);
		if (index != -1) {
			goodses.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public boolean replace(String name,String newName,int newCount,int newPrice) {
		Goods temp = new Goods(name);
		int index = goodses.indexOf(temp);
		if (index != -1) {
			temp.setName(newName);
			temp.setCount(newCount);
			temp.setPrice(newPrice);
			goodses.set(index, temp);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Goods> queraAll() {
		return goodses;
	}

	@Override
	public ArrayList<Goods> queryByName(String name) {
		ArrayList<Goods> gs2 = new ArrayList<Goods>();
		for (int i = 0; i < goodses.size(); i++) {
			if (goodses.get(i).getName().equals(name)) {
				gs2.add(goodses.get(i));
			}
		}
		return gs2;
	}

	@Override
	public ArrayList<Goods> queryByPrice(int min, int max) {
		ArrayList<Goods> gs2 = new ArrayList<Goods>();
		for (int i = 0; i < goodses.size(); i++) {
			if (goodses.get(i).getPrice() <= max && goodses.get(i).getPrice() >= min) {
				gs2.add(goodses.get(i));
			}
		}
		return gs2;
	}

	@Override
	public ArrayList<Goods> sortByPrice() {
		ArrayList<Goods> gs2 = goodses;
		gs2.sort(new Comparator<Goods>() {

			@Override
			public int compare(Goods o1, Goods o2) {
				// TODO Auto-generated method stub
				return o1.getPrice() - o2.getPrice();
			}
		});
		return gs2;
	}

	@Override
	public ArrayList<Goods> sortByCount() {
		ArrayList<Goods> gs2 = goodses;
		gs2.sort(new Comparator<Goods>() {

			@Override
			public int compare(Goods o1, Goods o2) {
				return o1.getCount() - o2.getCount();
			}
		});
		return gs2;
	}

	@Override
	public boolean beBought(User user, Goods goods, int c) {
		int index = goodses.indexOf(goods);
		int userIndex = udi.users.indexOf(user);
		User u = new User();
		Goods temp = new Goods();
		temp = goods;
		if (index != -1 && userIndex != -1) {
			Goods gs =  goodses.get(index);
			u = udi.users.get(userIndex);
			if (user.getMoney() >= gs.getPrice() * c && gs.getCount() >= c) {
				user.setMoney(user.getMoney() - (gs.getPrice() * c));
				gs.setCount(gs.getCount() - c);
				Detail d = new Detail(u,temp,new Date());
				ddi.save(d);
				return true;
			}
		}
		return false;
	}

}
