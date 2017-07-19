package br.com.denucieja.model.denuncia;

/**
 * 
 * @author Lisandra
 *
 */
public enum TipoDenuncia {

	SEGURANCA("Reclamação de Falta de Segurança"),
	INFRAESTRUTURA("Reclamação de Falta de Infra-Estrutura"),
	FALTA_AGUA("Falta de Água"),
	FALTA_ENERGIA("Falta de energia"),
	FIACAO_IRREGULAR("Fiação irregular"),
	ILUMINACAO_PUBLICA_IRREGULAR("Iluminação pública irregular"),
	ASSALTO("Assalto"),
	DROGAS("Drogas"),
	FALTA_POLICIAMENTO("Falta de Policiamento"),
	HOMICIDIO("Homicício"),
	INVASAO_PROPRIEDADE_PARTICULAR("Invasão em propriedade particular"),
	OCUPACAO_LOCAL_PUBLIC("Ocupação de local público");

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
