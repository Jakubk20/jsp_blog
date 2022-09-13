package com.testarmy.jsp_blog.Dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.function.Consumer;

public class Dao {
    protected static EntityManager entityManager =
            Persistence.
                    createEntityManagerFactory("blog").
                    createEntityManager();

    public static <T> void inTransaction(Consumer<T> consumer, T object) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        consumer.accept(object);
        entityTransaction.commit();

    }
    public static void save(Object entity){
        inTransaction(entityManager::persist, entity);
    }
    public static void update(Object entity){
        inTransaction(entityManager::persist, entity);
    }
    public static void delete(Object entity){
        inTransaction(entityManager::remove, entity);
    }

    public static <T> T loadById(Class<T> clazz, int id){
        return  entityManager.find(clazz, id);
    }
    public static <T> List<T> loadAll(Class<T> clazz){
        return entityManager.
                createQuery("from " + clazz.getSimpleName()
                        , clazz).getResultList();
    }
}
