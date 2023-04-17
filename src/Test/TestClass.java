/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Dao.GeneralDao;
import Domain.Driver;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Moise Niyonkuru
 */
public class TestClass {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Driver driver = new Driver();       
        driver.setId(1234);
        driver.setNom("Nzaramba Theonest");
        driver.setPlaque("RAB120E");
        GeneralDao dao = new GeneralDao<>(Driver.class);
        dao.create(driver);
    }
}
