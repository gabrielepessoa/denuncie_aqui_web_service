package br.com.denucieja.controller.arquivo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.denucieja.business.arquivo.ArquivoBusiness;
import br.com.denucieja.object.arquivo.ArquivoObject;
import br.com.denucieja.utils.HttpUtils;

/**
 * 
 * @author Marconi Motta
 *
 */
@RestController
@RequestMapping("/arquivo")
public class ArquivoRestController {

	@Autowired
	ArquivoBusiness arquivoBusiness;

	/**
	 * Serviço que permite inserir um arquivo pelo MultiPartFile.
	 * 
	 * @param request
	 * @param response
	 * @param multiPart
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value = "/fazerUpload" , method = RequestMethod.POST, headers = "content-type=multipart/form-data")
	public @ResponseBody ResponseEntity handleUpload(final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestParam("file") final MultipartFile multiPart) throws IOException{

		if (multiPart != null){
			return new ResponseEntity(arquivoBusiness.insert(multiPart), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	/**
	 * Serviço que permite inserir um arquivo independente.
	 * 
	 * @param request
	 * @param arquivoObject
	 * @return
	 * @throws IOException
	 */

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/" , method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody ResponseEntity insert(@Context HttpServletRequest request, @RequestBody ArquivoObject arquivoObject) throws IOException{
		arquivoBusiness.insert(arquivoObject);
		return new ResponseEntity(HttpStatus.OK);

	}


	/**
	 * Serviço que lista arquivos pelo Id da denuncia.
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/list/denuncia/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity listAquivosByDenuncia(@Context HttpServletRequest request, @PathVariable(value="id") long id){
		return new ResponseEntity(arquivoBusiness.listAquivosByDenuncia(id),HttpUtils.getHeaders(), HttpStatus.OK);
	}
}
