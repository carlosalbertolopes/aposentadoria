package br.com.aposentadoria.daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.mail.imap.protocol.ID;

@Stateless
@Named("baseDao")
public class GenericDaoMysql<T> implements GenericDao<T> {
	
	    @PersistenceContext
	    private EntityManager entityManager;
	 
	    public EntityManager getEntityManager() {
	        return entityManager;
	    }
	    private Class<T> persistClass;
	 
	    public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	 
	    public void delete(ID id) {
	        Object ref = this.entityManager.getReference(persistClass, id);
	        this.entityManager.remove(ref);
	    }
	 
	    public T update(T t) {
	        return (T) this.entityManager.merge(t);
	    }
	 
	    public void insert(T t) {
	        this.entityManager.persist(t);
	    }
	 

	    @SuppressWarnings("unchecked")
		public GenericDaoMysql() {
			this.persistClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}

		public void persistirEntidade(T entity){ 
			entityManager.persist(entity);
			entityManager.flush();
		}

		public void excluirEntidade(T entity) {
			entityManager.remove(entity);
		}

		public void updateEntidade(T entity){
			entityManager.merge(entity);
			entityManager.flush();
		}


		@Override
		@TransactionAttribute(TransactionAttributeType.SUPPORTS)
		public T pesquisarPorId(Serializable id) {
	        return (T) this.entityManager.find(persistClass, id);
		}

		@Override
		@TransactionAttribute(TransactionAttributeType.SUPPORTS)
		@SuppressWarnings("unchecked")
		public List<T> getAll() {
			List<T> list = entityManager.createQuery("Select entity FROM "+persistClass.getSimpleName() +" entity").getResultList();
	        return list;
	    }
}
