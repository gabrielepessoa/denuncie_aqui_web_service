package br.com.denucieja.business.denuncia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.denucieja.business.arquivo.ArquivoBusiness;
import br.com.denucieja.dao.denuncia.DenunciaDAO;
import br.com.denucieja.model.arquivo.Arquivo;
import br.com.denucieja.model.denuncia.CategoriaDenuncia;
import br.com.denucieja.model.denuncia.Denuncia;
import br.com.denucieja.model.denuncia.TipoDenuncia;
import br.com.denucieja.object.arquivo.ArquivoObject;
import br.com.denucieja.object.denuncia.DenunciaObject;
import br.com.denucieja.object.denuncia.DenunciaTO;
import br.com.denucieja.object.generic.GenericTO;

/**
 * 
 * @author Marconi Motta
 *
 */
public class DenunciaBusinessImpl implements DenunciaBusiness{

	@Autowired
	DenunciaDAO denunciaDAO;

	@Autowired
	ArquivoBusiness arquivoBusiness;

	@Override
	@Transactional
	public void insertUpdate(DenunciaObject denunciaObject) throws IOException{
		Denuncia denuncia = new Denuncia(denunciaObject);
		if(denunciaObject.getListaImagens() != null && denunciaObject.getListaImagens().size() > 0){
			denuncia.setArquivos(new ArrayList<Arquivo>());
			for (ArquivoObject imagem : denunciaObject.getListaImagens()) {
				denuncia.getArquivos().add(arquivoBusiness.insert(imagem));
			}
		}
		if(denuncia.getId() > 0){
			denunciaDAO.updateNoAudit(denuncia);
		}else{
			denunciaDAO.insertNoAudit(denuncia);
		}
	}

	@Override
	@Transactional
	public List<DenunciaTO> listAll(){
		List<DenunciaTO> result = new ArrayList<DenunciaTO>();
		for (Denuncia denuncia : denunciaDAO.list()) {
			result.add(new DenunciaTO(denuncia));
		}
		return result;
	}

	@Override
	@Transactional
	public List<GenericTO> listTipoDenuncia(){
		List<GenericTO> result = new ArrayList<GenericTO>();
		for (TipoDenuncia tipoDenuncia : TipoDenuncia.values()) {
			result.add(new GenericTO(tipoDenuncia.toString(), tipoDenuncia.getValue()));
		}
		return result;
	}

	@Override
	@Transactional
	public List<GenericTO> listCategoriaDenuncia(){
		List<GenericTO> result = new ArrayList<GenericTO>();
		for (CategoriaDenuncia categoriaDenuncia : CategoriaDenuncia.values()) {
			result.add(new GenericTO(categoriaDenuncia.toString(), categoriaDenuncia.getValue()));
		}
		return result;
	}
}
