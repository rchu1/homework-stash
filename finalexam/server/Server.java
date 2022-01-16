// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Bryan Moreno
// ===================================


package edu.cscc.csci2469.finalexam.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import edu.cscc.csci2469.finalexam.util.ConsoleReader;

//import edu.cscc.csci2469.finalexam.util.ConsoleReader;


/** - */
public class Server {

    /** Holds instance of ConsoleReader */
    private static final ConsoleReader consoleReader = new ConsoleReader();


    /** Holds the base portion of the URL to use when connecting to the MySQL database */
    private static final String DATABASE_BASE_URL = "jdbc:mysql://";


    /** Holds the name of the JDBC driver to use when accessing the MySQL database */
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";


    /** Holds the name of the MySQL server host */
    private static final String DATABASE_HOST = "cscc.homeip.net";


    /**
     * Holds the value to be used as the database name, database user name, and database
     * password.
     */
    private static final String DATABASE_ID = "bmoreno2";


    /** Holds the value of the MySQL server port */
    private static final String DATABASE_PORT = "3306";


    /**
     * -
     *
     * @param args -
     */
    public static void main(String[] args) {
        System.out.println(String.format("Server started at %s", new Date().toString()));
        final int serverPort = consoleReader.getPortNumber("Enter port number on which to accept connections: ");

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {

            System.out.println(String.format("Listening for connections on port %d", serverSocket.getLocalPort()));

            while (true) {
                Socket dataSocket = serverSocket.accept();
                ServerThread thread = new ServerThread(dataSocket, getDriverName(), getUrl(), getDatabaseUserId(), getDatabasePassword());
                System.out.println(String.format("Connection from %s, Thread=%s", dataSocket.getLocalAddress().getHostName(), thread.getName()));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println(String.format("Exception - %s", e.getMessage()));
            System.exit(1);
        }
    }


    /**
     * Retrieves the base database portion of the database URL. This info is intended to
     * be used when reporting problems with connecting to the database server.
     *
     * @return the base portion of the database URL
     */
    public static String getDatabaseBaseUrl() {
        return (DATABASE_BASE_URL);
    }


    /**
     * Retrieves the database host name/port. This info is intended to be used when
     * reporting problems with connecting to the database server.
     *
     * @return the database host name
     */
    public static String getDatabaseHost() {
        return (DATABASE_HOST);
    }


    /**
     * Retrieves the database ID. This info is intended to be used when reporting problems
     * with connecting to the database server.
     *
     * @return the database ID
     */
    public static String getDatabaseId() {
        return ("cscc_" + DATABASE_ID);
    }


    /**
     * Retrieves the database password. This info is intended to be used internally when
     * connecting to the database server.
     *
     * @return the database password
     */
    private static String getDatabasePassword() {
        return (DATABASE_ID);
    }


    /**
     * Retrieves the database host port. This info is intended to be used when reporting
     * problems with connecting to the database server.
     *
     * @return the database port
     */
    public static String getDatabasePort() {
        return (DATABASE_PORT);
    }


    /**
     * Retrieves the database user ID. This info is intended to be used internally when
     * connecting to the database server.
     *
     * @return the database password
     */
    private static String getDatabaseUserId() {
        return (DATABASE_ID);
    }


    /**
     * Retrieves the name of the JDBC driver for error reporting purposes.
     *
     * @return the JDBC driver name
     */
    public static String getDriverName() {
        return (DATABASE_DRIVER);
    }


    /**
     * Retrieves the URL used to connect to the MySQL database.
     *
     * @return the URL used
     */
    public static String getUrl() {
        final StringBuilder url = new StringBuilder(128);

        url.append(getDatabaseBaseUrl());
        url.append(getDatabaseHost());
        url.append(":");
        url.append(getDatabasePort());
        url.append("/");
        url.append(getDatabaseId());
        url.append("?useSSL=false");

        return url.toString();
    }
}
