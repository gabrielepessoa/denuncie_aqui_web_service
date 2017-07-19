package br.com.denucieja.business.arquivo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.denucieja.model.arquivo.Arquivo;
import br.com.denucieja.object.arquivo.ArquivoObject;
import br.com.denucieja.object.arquivo.ArquivoTO;

/**
 * 
 * @author Marconi Motta
 *
 */
public interface ArquivoBusiness {

	/**
	 * 
	 * @param file
	 * @return {@link ArquivoTO}
	 * @throws IOException
	 */
	public ArquivoTO insert(MultipartFile file) throws IOException;

	
	/**
	 * 
	 * @param denunciaId
	 * @return {@link List}
	 */
	public List<ArquivoTO> listAquivosByDenuncia(long denunciaId);


	/**
	 * 
	 * @param arquivoObject
	 * @return {@link Arquivo}
	 * @throws IOException
	 */
	public Arquivo insert(ArquivoObject arquivoObject) throws IOException;

}
