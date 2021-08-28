package com.company.model;

public class Customer {
    private int id;
    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private String adresa;
    private User user;

    public Customer() {

    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String nume, String prenume, String telefon, String email, String adresa, User user) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
        this.user = user;
    }

    public Customer(String nume, String prenume, String telefon, String email, String adresa, User user) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa=adresa;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                ", user=" + user +
                '}';
    }
}
