package org.selenium.pom.Objects;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String billingAddressOne;
    private String billingAddressCity;
    private String billingAddressPostalCode;
    private String billingAddressEmail;

    public BillingAddress(){

    }

    public BillingAddress(String firstName, String lastName, String billingAddressOne, String billingAddressCity, String billingAddressPostalCode, String billingAddressEmail) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.billingAddressOne = billingAddressOne;
//        this.billingAddressCity = billingAddressCity;
//        this.billingAddressPostalCode = billingAddressPostalCode;
//        this.billingAddressEmail = billingAddressEmail;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingAddressOne() {
        return billingAddressOne;
    }

    public void setBillingAddressOne(String billingAddressOne) {
        this.billingAddressOne = billingAddressOne;
    }

    public String getBillingAddressCity() {
        return billingAddressCity;
    }

    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }

    public String getBillingAddressPostalCode() {
        return billingAddressPostalCode;
    }

    public void setBillingAddressPostalCode(String billingAddressPostalCode) {
        this.billingAddressPostalCode = billingAddressPostalCode;
    }

    public String getBillingAddressEmail() {
        return billingAddressEmail;
    }

    public void setBillingAddressEmail(String billingAddressEmail) {
        this.billingAddressEmail = billingAddressEmail;
    }





}
