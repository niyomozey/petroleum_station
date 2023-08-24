/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Dao.GeneralDao;
import Domain.Car;
import Domain.Transactions;
import Util.ExportPdf;
import Util.HibernateUtil;
import java.util.Date;
import java.time.LocalDate;
import org.hibernate.Session;

/**
 *
 * @author Moise Niyonkuru
 */
public class TestClass {

    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Car driver = new Car();
//        driver.setNom("Nzaramba Theonest");
//        driver.setPlaque("RAB120E");
//        driver.setTelephone("0780644280");
//        GeneralDao dao = new GeneralDao<>(Car.class);
//        dao.create(driver);
//        Transactions trans = new Transactions(1, 10.5, "benzeni", new Date(), driver);
////        trans.setDate(Date.valueOf(LocalDate.now()));
//        System.out.println("Today:" + LocalDate.now());
//        GeneralDao trans_dao = new GeneralDao<>(Car.class);
//        trans_dao.create(trans);
//ExportPdf export = new ExportPdf();
//        export.generateRaport();
    }
}
