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
public class OrderList extends ApplicationBean {

    /** - */
    private static final long serialVersionUID = 2037998649454524316L;


    /** - */
    private List<Order> list;


    /**
     * -
     * 
     * @param list -
     */
    public OrderList(final List<Order> list) {
        this.list = list;
    }


    /**
     * -
     * 
     * @return -
     */
    public List<Order> getList() {
        return list;
    }
}
