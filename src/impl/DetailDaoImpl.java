package impl;

import java.util.ArrayList;

import beans.Detail;
import beans.User;
import dao.IDetailDao;

public class DetailDaoImpl implements IDetailDao{
	ArrayList<Detail> details = new ArrayList<Detail>();
	@Override
	public boolean save(Detail t) {
		details.add(t);
		return true;
	}

	@Override
	public boolean delete(String name) {
		return false;
	}

	@Override
	public boolean replace(String name, String newName, int newCount, int newPrice) {
		return false;
	}

	@Override
	public ArrayList<Detail> queraAll() {
		return details;
	}

	@Override
	public ArrayList<Detail> showDetail(User user) {
		ArrayList<Detail> d2 = new ArrayList<Detail>();
		for (int i = 0; i < details.size(); i++) {
			if (details.get(i).getUser().getUid().equals(user.getUid())) {
				d2.add(details.get(i));
			}
		}
		return d2;
	}

}
