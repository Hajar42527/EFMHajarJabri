package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.RUE;
import ma.ismo.crjj.util.HibernateUtils;

public class DaoRue implements IDao<RUE,Integer>{

	@Override
	public List<RUE> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<RUE> rues = session.createQuery("from RUE").getResultList();

		t.commit();
		session.close();

		return rues;
	}

	@Override
	public RUE getOne(Integer id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		RUE rue = session.get(RUE.class, id);

		t.commit();
		session.close();

		return rue;
	}

	@Override
	public boolean save(RUE obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			Object o = session.save(obj);

			t.commit();
			session.close();

			if (o == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(RUE obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(RUE obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
