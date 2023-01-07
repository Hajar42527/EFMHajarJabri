package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.IMMEUBLE;
import ma.ismo.crjj.util.HibernateUtils;

public class DaoImmeuble implements IDao<IMMEUBLE,Integer>{

	@Override
	public List<IMMEUBLE> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<IMMEUBLE> immeubles = session.createQuery("from IMMEUBLE").getResultList();

		t.commit();
		session.close();

		return immeubles;
	}

	@Override
	public IMMEUBLE getOne(Integer id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		IMMEUBLE immeuble = session.get(IMMEUBLE.class, id);

		t.commit();
		session.close();

		return immeuble;
	}

	@Override
	public boolean save(IMMEUBLE obj) {
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
	public boolean update(IMMEUBLE obj) {
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
	public boolean delete(IMMEUBLE obj) {
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
