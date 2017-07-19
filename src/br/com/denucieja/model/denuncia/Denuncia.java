package br.com.denucieja.model.denuncia;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.denucieja.model.arquivo.Arquivo;
import br.com.denucieja.model.misc.IEntity;
import br.com.denucieja.object.denuncia.DenunciaObject;

@Entity
@Table(name="denuncia")
@SequenceGenerator(name="DENUNCIA_ID_GEN", initialValue=1, allocationSize=5, sequenceName="DENUNCIA_ID_SEQ")
public class Denuncia implements IEntity{

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="DENUNCIA_ID_GEN")
	@Column(name="ID")
	private long id;

	@Column(name="TIPO_DENUNCIA")
	@Enumerated(EnumType.STRING)
	private TipoDenuncia tipoDenuncia;

	@Column(name="CATEGORIA_DENUNCIA")
	@Enumerated(EnumType.STRING)
	private CategoriaDenuncia categoriaDenuncia;

	@Column(name="DESCRICAO")
	private String descricao;

	@Column(name="LATITUDE")
	private String latitude;

	@Column(name="LONGITUDE")
	private String longitude;

	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="ENDERECO_REFERENCIA")
	private String enderecoReferencia;
	
	@Column(name="NOME_DENUNCIANTE")
	private String nomeDenunciante;

	@Column(name="TELEFONE_PRINCIPAL")
	private String telefonePrincipal;
	
	@Column(name="TELEFONE_AUXILIAR")
	private String telefoneAuxiliar;
	
	@Column(name="EMAIL_DENUNCIANTE")
	private String emailDenunciante;

	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Arquivo.class)
	@JoinTable(name = "denuncia_arquivo", joinColumns = @JoinColumn(name = "ID_ARQUIVO", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_DENUNCIA", referencedColumnName = "ID"))
	private List<Arquivo> arquivos;

	public Denuncia(DenunciaObject denunciaObject){
		if(denunciaObject.getId() > 0){
			this.id = denunciaObject.getId();
		}else{
			this.dataCriacao = new Date();
		}
		this.descricao = denunciaObject.getDescricao();
		this.endereco = denunciaObject.getEndereco();
		this.categoriaDenuncia = denunciaObject.getCategoriaDenuncia();
		this.tipoDenuncia = denunciaObject.getTipoDenuncia();
		this.latitude = denunciaObject.getLatitude();
		this.longitude = denunciaObject.getLongitude();
		this.emailDenunciante = denunciaObject.getEmailDenunciante();
		this.telefonePrincipal = denunciaObject.getTelefonePrincipal();
		this.telefoneAuxiliar = denunciaObject.getTelefoneAuxiliar();
		this.nomeDenunciante = denunciaObject.getNomeDenunciante();
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

	@Override
	public String getResourceType() {
		return Denuncia.class.toString();
	}

	@Override
	public String getEntityDescription() {
		return "Registro de Denuncia";
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public String getEnderecoReferencia() {
		return enderecoReferencia;
	}

	public void setEnderecoReferencia(String enderecoReferencia) {
		this.enderecoReferencia = enderecoReferencia;
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
