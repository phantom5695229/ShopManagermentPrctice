package test;

import beans.Goods;
import dao.IGoodsDao;
import impl.DetailDaoImpl;
import impl.GoodsDaoImpl;
import impl.UserDaoImpl;

public class Test {
	public static void main(String[] args) {
		UserDaoImpl iud = new UserDaoImpl();
		DetailDaoImpl idd = new DetailDaoImpl();
		IGoodsDao igd = new GoodsDaoImpl(idd,iud);
		Goods gs1 = new Goods("abc",100,1000);
		Goods gs2 = new Goods("def",200,900);
		Goods gs3 = new Goods("ghi",300,800);
		Goods gs4 = new Goods("jkl",400,700);
		Goods gs5 = new Goods("mno",500,600);
		igd.save(gs1);
		igd.save(gs2);
		igd.save(gs3);
		igd.save(gs4);
		igd.save(gs5);
		iud.regist("abc", "123");
		iud.regist("def", "123");
		iud.login("abc", "123");
		iud.charge(100000);
		igd.beBought(iud.getLoginUser(), gs1, 100);
		System.out.println(idd.queraAll());
		igd.beBought(iud.getLoginUser(), gs2, 100);
		System.out.println(idd.queraAll());
		igd.beBought(iud.getLoginUser(), gs3, 100);
		System.out.println(idd.queraAll());
		iud.logout();
		iud.login("def", "123");
		iud.charge(100000);
		System.out.println(iud.getLoginUser());
		igd.beBought(iud.getLoginUser(), gs4, 1);
		System.out.println(idd.queraAll());
		System.out.println(idd.showDetail(iud.getLoginUser()));
		igd.beBought(iud.getLoginUser(), gs4, 1);
		System.out.println(idd.showDetail(iud.getLoginUser()));
		System.out.println(igd.queraAll());

	}
}
