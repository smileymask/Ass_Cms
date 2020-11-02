package Cms;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Contestant {
    String name; 
    String id;
    String email;
    String mobilephone;
    int rank;

    public Contestant() {
    }

    public Contestant(String name, String id, String email, String mobilephone, int rank) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.mobilephone = mobilephone;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return  name + "\t" + id + "\t" + email + "\t" + mobilephone + "\t" + rank;
    }
    
}
