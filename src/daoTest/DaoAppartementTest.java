package daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


import dao.DaoFactory;
import dao.IDao;
import dao.TypeDao;
import entities.APPARTEMENT;


class DaoAppartementTest {

	@Test
	void getAlltest() {
		IDao dao = DaoFactory.getDAO(TypeDao.APPARTEMENT);
		List<APPARTEMENT> appars = dao.getAll();
		
		assertNotNull(appars);
		assertEquals(appars.size(), 4);
	}
	
	@Test
	void getOnetest() {
		IDao dao = DaoFactory.getDAO(TypeDao.APPARTEMENT);
		APPARTEMENT appart = (APPARTEMENT) dao.getOne('A');

		assertEquals(appart.getLettre_appartement(), 'A');
		assertEquals(appart.getNb_pieces_total(), 11);
	}
	@Test
	void savetest() {
		IDao dao = DaoFactory.getDAO(TypeDao.APPARTEMENT);
		List<APPARTEMENT> apparts_before = dao.getAll();
		APPARTEMENT a = new APPARTEMENT("E",15,null);
		dao.save(a);
		List<APPARTEMENT> apparts_after = dao.getAll();
		assertEquals(apparts_before.size()+1, apparts_after.size());
	}
	
	@Test
	void updateTest() {
		IDao dao = DaoFactory.getDAO(TypeDao.APPARTEMENT);
		APPARTEMENT a=(APPARTEMENT) dao.getOne("B");
		APPARTEMENT a1=new APPARTEMENT("B",23, null);
		dao.update(a1);
		assertEquals(a1.getNb_pieces_total(),23);
		assertNotEquals(a1.getNb_pieces_total(),2289);
		assertNotNull(a);
		assertNotNull(a1);
		assertNotSame(a, a1);
	}
	
	@Test
	void deleteTest() {
		IDao dao=DaoFactory.getDAO(TypeDao.APPARTEMENT);
		List<APPARTEMENT> apparts_before = dao.getAll();
		APPARTEMENT a=(APPARTEMENT) dao.getOne("C");
		dao.delete(a);
		List<APPARTEMENT> apparts_after = dao.getAll();
		assertNotEquals(apparts_before.size(),apparts_after.size());
		assertEquals(apparts_before.size(),apparts_after.size()+1);
		assertEquals(apparts_before.size()-1,apparts_after.size());
	}
}
