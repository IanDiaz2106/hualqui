package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import tablas.Apelacion;
import utils.HibernateUtils;

public class ApelacionesDAO {

    /**
     * Save User
     * @param user
     */
    public void saveApelacion(Apelacion apelacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(apelacion);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update User
     * @param user
     */
    public void updateApelacion(Apelacion apelacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(apelacion);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete User
     * @param id
     */
    public void deleteApelacion(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Apelacion apelacion = session.get(Apelacion.class, id);
            if (apelacion != null) {
                session.delete(apelacion);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get User By ID
     * @param id
     * @return
     */
    public Apelacion getApelacion(int id) {

        Transaction transaction = null;
        Apelacion apelacion = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            apelacion = session.get(Apelacion.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return apelacion;
    }

    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Apelacion > getAllApelacion() {

        Transaction transaction = null;
        List < Apelacion > listOfUser = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from User").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
}