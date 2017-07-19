package br.com.denucieja.object.generic;
/**
 * Classe criada para utilizar em comboBox no android, afim de facilitar sua exibição
 * @author Marconi Motta
 *
 */
public class GenericTO {

	private String label;
	private String value;
	
	public GenericTO(String label, String value){
		this.label = label;
		this.value = value;
	}
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
