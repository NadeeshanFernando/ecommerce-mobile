package edu.demo.livedinner.model;


public class Reservation {

    private int id;

    private String firstname;

    private String email;

    private String phone;

    private int numguest;

    private String date;

    private String time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public int getNumguest() {
        return numguest;
    }

    public void setNumguest(int numguest) {
        this.numguest = numguest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Reservation(int id, String firstname, String email, String phone, int numguest, String date, String time) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.numguest = numguest;
        this.date = date;
        this.time = time;
    }

    public Reservation(String firstname, String email, String phone, int numguest, String date, String time) {
        super();
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.numguest = numguest;
        this.date = date;
        this.time = time;
    }

    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }


}

