package br.com.denucieja.dao.arquivo;

import java.util.List;

/**
 * 
 * @author Tiago Sitonio
 *
 */

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import br.com.denucieja.model.arquivo.Arquivo;
import br.com.denucieja.persistence.GenericDAO;

public class ArquivoDAOImpl extends GenericDAO<Arquivo> implements ArquivoDAO{

	public ArquivoDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public boolean exists(Arquivo a) {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Arquivo> listArquivosByDenuncia(long denunciaId){
		String sql = "SELECT ID_ARQUIVO FROM denuncia_arquivo WHERE ID_DENUNCIA = :denunciaId";
		Query query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setParameter("denunciaId", denunciaId);
		return query.list();
	}


}
