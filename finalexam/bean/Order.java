// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Craig Wright
// ===================================


package edu.cscc.csci2469.finalexam.bean;


/**
 * This class implements a "bean" object that represents a order.
 */
public class Order extends ApplicationBean {
    /**
     * 
     */
    private static final long serialVersionUID = -3712537630805778254L;


    /**
     * Holds the customerId value
     */
    private String customerId;


    /**
     * Holds the orderId value
     */
    private String orderId;


    /**
     * Holds the orderDate value
     */
    private String orderDate;


    /**
     * Holds the type of problem (COOL, HEAT, BOTH)
     */
    private String type;


    /**
     * Holds details of the problem
     */
    private String details;


    /**
     * This constructor method builds an instance of <var>Order</var>
     * 
     * @param customerId the customer's customerId
     * @param orderId orderId
     * @param orderDate orderDate
     * @param type type of problem (COOL, HEAT, BOTH)
     * @param details details of problem
     * @throws IllegalArgumentException thrown when type contains invalid data
     */
    public Order(String customerId, String orderId, String orderDate, String type, String details) throws IllegalArgumentException {
        if (!"COOL".equalsIgnoreCase(type) && !"BOTH".equalsIgnoreCase(type) && !"HEAT".equalsIgnoreCase(type)) {
            throw new IllegalArgumentException("Illegal data for field 'type' - " + type);
        }

        this.customerId = customerId;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.type = type;
        this.details = details;
    }


    /**
     * This method retrieves the customerId value
     * 
     * @return customerId value
     */
    public String getCustomerId() {
        return customerId;
    }


    /**
     * This method retrieves the details value
     * 
     * @return details value
     */
    public String getDetails() {
        return details;
    }


    /**
     * This method retrieves the orderDate value
     * 
     * @return orderDate value
     */
    public String getOrderDate() {
        return orderDate;
    }


    /**
     * This method retrieves the orderId value
     * 
     * @return orderId value
     */
    public String getOrderId() {
        return orderId;
    }


    /**
     * This method retrieves the problem type value
     * 
     * @return problem type value (COOL, HEAT, BOTH)
     */
    public String getType() {
        return type;
    }


    /**
     * This method sets the customerId
     * 
     * @param customerId the value to be used
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    /**
     * This method sets the problem details value
     * 
     * @param details the value to be used
     */
    public void setDetails(String details) {
        this.details = details;
    }


    /**
     * This method sets the orderDate value
     * 
     * @param orderDate the value to be used
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    /**
     * This method sets the orderId value
     * 
     * @param orderId the value to be used
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    /**
     * This method sets the problem type value
     * 
     * @param type the value to be used
     */
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return String.format("[CustomerId='%s', orderId='%s', orderDate='%s', type='%s', details='%s']",
                             customerId, orderId, orderDate, type, details);
    }
}
