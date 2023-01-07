package dao;


public class DaoFactory {
	public static IDao getDAO(TypeDao type) {
		switch (type) {
			case RUE: return new DaoRue();
			case IMMEUBLE: return new DaoImmeuble();
			case ETAGE: return new DaoEtage();
			case APPARTEMENT: return new DaoAppartement();
		}
		return null;
	}
}
