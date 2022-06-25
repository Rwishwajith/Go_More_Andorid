package com.example.asus.finaltime;

public class Heritage {
    private String name;
    private String date;
    private String phone;
    private String email;
    private String select;
    private String people;

    public Heritage() {
    }

    public Heritage(String name, String date, String phone, String email, String select, String people) {
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.select = select;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
