package br.com.denucieja.object.denuncia;

import java.util.Date;

import br.com.denucieja.model.denuncia.CategoriaDenuncia;
import br.com.denucieja.model.denuncia.Denuncia;
import br.com.denucieja.model.denuncia.TipoDenuncia;

public class DenunciaTO {

	private long id;
	private TipoDenuncia tipoDenuncia;
	private CategoriaDenuncia categoriaDenuncia;
	private String descricao;
	private String latitude;
	private String longitude;
	private String endereco;
	private String nomeDenunciante;
	private String telefonePrincipal;
	private String telefoneAuxiliar;
	private String emailDenunciante;
	private Date dataCriacao;

	public DenunciaTO(){

	}
	
	public DenunciaTO(Denuncia denuncia){
		this.id = denuncia.getId();
		this.descricao = denuncia.getDescricao();
		this.tipoDenuncia = denuncia.getTipoDenuncia();
		this.categoriaDenuncia = denuncia.getCategoriaDenuncia();
		this.latitude = denuncia.getLatitude();
		this.longitude = denuncia.getLongitude();
		this.endereco = denuncia.getEndereco();
		this.nomeDenunciante = denuncia.getNomeDenunciante();
		this.telefonePrincipal = denuncia.getTelefonePrincipal();
		this.telefoneAuxiliar = denuncia.getTelefoneAuxiliar();
		this.emailDenunciante = denuncia.getEmailDenunciante();
		this.dataCriacao = denuncia.getDataCriacao();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TipoDenuncia getTipoDenuncia() {
		return tipoDenuncia;
	}
	public void setTipoDenuncia(TipoDenuncia tipoDenuncia) {
		this.tipoDenuncia = tipoDenuncia;
	}
	public CategoriaDenuncia getCategoriaDenuncia() {
		return categoriaDenuncia;
	}
	public void setCategoriaDenuncia(CategoriaDenuncia categoriaDenuncia) {
		this.categoriaDenuncia = categoriaDenuncia;
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
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


}
