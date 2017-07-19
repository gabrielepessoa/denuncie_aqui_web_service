package br.com.denucieja.persistence;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.denucieja.model.misc.IEntity;

/**
 * Classe com os metodos genericos de insert, update, get, list e delete.
 * @author Marconi Motta
 *
 * @param <T>
 */
public abstract class GenericDAO<T extends IEntity> implements IDAO<T> {


	private SessionFactory sessionFactory;

	public GenericDAO(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public Class<T> getGenericClass() {
		Class<T> result = null;
		Type type = this.getClass().getGenericSuperclass();

		if(type instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType) type;
			Type[] fieldArgTypes = pt.getActualTypeArguments();
			result = (Class<T>) fieldArgTypes[0];
		}

		return result;
	}

	public abstract boolean exists(T t);

	@Transactional
	public final void insertNoAudit(T t) {
		if (t == null || exists(t)) {
			throw new EntityAlreadyExistsPersistenceException(getGenericClass().getSimpleName());
		}

		Session session = sessionFactory.getCurrentSession();

		session.save(t);
	}

	public boolean exists(long id) {
		Session session = sessionFactory.getCurrentSession();

		return session.createCriteria(getGenericClass()).add(Restrictions.eq("id", id)).list().size() > 0;
	}

	@Transactional
	public final void updateNoAudit(T t) {
		if (t == null || !exists(t.getId())) {
			throw new EntityNotExistsPersistenceException(getGenericClass().getSimpleName());
		}

		Session session = sessionFactory.getCurrentSession();

		session.merge(t);
	}

	@Transactional
	public final void deleteNoAudit(long id) {
		T t = get(id);

		Session session = sessionFactory.getCurrentSession();

		session.delete(t);
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public T get(long id) {
		Session session = sessionFactory.getCurrentSession();

		T result = (T) session.get(getGenericClass(), id);

		if (result == null) {
			throw new EntityNotExistsPersistenceException(getGenericClass().getName());
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> list() {
		Session session = sessionFactory.getCurrentSession();

		return session.createCriteria(getGenericClass()).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
