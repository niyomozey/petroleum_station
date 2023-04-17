/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Moise Niyonkuru
 */
@Entity
public class Driver {
    @Id
    private int id;
    private String nom;
    private double quantity;
    private String CarType;
    private double product;
    private Date date;
    private String telephone;
    private String plaque;

    public Driver() {
    }

    public Driver(int id, String nom, double quantity, String CarType, double product, Date date, String telephone, String plaque) {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.CarType = CarType;
        this.product = product;
        this.date = date;
        this.telephone = telephone;
        this.plaque = plaque;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public double getProduct() {
        return product;
    }

    public void setProduct(double product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }
    
}
