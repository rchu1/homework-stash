// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Craig Wright
// ===================================


package edu.cscc.csci2469.finalexam.common;


import java.io.Serializable;

import edu.cscc.csci2469.finalexam.bean.ApplicationBean;
import edu.cscc.csci2469.finalexam.bean.Customer;


/** - */
public class ActionRequest implements Serializable {

    /** - */
    private static final long serialVersionUID = -6575227875965727458L;


    /** - */
    private String action;


    /** - */
    private ApplicationBean data;


    /**
     * -
     * 
     * @param action -
     * @param data -
     */
    public ActionRequest(final String action, final ApplicationBean data) {
        super();
        this.action = action;
        this.data = data;
    }


    /**
     * -
     * 
     * @return the action
     */
    public String getAction() {
        return action;
    }


    /**
     * -
     * 
     * @param action the action to set
     */
    public void setAction(final String action) {
        this.action = action;
    }


    /**
     * -
     * 
     * @return the data
     */
    public ApplicationBean getData() {
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
}
