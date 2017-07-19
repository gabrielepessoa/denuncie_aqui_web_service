package br.com.denucieja.object.arquivo;

import br.com.denucieja.model.arquivo.Arquivo;

/**
 * 
 * @author Tiago Sitonio
 *
 */

public class ArquivoTO {
	
	private long id;
	private String nomeArquivo;
	private byte[] dados;
	private String formatoArquivo;
	
	public ArquivoTO(){}
	
	public ArquivoTO(Arquivo arquivo){
		this.id = arquivo.getId();
		this.nomeArquivo = arquivo.getNomeArquivo();
		this.dados = arquivo.getDados();
		this.formatoArquivo = arquivo.getFormatoArquivo();
	}

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

	public void setDados(byte[] d) {
		this.dados = d;
	}

	public String getFormatoArquivo() {
		return formatoArquivo;
	}

	public void setFormatoArquivo(String formatoArquivo) {
		this.formatoArquivo = formatoArquivo;
	}

}
