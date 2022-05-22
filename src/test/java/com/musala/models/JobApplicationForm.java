package com.musala.models;

import java.io.File;

public class JobApplicationForm {

    private String name = "";
    private String email = "";
    private String  mobile;
    private File CV ;
    private String linkedinProfileLink = "";
    private String yourMessage = "";


    public JobApplicationForm(String name, String email, String mobile, File CV, String linkedinProfileLink, String yourMessage) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.CV = CV;
        this.linkedinProfileLink = linkedinProfileLink;
        this.yourMessage = yourMessage;
    }


    public JobApplicationForm() {

    }

    public JobApplicationForm mobile(String  mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public JobApplicationForm name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public JobApplicationForm email(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public JobApplicationForm CV(File CV) {
        this.CV = CV;
        return this;
    }

    public File getCV() {
        return CV;
    }

    public JobApplicationForm linkedinProfileLink(String linkedinProfileLink) {
        this.linkedinProfileLink = linkedinProfileLink;
        return this;
    }

    public String getLinkedinProfileLink() {
        return linkedinProfileLink;
    }
    public JobApplicationForm yourMessage(String yourMessage) {
        this.yourMessage = yourMessage;
        return this;
    }

    public String getYourMessage() {
        return yourMessage;
    }

    public JobApplicationForm build() {
        return new JobApplicationForm(name, email,mobile, CV,linkedinProfileLink, yourMessage);
    }
}