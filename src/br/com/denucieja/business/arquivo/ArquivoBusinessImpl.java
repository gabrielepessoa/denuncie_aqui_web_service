package br.com.denucieja.business.arquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.denucieja.dao.arquivo.ArquivoDAO;
import br.com.denucieja.model.arquivo.Arquivo;
import br.com.denucieja.object.arquivo.ArquivoObject;
import br.com.denucieja.object.arquivo.ArquivoTO;

/**
 * 
 * @author Marconi Motta
 *
 */
public class ArquivoBusinessImpl implements ArquivoBusiness{

	@Autowired
	ArquivoDAO arquivoDAO;

	@Override
	@Transactional
	public ArquivoTO insert(MultipartFile file)throws IOException {

		Arquivo arquivo = new Arquivo();
		arquivo.setNomeArquivo(file.getOriginalFilename());
		arquivo.setDados(file.getBytes());
		arquivo.setFormatoArquivo(file.getContentType());

		arquivoDAO.insertNoAudit(arquivo);	
		return new ArquivoTO(arquivo);

	}

	@Override
	@Transactional
	public Arquivo insert(ArquivoObject arquivoObject)throws IOException {

		Arquivo arquivo = new Arquivo();
		arquivo.setNomeArquivo(arquivoObject.getNomeArquivo());
		arquivo.setDados(arquivoObject.getDados());
		arquivo.setFormatoArquivo(arquivoObject.getFormatoArquivo());

		arquivoDAO.insertNoAudit(arquivo);	
		return arquivo;
	}

	@Override
	@Transactional
	public List<ArquivoTO> listAquivosByDenuncia(long denunciaId){
		List<ArquivoTO> result = new ArrayList<ArquivoTO>();
		List<Arquivo> search = arquivoDAO.listArquivosByDenuncia(denunciaId);
		if(search != null && search.size() > 0){
			for (Arquivo arquivo : search) {
				result.add(new ArquivoTO(arquivo));
			}
		}
		return result;
	}

}

