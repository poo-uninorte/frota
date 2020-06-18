package uninorte.poo.frota.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import uninorte.poo.frota.modelo.Carro;

public class HibernateUtil {
	
	private static SessionFactory session;
	
	public static SessionFactory getSessionFactory() {
		if (session == null) {
			try {
				Configuration conf = new Configuration();
				Properties prop = new Properties();
/**				//mysql
				prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				prop.put(Environment.URL, "jdbc:mysql://localhost:3306/frota?useTimezone=true&amp;serverTimezone=UTC");
				prop.put(Environment.USER, "root");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
*/				
 				//postgresql
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost:5432/frota?useSSL=false");
				prop.put(Environment.USER, "postgres");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

				prop.put(Environment.SHOW_SQL, "false");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				conf.setProperties(prop);
				
				conf.addAnnotatedClass(Carro.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(conf.getProperties()).build();
				session = conf.buildSessionFactory(serviceRegistry);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return session;
	}
	
}
	
