//===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: ExamFinal
// Programmer: Craig Wright
//===================================

package edu.cscc.csci2469.finalexam.bean;

/**
 * -
 */
public class BooBoo extends ApplicationBean {

    /** - */
    private static final long serialVersionUID = -3625560465440189296L;

    /** - */
    private final String table;
    
    /** - */
    private final String message;
    
    
    /**
     * -
     * 
     * @param table -
     * @param message -
     */
    public BooBoo(final String table, final String message) {
        this.table = table;
        this.message = message;
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }    
}
