package br.com.denucieja.dao.arquivo;

import java.util.List;

/**
 * 
 * @author Tiago Sitonio
 *
 */

import br.com.denucieja.model.arquivo.Arquivo;
import br.com.denucieja.persistence.IDAO;

public interface ArquivoDAO extends IDAO<Arquivo>{

	/**
	 * 
	 * @param denunciaId
	 * @return {@link List<Arquivo>}
	 */
	public List<Arquivo> listArquivosByDenuncia(long denunciaId);
}
