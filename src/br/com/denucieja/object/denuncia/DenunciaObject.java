package br.com.denucieja.object.denuncia;

import java.util.List;

import br.com.denucieja.model.denuncia.CategoriaDenuncia;
import br.com.denucieja.model.denuncia.TipoDenuncia;
import br.com.denucieja.object.arquivo.ArquivoObject;

public class DenunciaObject {

	
	private long id;
	private TipoDenuncia tipoDenuncia;
	private CategoriaDenuncia categoriaDenuncia;
	private String descricao;
	private String latitude;
	private String longitude;
	private String endereco;
	private String enderecoReferencia;
	private String nomeDenunciante;
	private String telefonePrincipal;
	private String telefoneAuxiliar;
	private String emailDenunciante;
	private List<ArquivoObject> listaImagens;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TipoDenuncia getTipoDenuncia() {
		return tipoDenuncia;
	}
	public void setTipoDenuncia(String tipoDenuncia) {
		this.tipoDenuncia = TipoDenuncia.findByName(tipoDenuncia);
	}
	public CategoriaDenuncia getCategoriaDenuncia() {
		return categoriaDenuncia;
	}
	public void setCategoriaDenuncia(String categoriaDenuncia) {
		this.categoriaDenuncia = CategoriaDenuncia.findByName(categoriaDenuncia);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNomeDenunciante() {
		return nomeDenunciante;
	}
	public void setNomeDenunciante(String nomeDenunciante) {
		this.nomeDenunciante = nomeDenunciante;
	}
	public String getEmailDenunciante() {
		return emailDenunciante;
	}
	public void setEmailDenunciante(String emailDenunciante) {
		this.emailDenunciante = emailDenunciante;
	}
//	public void setTipoDenuncia(TipoDenuncia tipoDenuncia) {
//		this.tipoDenuncia = tipoDenuncia;
//	}
//	public void setCategoriaDenuncia(CategoriaDenuncia categoriaDenuncia) {
//		this.categoriaDenuncia = categoriaDenuncia;
//	}
	public List<ArquivoObject> getListaImagens() {
		return listaImagens;
	}
	public void setListaImagens(List<ArquivoObject> listaImagens) {
		this.listaImagens = listaImagens;
	}
	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}
	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}
	public String getTelefoneAuxiliar() {
		return telefoneAuxiliar;
	}
	public void setTelefoneAuxiliar(String telefoneAuxiliar) {
		this.telefoneAuxiliar = telefoneAuxiliar;
	}
	public String getEnderecoReferencia() {
		return enderecoReferencia;
	}
	public void setEnderecoReferencia(String enderecoReferencia) {
		this.enderecoReferencia = enderecoReferencia;
	}
}
