package br.com.denucieja.model.denuncia;

/**
 * 
 * @author Lisandra
 *
 */
public enum TipoDenuncia {

	SEGURANCA("Reclama��o de Falta de Seguran�a"),
	INFRAESTRUTURA("Reclama��o de Falta de Infra-Estrutura"),
	FALTA_AGUA("Falta de �gua"),
	FALTA_ENERGIA("Falta de energia"),
	FIACAO_IRREGULAR("Fia��o irregular"),
	ILUMINACAO_PUBLICA_IRREGULAR("Ilumina��o p�blica irregular"),
	ASSALTO("Assalto"),
	DROGAS("Drogas"),
	FALTA_POLICIAMENTO("Falta de Policiamento"),
	HOMICIDIO("Homic�cio"),
	INVASAO_PROPRIEDADE_PARTICULAR("Invas�o em propriedade particular"),
	OCUPACAO_LOCAL_PUBLIC("Ocupa��o de local p�blico");

	private String value;

	private TipoDenuncia(String value){
		this.value = value;
	}

	public static TipoDenuncia findByName(String name){
		for(TipoDenuncia v : values()){
			if( v.toString().equals(name) || v.getValue().equals(name)){
				return v;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
