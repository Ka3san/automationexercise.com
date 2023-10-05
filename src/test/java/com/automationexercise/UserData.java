package com.automationexercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class UserData {
    private String name;
    private String email;
    private String title;
    private String password;
    private String dateOfBirth;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;

    public UserData(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getName() {
        return name;
    }

    public UserData setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    // TODO: enable or disable random email
    public UserData setEmail(String email) {
//        this.email = email;
        this.email = UUID.randomUUID() + "@gmail.com";
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UserData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public UserData setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public UserData setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserData setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public UserData setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserData setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getState() {
        return state;
    }

    public UserData setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserData setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public UserData setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public UserData setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }
}
