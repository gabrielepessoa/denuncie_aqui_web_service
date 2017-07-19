package br.com.denucieja.dao.denuncia;

import java.util.List;

/**
 * 
 * @author Tiago Sitonio
 *
 */

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.denucieja.model.denuncia.Denuncia;
import br.com.denucieja.persistence.GenericDAO;

public class DenunciaDAOImpl  extends GenericDAO<Denuncia> implements DenunciaDAO{

	public DenunciaDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	/**
	 * Criado apenas para exemplificar um modelo de List Utilizando A Api Criteria.
	 */
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Denuncia> listDenunciaByEnderenco(String endereco){
		Session session = getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(Denuncia.class);
		crit.add(Restrictions.eq("endereco", endereco));
		return crit.list();
		
	}
	
	@Override
	public boolean exists(Denuncia t) {
		return false;
	}

}
