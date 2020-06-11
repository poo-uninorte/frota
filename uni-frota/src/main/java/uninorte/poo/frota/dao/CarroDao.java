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
	
	public void deleta(Carro carro) { }
	
	public void update(Carro carro) { }
	
	public Carro recuperaPorCod(long cod) { return null; }

}
