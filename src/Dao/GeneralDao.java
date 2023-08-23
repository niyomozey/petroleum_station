/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Moise Niyonkuru
 */
public class GeneralDao<T> {

    private final Class<T> entityClass;

    public GeneralDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public boolean create(T entity) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(T entity) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(T entity) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(entityClass);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
//    public List<Object[]> getTransactionCountPerDriver() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            String sqlQuery = "SELECT d.driver_id, d.driver_name, COUNT(ft.transaction_id) " +
//                              "FROM drivers d " +
//                              "JOIN fuel_transactions ft ON d.driver_id = ft.driver_id " +
//                              "GROUP BY d.driver_id, d.driver_name";
//
//            Query<Object[]> query = session.createNativeQuery(sqlQuery);
//            List<Object[]> results = query.getResultList();
//
//            return results;
//        } finally {
//            session.close();
//        }
//    }
//    
}
