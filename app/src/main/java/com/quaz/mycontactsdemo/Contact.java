package com.quaz.mycontactsdemo;

public class Contact {

    private int id;
    private String image;
    private String fistName;
    private String lastName;
    private String email;
    private String phoneNumber;


    public Contact(String image, String fistName, String lastName, String email, String phoneNumber) {
        this.image = image;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
