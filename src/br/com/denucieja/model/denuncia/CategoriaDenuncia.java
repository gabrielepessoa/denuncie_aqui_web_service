package br.com.denucieja.model.denuncia;

/**
 * 
 * @author Gabriele
 *
 */
public enum CategoriaDenuncia {
/**
 * Atualmente apenas com 2 categorias cadastradas, apenas para testes, após isso, outras categorias serão liberadas
 */
	AGUA_E_ENERGIA("Água e Energia","Água e Energia"),
	SEGURANCA("Segurança","Segurança");
	
	
	private String label;
	private String value;
	
	private CategoriaDenuncia(String label, String value){
		this.label = label;
		this.value = value;
	}
	
	public static CategoriaDenuncia findByName(String name){
	    for(CategoriaDenuncia v : values()){
	        if( v.toString().equals(name) || v.getLabel().equals(name) || v.getValue().equals(name)){
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
