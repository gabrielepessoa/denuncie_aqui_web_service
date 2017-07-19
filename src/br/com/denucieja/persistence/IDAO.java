package br.com.denucieja.persistence;

import java.util.List;

import br.com.denucieja.model.misc.IEntity;

public interface IDAO<T extends IEntity> {
	
	public Class<T> getGenericClass();
	
	public void insertNoAudit(T t);

	public boolean exists(long id);
	
	public void updateNoAudit(T t);
	
	public void deleteNoAudit(long id);

	public T get(long id);
	
	public List<T> list();

}
