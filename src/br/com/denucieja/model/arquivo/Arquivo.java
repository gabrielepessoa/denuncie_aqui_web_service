package br.com.denucieja.model.arquivo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.denucieja.model.misc.IEntity;

/**
 * 
 * @author Tiago Sitonio
 *
 */

@Entity
@Table(name="arquivo")
@SequenceGenerator(name="ARQUIVO_ID_GEN",initialValue=1,allocationSize=5, sequenceName="ARQUIVO_ID_SEQ")
public class Arquivo implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ARQUIVO_ID_GEN")
	@Column(name="ID")
	private long id;
	
	@Column(name="NOME_ARQUIVO")
	private String nomeArquivo;
	
	@Column(name="DADOS")
	private byte[] dados;
	
	@Column(name="FORMATO_ARQUIVO")
	private String formatoArquivo;
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	public void setNomeArquivo(String n) {
		this.nomeArquivo = n;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] blob) {
		this.dados = blob;
	}
	
	public String getFormatoArquivo() {
		return formatoArquivo;
	}

	public void setFormatoArquivo(String formatoArquivo) {
		this.formatoArquivo = formatoArquivo;
	}

	@Override
	public String getResourceType() {
		return Arquivo.class.toString();
	}

	@Override
	public String getEntityDescription() {
		return "Registro de Arquivo anexo";
	}
	
	

}
