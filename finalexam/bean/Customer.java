// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Craig Wright
// ===================================


package edu.cscc.csci2469.finalexam.bean;


/**
 * This class implements a "bean" object that represents a customer.
 */
public class Customer extends ApplicationBean {
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = -6367029663088939151L;


    /**
     * Holds the customer's customerId
     */
    private String customerId;


    /**
     * Holds the customer's first name
     */
    private String firstName;


    /**
     * Holds the customer's last name
     */
    private String lastName;


    /**
     * Holds the customer's street address
     */
    private String streetAddress;


    /**
     * Holds the customer's city
     */
    private String city;


    /**
     * Holds the customer's state
     */
    private String state;


    /**
     * Holds the customer's zip code
     */
    private String zip;


    /**
     * Holds the customer's phone number
     */
    private String phone;


    /**
     * This constructor method constructs an instance of <var>Customer</var>
     *
     * @param customerId customer's customerId
     * @param lastName customer's last name
     * @param firstName customer's first name
     * @param streetAddress customer's street address
     * @param city customer's city
     * @param state customer's state
     * @param zip customer's zip
     * @param phone customer's phone
     */
    public Customer(String customerId, String lastName, String firstName, String streetAddress, String city, String state, String zip, String phone) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }


    /**
     * This method returns the value of the internal variable, phone
     *
     * @return the cellPhone
     */
    public String getPhone() {
        return phone;
    }


    /**
     * This method returns the value of the internal variable, city
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }


    /**
     * This method returns the value of the internal variable, customerId
     *
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }


    /**
     * This method returns the value of the internal variable, firstName
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * This method returns the value of the internal variable, lastName
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * This method returns the value of the internal variable, state
     *
     * @return the state
     */
    public String getState() {
        return state;
    }


    /**
     * This method returns the value of the internal variable, streetAddress
     *
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }


    /**
     * This method returns the value of the internal variable, zip
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }


    /**
     * This method saves the supplied value in the internal variable, phone.
     *
     * @param phone the cellPhone value to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * This method saves the supplied value in the internal variable, city.
     *
     * @param city the city value to set
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * This method saves the supplied value in the internal variable, customerId.
     *
     * @param customerId the customerId value to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    /**
     * This method saves the supplied value in the internal variable, firstName.
     *
     * @param firstName the firstName value to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * This method saves the supplied value in the internal variable, lastName.
     *
     * @param lastName the lastName value to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * This method saves the supplied value in the internal variable, state.
     *
     * @param state the state value to set
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     * This method saves the supplied value in the internal variable, streetAddress.
     *
     * @param streetAddress the streetAddress value to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    /**
     * This method saves the supplied value in the internal variable, zip.
     *
     * @param zip the zip value to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    @Override
    public String toString() {
        return String.format("[CustomerId='%s', LastName='%s', firstName='%s', streetAddress='%s', city='%s', state='%s', zip='%s', phone='%s']",
                             customerId, lastName, firstName, streetAddress, city, state, zip, phone);
    }
}
