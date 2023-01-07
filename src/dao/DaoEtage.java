package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.ETAGE;
import entities.IMMEUBLE;
import entities.RUE;
import ma.ismo.crjj.util.HibernateUtils;

public class DaoEtage implements IDao<ETAGE,Integer>{

	@Override
	public List<ETAGE> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<ETAGE> etages = session.createQuery("from ETAGE").getResultList();

		t.commit();
		session.close();

		return etages;
	}

	@Override
	public ETAGE getOne(Integer id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		ETAGE etage = session.get(ETAGE.class, id);

		t.commit();
		session.close();

		return etage;
	}

	@Override
	public boolean save(ETAGE obj) {
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
	public boolean update(ETAGE obj) {
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
	public boolean delete(ETAGE obj) {
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
