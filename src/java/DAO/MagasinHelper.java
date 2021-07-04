/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;
import java.sql.*;
import java.math.BigDecimal;

/**
 *
 * @author faycal
 */
public class MagasinHelper {

    Session session = null;

    public List<String> getColonnes() {
        return colonnes;
    }
    ArrayList<String> colonnes = new ArrayList();

    public MagasinHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public List getClients() {
        List<Customer> resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select a.customerId, a.name, a.addressline1,a.addressline2,a.zip,b.rate from Customer a, DiscountCode b where a.discountCode=b.discountCode");
            //Query q=session.createQuery("from Customer");
            resultat = q.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

    public List getManufactures() {
        List<Customer> resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select manufacturerId, name, addressline1, addressline2, city, state, zip, phone, fax, email, rep from Manufacturer");
            //Query q=session.createQuery("from Customer");
            resultat = q.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

    public List getProduits() {
        List<Customer> resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select p.productId, m.name, p.productCode, p.purchaseCost, p.quantityOnHand, p.markup, p.available, p.description from Manufacturer m, Product p where p.manufacturerId=m.manufacturerId");
            //Query q=session.createQuery("from Customer");
            resultat = q.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

    public int getLastCustomerID() {
        int ID = 0;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Query q = session.createQuery("select MAX(customerId) from Customer");
            ID = (int) q.list().iterator().next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return ID;
    }

    public int getLastManufactID() {
        int ID = 0;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Query q = session.createQuery("select MAX(manufacturerId) from Manufacturer");
            ID = (int) q.list().iterator().next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return ID;
    }
    
    public int getLastProductID() {
        int ID = 0;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Query q = session.createQuery("select MAX(productId) from Product");
            ID = (int) q.list().iterator().next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return ID;
    }

    public List getClients(String name) {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select a.customerId, a.name, a.addressline1,a.addressline2,a.zip,b.rate from Customer a, DiscountCode b where a.discountCode=b.discountCode and a.name like :_name");
            //Query q=session.createQuery("from Customer");
            q.setString("_name", "%%" + name + "%%");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

    public List getManufactures(String name) {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select manufacturerId, name, addressline1, addressline2, city, state, zip, phone, fax, email, rep from Manufacturer where name like :_name");
            //Query q=session.createQuery("from Customer");
            q.setString("_name", "%%" + name + "%%");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

    public List getProducts(String name) {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select productId, productCode, purchaseCost, quantityOnHand, markup, available, description from Product where description like :_name");
            //Query q=session.createQuery("from Customer");
            q.setString("_name", "%%" + name + "%%");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

    public List getClientsById(String id) {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select a.customerId, a.name, a.addressline1,a.addressline2,a.zip from Customer a where  a.customerId = :_id");
            //Query q=session.createQuery("from Customer");
            q.setString("_id", id);
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

    public List getDiscountCode() {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select a.discountCode from DiscountCode a");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }

        }

        return resultat;

    }

    public List getProductCode() {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select a.prodCode from ProductCode a");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }

        }
        return resultat;
    }
    
    public List getManId() {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select a.manufacturerId from Manufacturer a");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }

        }
        return resultat;
    }

    public List getMicroMarket() {
        List<MicroMarket> resultat = null;
        Transaction tx = null;
        try {
            //if(!session.isOpen())
            session = HibernateUtil.getSessionFactory().openSession();
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("from MicroMarket");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }

        }
        return resultat;
    }

    public List getZipCode() {
        List resultat = null;
        Transaction tx = null;
        try {
            //if(!session.isOpen())
            session = HibernateUtil.getSessionFactory().openSession();
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery("select a.zipCode from MicroMarket a");
            resultat = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }

        }
        return resultat;
    }

    public void insertCustomer(String _nom, String _adresse1, String _adresse2, String _tel, String _email, char _discountCode, String _zip) {
        int id = getLastCustomerID() + 1;

        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Customer a = new Customer(id, _nom, _adresse1, _adresse2, _tel, _email, _discountCode, _zip);
            session.save(a);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void insertManufacturer(String _nom, String _adresse1, String _adresse2, String _ville, String _state, String _cp, String _phone, String _fax, String _mail, String _rep) {
        int id = getLastManufactID() + 1;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Manufacturer a = new Manufacturer(id, _nom, _adresse1, _adresse2, _ville, _state, _cp, _phone, _fax, _mail, _rep);
            session.save(a);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void insertProduct(String manIdString, String code, String cost, String quantity, String markup, String available, String description) {
        int id = getLastProductID() + 1;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            int manId = Integer.valueOf(manIdString);
            Product a = new Product(id, manId, code, new BigDecimal(cost), Integer.valueOf(quantity), new BigDecimal(markup), available, description);
            session.save(a);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateCustomer(int _customerId, String _name, String _adress1, String _adress2, String _phone, String _email, char _discountCode, String _zip) {

        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Customer a = new Customer(_customerId, _name, _adress1, _adress2, _phone, _email, _discountCode, _zip);
            session.update(a);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void updateManufacturer(int id, String _nom, String _adresse1, String _adresse2, String _ville, String _state, String _cp, String _phone, String _fax, String _mail, String _rep) {

        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Manufacturer a = new Manufacturer(id, _nom, _adresse1, _adresse2, _ville, _state, _cp, _phone, _fax, _mail, _rep);
            session.update(a);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void updateProduct(int id, String manIdString, String code, String cost, String quantity, String markup, String available, String description) {

        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            int manId = Integer.valueOf(manIdString);
            Product a = new Product(id, manId, code, new BigDecimal(cost), Integer.valueOf(quantity), new BigDecimal(markup), available, description);
            session.update(a);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public Customer getClient(int id) {

        Customer client = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Query q = session.createQuery(" from Customer a  where a.customerId =:_id");
            q.setInteger("_id", id);
            client = (Customer) q.list().iterator().next();
        } catch (Exception e) {
            System.out.println("erreur toto" + e);
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return client;
    }

    public Customer getClient(String name) {

        Customer client = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Query q = session.createQuery(" from Customer a  where a.customerId =:_name");
            q.setString("_name", name);
            client = (Customer) q.list().iterator().next();
        } catch (Exception e) {
            System.out.println("erreur toto" + e);
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return client;
    }

    public Manufacturer getManufact(String id) {

        Manufacturer man = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Query q = session.createQuery(" from Manufacturer m  where m.manufacturerId =:_name");
            q.setString("_name", id);
            man = (Manufacturer) q.list().iterator().next();
        } catch (Exception e) {
            System.out.println("erreur toto" + e);
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return man;
    }

    public Product getProd(String id) {

        Product prod = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();
            tx = session.beginTransaction();
            Query q = session.createQuery(" from Product p  where p.productId =:_name");
            q.setString("_name", id);
            prod = (Product) q.list().iterator().next();
        } catch (Exception e) {
            System.out.println("erreur toto" + e);
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return prod;
    }

    public void deleteCustomer(int _id) {

        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery(" from Customer a where a.customerId =:_id");
            q.setInteger("_id", _id);
            session.delete((Customer) q.list().iterator().next());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void deleteManufacturer(int _id) {

        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery(" from Manufacturer a where a.manufacturerId =:_id");
            q.setInteger("_id", _id);
            session.delete((Manufacturer) q.list().iterator().next());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void deleteProduct(int _id) {

        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery(" from Product a where a.productId =:_id");
            q.setInteger("_id", _id);
            session.delete((Product) q.list().iterator().next());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public List<PurchaseOrder> getAchats(int id) {
        List resultat = null;
        Transaction tx = null;
        try {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
            session.flush();

            tx = session.beginTransaction();
            Query q = session.createQuery(" from PurchaseOrder  a where a.customerId=:_id");
            q.setInteger("_id", id);
            resultat = (List<PurchaseOrder>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return resultat;
    }

}
