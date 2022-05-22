package com.musala.models;

public class ContactUsForm {

    private String name = "";
    private String email = "";
    private String  mobile;
    private String subject = "";
    private String yourMessage = "";


    public ContactUsForm(String name, String email, String mobile, String subject, String yourMessage) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.subject = subject;
        this.yourMessage = yourMessage;
    }


    public ContactUsForm() {

    }

    public ContactUsForm mobile(String  mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public ContactUsForm name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContactUsForm email(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactUsForm subject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ContactUsForm yourMessage(String yourMessage) {
        this.yourMessage = yourMessage;
        return this;
    }

    public String getYourMessage() {
        return yourMessage;
    }

    public ContactUsForm build() {
        return new ContactUsForm(name, email,mobile, subject, yourMessage);
    }
}