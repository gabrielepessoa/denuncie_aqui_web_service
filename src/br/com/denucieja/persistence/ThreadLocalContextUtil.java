package br.com.denucieja.persistence;



import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Classe que instancia as configurações para Tenant (base logada), utilizado num contexto de quando se pretende ter várias bases
 * sendo controladas por diferentes url's. Nela iniciamos a sessão do Hibernate através do SessionFactory.
 * @author Marconi Motta
 *
 */

@Component
public class ThreadLocalContextUtil {

	private static SessionFactory sessionFactory;
	
	private static final ThreadLocal<String> contextHolder =
			new ThreadLocal<String>();
	
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();
	
	public static void setTenantId(String tenantId) {
		contextHolder.remove();
		contextHolder.set("denucieja");
		
	}

	public static String getTenantId() {
		return (String) contextHolder.get();
	}

	
	public static void clearTenant(){
		contextHolder.remove();
	}

	public static void createSession(){
		session.set(sessionFactory.withOptions().tenantIdentifier(contextHolder.get()).openSession());
		session.get().setFlushMode(FlushMode.ALWAYS);
		session.get().beginTransaction();
	}
	
	public static void rollbackSession(){
		
		if(session.get().isOpen()){
			session.get().getTransaction().rollback();
			session.get().close();
		}
	}
	
	public static void finishSession(){
		
		if(session.get().isOpen()){
			session.get().getTransaction().commit();
			session.get().close();
		}
	}
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		ThreadLocalContextUtil.sessionFactory = sessionFactory;
	}

	public static Session getSession() {
		return session.get();
	}

	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
