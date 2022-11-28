package utils;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class JpaRespository<E, K> {

    private Class<E> entityClass;

    public JpaRespository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Object excuteQueryList(String jpql, boolean isjpql, Class<?> classResult, Map<String, Object> param)
            throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        if (classResult == null) {
            classResult = Object.class;
        }
        Query query;
        if (isjpql) {
            query = entityManager.createQuery(jpql, classResult);
        } else {
            query = entityManager.createNativeQuery(jpql, classResult);
        }
        if (param instanceof Map<String, Object>) {
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                String key = entry.getKey();
                Object val = entry.getValue();
                query.setParameter(key, val);
            }
        }
        return query.getResultList();
    }

    public Object excuteQuerySingleResult(String jpql, boolean isjpql, Class<?> classResult, Map<String, Object> param)
            throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        if (classResult == null) {
            classResult = Object.class;
        }
        Query query;
        if (isjpql) {
            query = entityManager.createQuery(jpql, classResult);
        } else {
            query = entityManager.createNativeQuery(jpql, classResult);
        }
        if (param instanceof Map<String, Object>) {
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                String key = entry.getKey();
                Object val = entry.getValue();
                query.setParameter(key, val);
            }
        }
        return query.getSingleResult();
    }

    public List<E> findAll() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = criteriaBuilder.createQuery(entityClass);
        query.select(query.from(entityClass));
        TypedQuery<E> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public List<E> findAll(int first, int size) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = criteriaBuilder.createQuery(entityClass);
        query.select(query.from(entityClass));
        TypedQuery<E> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(first);
        typedQuery.setMaxResults(size);
        return typedQuery.getResultList();
    }

    public E findByID(K key) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        return entityManager.find(entityClass, key);
    }

    public void insert(E entity) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            entityManager.refresh(entity);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void update(E entity) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void remove(K key) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            E e = entityManager.find(entityClass, key);
            entityManager.getTransaction().begin();
            entityManager.remove(e);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public Long count() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<E> root = query.from(entityClass);
        query.select(criteriaBuilder.count(root));
        TypedQuery<Long> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

    public List<E> findByTypeEqual(int i) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = criteriaBuilder.createQuery(entityClass);
        Root root = query.from(entityClass);
        query.select(root);
        query.where(criteriaBuilder.equal(root.get("type"), i));
        TypedQuery<E> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public List<E> findByTypeNotEqual(int i) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = criteriaBuilder.createQuery(entityClass);
        Root root = query.from(entityClass);
        query.select(root);
        query.where(criteriaBuilder.notEqual(root.get("type"), i));
        TypedQuery<E> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public void setType(K id, int type) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<E> update = builder.createCriteriaUpdate(entityClass);
        Root root = update.from(entityClass);
        update.set("type", type);
        update.where(builder.equal(root.get("id"), id));
        Query query = entityManager.createQuery(update);
        try {
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

    }

}
