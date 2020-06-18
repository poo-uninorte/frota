package uninorte.poo.frota.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import uninorte.poo.frota.modelo.Carro;
import uninorte.poo.frota.util.HibernateUtil;

public class CarroDao {
	
	public void cadastra(Carro carro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.save(carro);
		trans.commit();
	}
	
	public List<Carro> recuperaTodos(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("from Carro", Carro.class).list();
	}
	
	public Carro recuperaPorCod(long cod) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Carro.class, cod);
		}
	}

	public void deleta(Carro carro) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			session.delete(carro);
			session.getTransaction().commit();
		}
	}
	
	public void update(Carro carro) {
        Carro novoCarro = recuperaPorCod(carro.getCod());
        if (novoCarro == null) novoCarro = new Carro();
        novoCarro.setCor(carro.getCor());
        novoCarro.setPlaca(carro.getPlaca());

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			session.saveOrUpdate(carro);
			session.getTransaction().commit();
		}
	}
	

}
