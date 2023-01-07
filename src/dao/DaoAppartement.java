package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.APPARTEMENT;
import entities.IMMEUBLE;
import ma.ismo.crjj.util.HibernateUtils;

public class DaoAppartement implements IDao<APPARTEMENT,String>{

	@Override
	public List<APPARTEMENT> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<APPARTEMENT> appartements = session.createQuery("from APPARTEMENT").getResultList();

		t.commit();
		session.close();

		return appartements;
	}

	

	@Override
	public boolean save(APPARTEMENT obj) {
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
	public boolean update(APPARTEMENT obj) {
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
	public boolean delete(APPARTEMENT obj) {
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



	@Override
	public APPARTEMENT getOne(String id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		APPARTEMENT appartement = session.get(APPARTEMENT.class, id);

		t.commit();
		session.close();

		return appartement;
	}

}
