package br.com.denucieja.business.denuncia;

import java.io.IOException;
import java.util.List;

import br.com.denucieja.object.denuncia.DenunciaObject;
import br.com.denucieja.object.denuncia.DenunciaTO;
import br.com.denucieja.object.generic.GenericTO;

/**
 * 
 * @author Marconi Motta
 *
 */
public interface DenunciaBusiness {

	/**
	 * 
	 * @param denunciaObject
	 * @throws IOException
	 */
	public void insertUpdate(DenunciaObject denunciaObject) throws IOException;

	/**
	 * 
	 * @return {@link List}
	 */
	public List<GenericTO> listTipoDenuncia();

	/**
	 * 
	 * @return {@link List}
	 */
	public List<DenunciaTO> listAll();

	/**
	 * 
	 * @return {@link List}
	 */
	public List<GenericTO> listCategoriaDenuncia();

}
