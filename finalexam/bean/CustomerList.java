// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: ExamFinal
// Programmer: Craig Wright
// ===================================


package edu.cscc.csci2469.finalexam.bean;


import java.util.List;


/**
 * -
 */
public class CustomerList extends ApplicationBean {

    /** - */
    private static final long serialVersionUID = 4584303288168589537L;


    /** - */
    private List<Customer> list;


    /**
     * -
     * 
     * @param list -
     */
    public CustomerList(final List<Customer> list) {
        this.list = list;
    }


    /**
     * -
     * 
     * @return -
     */
    public List<Customer> getList() {
        return list;
    }
}
