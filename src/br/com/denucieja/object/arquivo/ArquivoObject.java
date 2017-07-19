package br.com.denucieja.object.arquivo;

/**
 * 
 * @author Tiago Sitonio
 *
 */


public class ArquivoObject {
	
	private long id;
	private String nomeArquivo;
	private byte[] dados;
	private String formatoArquivo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeArquivo(){
		return this.nomeArquivo;
	}
	public void setNomeArquivo(String nome){
		this.nomeArquivo = nome;
	}
	public byte[] getDados() {
		return dados;
	}
	public void setDados(byte[] dados) {
		this.dados = dados;
	}
	public String getFormatoArquivo() {
		return formatoArquivo;
	}
	public void setFormatoArquivo(String formatoArquivo) {
		this.formatoArquivo = formatoArquivo;
	}
	
}
