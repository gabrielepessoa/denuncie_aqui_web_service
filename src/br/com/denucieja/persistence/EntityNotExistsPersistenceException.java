package br.com.denucieja.persistence;

import javax.persistence.PersistenceException;

public class EntityNotExistsPersistenceException extends PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3005732568174072884L;
	
	private String entityName = "";
	
	public EntityNotExistsPersistenceException() {}
	
	public EntityNotExistsPersistenceException(String entityName) {
		super();
		
		this.entityName = entityName;
	}
	
	public EntityNotExistsPersistenceException(String entityName, String message) {
		super(message);
		
		this.entityName = entityName;
	}
	
	public EntityNotExistsPersistenceException(String entityName, String message, Throwable cause) {
		super(message, cause);
		
		this.entityName = entityName;
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	
}
