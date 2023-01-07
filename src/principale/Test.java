package principale;

import java.util.List;
import java.util.Scanner;

import dao.DaoAppartement;
import dao.DaoEtage;
import dao.DaoFactory;
import dao.DaoImmeuble;
import dao.DaoRue;
import dao.TypeDao;
import entities.APPARTEMENT;
import entities.ETAGE;
import entities.IMMEUBLE;
import entities.RUE;

public class Test {

	public static void main(String[] args) {
		
		//a
		DaoImmeuble im=new DaoImmeuble();
		List<IMMEUBLE> lst_imm= im.getAll();
		for(IMMEUBLE i:lst_imm) {
			i.toString();
		}
				
		//b
		Scanner sc=new Scanner("Bonjour, donner le code de rue: ");
		int code=sc.nextInt();
		DaoRue doaRue= (DaoRue) DaoFactory.getDAO(TypeDao.RUE);
		RUE rue = doaRue.getOne(code);
		for(IMMEUBLE em : rue.getImmeubles())
			System.out.println(em);
		//c
		
		DaoAppartement ap=new DaoAppartement();
		APPARTEMENT appar=new APPARTEMENT("D",6,null);
		ap.delete(appar);
		
		//d
		DaoEtage etg=new DaoEtage();
		ETAGE etage=new ETAGE(2,7,null,null);
		etg.update(etage);
	}

}
