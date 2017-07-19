package br.com.denucieja.controller.denuncia;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.denucieja.business.denuncia.DenunciaBusiness;
import br.com.denucieja.object.denuncia.DenunciaObject;
import br.com.denucieja.utils.HttpUtils;

/**
 * 
 * @author Marconi Motta
 *
 */
@RestController
@RequestMapping("/denuncia")
public class DenunciaRestController {

	@Autowired
	DenunciaBusiness denunciaBusiness;
	/**
	 * Serviço utilizado para inserir uma denúncia, passando o parametro denunciaObject.
	 * 
	 * @param request
	 * @param denunciaObject
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/" , method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody ResponseEntity insert(@Context HttpServletRequest request, @RequestBody DenunciaObject denunciaObject) throws IOException{
		denunciaBusiness.insertUpdate(denunciaObject);
		return new ResponseEntity(HttpStatus.OK);
	}

	
	/**
	 * Serviço utilizado para atualizar a denuncia, passando o parametro denunciaObject.
	 * Até o momento não utilizado.
	 * @param request
	 * @param denunciaObject
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/" , method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity update(@Context HttpServletRequest request, @RequestBody DenunciaObject denunciaObject) throws IOException{
		denunciaBusiness.insertUpdate(denunciaObject);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * Serviço que lista as Possiveis Categorias a serem escolhidas
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/list/categoria" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity listCategoriaDenuncia(@Context HttpServletRequest request){
		return new ResponseEntity(denunciaBusiness.listCategoriaDenuncia(),HttpUtils.getHeaders(), HttpStatus.OK);
	}
	
	/***
	 * Serviço que lista os possiveis tipos de denuncia a serem escolhidos.
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/list/tipo" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity listTipoDenuncia(@Context HttpServletRequest request){
		return new ResponseEntity(denunciaBusiness.listTipoDenuncia(),HttpUtils.getHeaders(), HttpStatus.OK);
	}
	
	/**
	 * Serviço que retorna todas as denuncias criadas.
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/list" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity listDenuncia(@Context HttpServletRequest request){
		return new ResponseEntity(denunciaBusiness.listTipoDenuncia(),HttpUtils.getHeaders(), HttpStatus.OK);
	}

}
