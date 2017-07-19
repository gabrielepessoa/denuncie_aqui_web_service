package br.com.denucieja.persistence;

import javax.persistence.PersistenceException;

public class EntityAlreadyExistsPersistenceException extends PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3005732568174072884L;
	
	private String entityName = "";
	
	public EntityAlreadyExistsPersistenceException() {}
	
	public EntityAlreadyExistsPersistenceException(String entityName) {
		super();
		
		this.entityName = entityName;
	}
	
	public EntityAlreadyExistsPersistenceException(String entityName, String message) {
		super(message);
		
		this.entityName = entityName;
	}
	
	public EntityAlreadyExistsPersistenceException(String entityName, String message, Throwable cause) {
		super(message, cause);
		
		this.entityName = entityName;
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	
}
