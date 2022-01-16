// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Craig Wright
// ===================================


package edu.cscc.csci2469.finalexam.common;


import java.io.Serializable;

import edu.cscc.csci2469.finalexam.bean.Customer;


/** - */
public class ActionResponse implements Serializable {

    /** - */
    private static final long serialVersionUID = -1048475411567653135L;

    
    /** - */
    private String table;
    

    /** - */
    private String status;


    /** - */
    private Object data;


    /**
     * -
     * 
     * @param table -
     * @param status -
     * @param data -
     */
    public ActionResponse(final String table, final String status, final Object data) {
        this.table = table;
        this.status = status;
        this.data = data;
    }


    /**
     * -
     * 
     * @return the data
     */
    public Object getData() {
        return data;
    }


    /**
     * -
     * 
     * @param data the data to set
     */
    public void setData(final Customer data) {
        this.data = data;
    }


    /**
     * -
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }


    /**
     * -
     * 
     * @param table the table to set
     */
    public void setTable(final String table) {
        this.table = table;
    }
    /**
     * -
     * 
     * @return the table
     */
    public String getTable() {
        return table;
    }


    /**
     * -
     * 
     * @param status the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }
}
