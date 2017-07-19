package br.com.denucieja.dao.denuncia;

import java.util.List;

import br.com.denucieja.model.denuncia.Denuncia;
import br.com.denucieja.persistence.IDAO;

/**
 * 
 * @author Marconi Motta
 *
 */
public interface DenunciaDAO extends IDAO<Denuncia> {

	/**
	 * 
	 * @param endereco
	 * @return {@link List}
	 */
	public List<Denuncia> listDenunciaByEnderenco(String endereco);

}
