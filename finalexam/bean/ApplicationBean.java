// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Craig Wright
// ===================================


package edu.cscc.csci2469.finalexam.bean;


import java.io.Serializable;


/**
 * Base class for database beans
 */
public abstract class ApplicationBean implements Serializable {

    /** - */
    private static final long serialVersionUID = -7638915332130214027L;
//
//
//    /**
//     * Verifies that the specified id value is a positive integer. IF the specified id is
//     * not a positive integer, an exception is thrown; otherwise this method simply
//     * returns.
//     * 
//     * @param id id to be verified
//     */
//    protected void verifyId(final int id) {
//        if (id < 1) {
//            throw new IllegalArgumentException(String.format("id must be a positive integer - %d", id));
//        }
//    }
//
//
//    /**
//     * Verifies that the specified value is not null or empty (after leading/trailing
//     * whitespace has been trimmed)
//     * 
//     * @param value value to be verified
//     */
//    protected void verifyValueNotEmpty(final String value) {
//        if (value == null || value.trim().length() == 0) {
//            throw new IllegalArgumentException("Value is null or empty after leading/trailing whitespace has been trimmed");
//        }
//    }
//
//
//    /**
//     * Verifies that the specified value is in the specified list of valid values. If the
//     * specified value is not in the list of valid values, an exception is thrown;
//     * otherwise this method simply returns.
//     * 
//     * @param value value to be verified
//     * @param validValues list of valid values
//     * @throws IllegalArgumentException thrown when value is not in list of valid values
//     */
//    protected void verifyValueIsInList(final String value, final String[] validValues) {
//        verifyValueNotEmpty(value);
//        for (String validValue : validValues) {
//            if (validValue.equals(value)) {
//                return;
//            }
//        }
//        throw new IllegalArgumentException(String.format("Value '%s' not in list of allowed values %s", value, validValues));
//    }
}
