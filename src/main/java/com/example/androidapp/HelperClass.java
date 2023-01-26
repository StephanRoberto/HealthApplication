package com.example.androidapp;

public class HelperClass {
    String name, email, phone, password, datepick, gen, type, aage, wweight, hheight, yes, no;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    public String getDate() {
        return datepick;
    }
    public void setDate(String datepick) {
        this.datepick = datepick;
    }

    public String getGender() {
        return gen;
    }
    public void setGender(String gen) {
        this.gen = gen;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return aage;
    }
    public void setAge(String aage) {
        this.aage = aage;
    }

    public String getWeight() {
        return wweight;
    }
    public void setWeight(String wight) {
        this.wweight = wweight;
    }

    public String getHheight() {
        return hheight;
    }
    public void setHheight(String hheight) {
        this.hheight = hheight;
    }

    public String getYes() {
        return yes;
    }
    public void setYes(String Yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }


    public HelperClass(String name, String email, String phone, String password, String datepick, String gen, String type, String aage, String wweight, String hheight, String yes, String no) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.datepick = datepick;
        this.gen = gen;
        this.type = type;
        this.aage = aage;
        this.wweight = wweight;
        this.hheight = hheight;
        this.yes = yes;
        this.no = no;


    }
    public HelperClass() {
    }
}
