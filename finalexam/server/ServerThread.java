// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Bryan Moreno
// ===================================


package edu.cscc.csci2469.finalexam.server;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cscc.csci2469.finalexam.bean.ApplicationBean;
import edu.cscc.csci2469.finalexam.bean.BooBoo;
import edu.cscc.csci2469.finalexam.bean.Customer;
import edu.cscc.csci2469.finalexam.bean.CustomerList;
import edu.cscc.csci2469.finalexam.bean.Order;
import edu.cscc.csci2469.finalexam.bean.OrderList;
import edu.cscc.csci2469.finalexam.common.ActionRequest;
import edu.cscc.csci2469.finalexam.common.ActionResponse;


/** - */
public class ServerThread extends Thread {
    /** Holds thread count */
    private static int count = 1;


    /** Holds database connection instance */
    private Connection connection;


    /** Holds socket instance */
    private Socket socket;


    /** Holds next customer id number */
    private int nextCustomerId = 3;


    /** Holds next orderId numbers */
    private int nextOrderId = 4;


    /**
     * -
     *
     * @param socket -
     * @param driverName -
     * @param databaseUrl -
     * @param databaseId -
     * @param databasePassword -
     */
    public ServerThread(final Socket socket, final String driverName, final String databaseUrl, final String databaseId,
                        final String databasePassword) {
        super(String.format("ServerThread-%d", count));
        ++count;
        this.socket = socket;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(databaseUrl, databaseId, databasePassword);
            System.out.println("\n** Connection to database established");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(String.format("\n** Unable to establish database connection - %s", e.getMessage()));
            System.exit(1);
        }
    }

    /** This method inserts a new customer into the table
     *
     * @param data the customer data is used to obtain customer variables
     * @return Will either return the new customer data or will return the error code
     */
    private ApplicationBean insertCustomer(final Customer data) {
        final String query = "INSERT INTO Customers (CustomerId,lastName,firstName,streetAddress,city,state,zip,phone) VALUES (?,?,?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,data.getCustomerId());
            ps.setString(2, data.getLastName());
            ps.setString(3, data.getFirstName());
            ps.setString(4, data.getStreetAddress());
            ps.setString(5, data.getCity());
            ps.setString(6, data.getState());
            ps.setString(7, data.getZip());
            ps.setString(8, data.getPhone());
            ps.executeUpdate();
                return new Customer(data.getCustomerId(),data.getLastName(),data.getFirstName(),data.getStreetAddress(),data.getCity(),data.getState(),data.getZip(),data.getPhone());
            } catch (SQLException e) {
                return new BooBoo("Customer", "Error during insert - " + e.getMessage());
            }
        // TODO: REPLACE THIS COMMENT WITH YOUR CODE
    }


    /** This method inserts a new order into table
     * -
     *
     * @param data - data from the order bean is passed
     * @return - returns the data from the order or error message
     */
    private ApplicationBean insertOrder(final Order data) {

        final String query = "INSERT INTO Orders (CustomerId,OrderId,OrderDate,Type,Details) VALUES (?,?,?,?,?)";
        final String orderId = String.format("O-%04d", nextOrderId++);
        final String customerId = data.getCustomerId();
        final String orderDate = data.getOrderDate();
        final String type = data.getType();
        final String details = data.getDetails();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customerId);
            ps.setString(2, orderId);
            ps.setString(3, orderDate);
            ps.setString(4, type);
            ps.setString(5, details);
            ps.executeUpdate();
            return new Order(customerId, orderId, orderDate, type, details);
        } catch (SQLException e) {
            return new BooBoo("Orders", "Error during insert - " + e.getMessage());
        }
    }


    /** This method retrieves customers from the table
     * -
     *
     * @param data - data from the customer is passed
     * @return - returns the customers data
     */
    private ApplicationBean retrieveCustomer(final Customer data) {
        final String query = "SELECT * FROM Customers WHERE CustomerID= ?";
        final String CustomerId= data.getCustomerId();

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, data.getCustomerId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final String customerId  = rs.getString("CustomerID");
                final String lastName = rs.getString("LastName");
                final String firstName = rs.getString("FirstName");
                final String streetAddress = rs.getString("StreetAddress");
                final String city = rs.getString("City");
                final String state = rs.getString("State");
                final String zip = rs.getString("Zip");
                final String phone = rs.getString("Phone");
                return new Customer(customerId,lastName,firstName,streetAddress,city,state,zip,phone);

            }
            return null;

        }catch (SQLException e) {
            return new BooBoo("Customers", "Error during retrieve - " + e.getMessage());
    }// TODO: REPLACE THIS COMMENT WITH YOUR CODE

    }


    /**this method retrieves the order from table
     * -
     *
     * @param data - data from orders are passing into method
     * @return - either nothing is returned or the error message
     */
    private ApplicationBean retrieveOrder(final Order data) {

        final String query = "SELECT * FROM Orders WHERE OrderId = ?";
        final String orderId = data.getOrderId();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final String customerId = rs.getString("CustomerId");
                final String orderDate = rs.getString("OrderDate");
                final String type = rs.getString("Type");
                final String details = rs.getString("Details");
                return new Order(customerId, orderId, orderDate, type, details);
            }
            return null;
        } catch (SQLException e) {
            return new BooBoo("Orders", "Error during retrieve - " + e.getMessage());
        }
    }


    /** This method updates the customer
     * -
     *
     * @param data - data from current customer is updated
     * @return - returns the updated data into object or gives error
     */
    private ApplicationBean updateCustomer(final Customer data) {

        final String query = "UPDATE Customers SET LastName=?,FirstName=?,StreetAddress=?,City =?,State =?,Zip =?,Phone =? WHERE CustomerId = ?";

        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(8,data.getCustomerId());
            ps.setString(1, data.getLastName());
            ps.setString(2, data.getFirstName());
            ps.setString(3, data.getStreetAddress());
            ps.setString(4, data.getCity());
            ps.setString(5, data.getState());
            ps.setString(6, data.getZip());
            ps.setString(7, data.getPhone());
            ps.executeUpdate();
            return new Customer(data.getCustomerId(),data.getLastName(),data.getFirstName(),data.getStreetAddress(),data.getCity(),data.getState(),data.getZip(),data.getPhone());
        } catch (SQLException e) {
            return new BooBoo("Customer", "Error during insert - " + e.getMessage());
        }
        // TODO: REPLACE THIS COMMENT WITH YOUR CODE
    }


    /** This method updates a current order
     * -
     *
     * @param data - data from order is passed
     * @return - returns updated order data or returns an error message
     */
    private ApplicationBean updateOrder(final Order data) {

        final String query = "UPDATE Orders SET customerId=?,OrderDate=?,Type=?,Details=? WHERE OrderId = ?";
        final String orderId = data.getOrderId();
        final String customerId = data.getCustomerId();
        final String orderDate = data.getOrderDate();
        final String type = data.getType();
        final String details = data.getDetails();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customerId);
            ps.setString(2, orderDate);
            ps.setString(3, type);
            ps.setString(4, details);
            ps.setString(5, orderId);
            ps.executeUpdate();
            return data;
        } catch (SQLException e) {
            return new BooBoo("Orders", "Error during insert - " + e.getMessage());
        }
    }


    /** This method deletes a current customer
     * -
     *
     * @param data - data from the customer is passed
     * @return - returns an error message or data
     */
    private ApplicationBean deleteCustomer(final Customer data) {

        final String query = "DELETE FROM Customers WHERE CustomerId = ?";
        final String customerId = data.getCustomerId();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customerId);
            ps.executeUpdate();
            return data;
        } catch (SQLException e) {
            return new BooBoo("Customers", "Error during update - " + e.getMessage());
        }
    }


    /** This method deletes a current order
     * -
     *
     * @param data - data from order is passed
     * @return - returns an error message or data
     */
    private ApplicationBean deleteOrder(final Order data) {

        final String query = "DELETE FROM Orders WHERE OrderId = ?";
        final String orderId = data.getOrderId();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, orderId);
            ps.executeUpdate();
            return data;
        } catch (SQLException e) {
            return new BooBoo("Orders", "Error during update - " + e.getMessage());
        }
    }


    /** This method prints the list of customers
     * -
     *
     * @return - returns the list or an error
     */
    private ApplicationBean listCustomers() {

        final String query = "SELECT * FROM Customers ORDER BY LastName, CustomerId;";
        final List<Customer> list = new ArrayList<Customer>();

        try {
            final Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                final String customerId  = rs.getString("CustomerID");
                final String lastName = rs.getString("LastName");
                final String firstName = rs.getString("FirstName");
                final String streetAddress = rs.getString("StreetAddress");
                final String city = rs.getString("City");
                final String state = rs.getString("State");
                final String zip = rs.getString("Zip");
                final String phone = rs.getString("Phone");
                list.add(new Customer(customerId,lastName,firstName,streetAddress,city,state,zip,phone));
            }
            return new CustomerList(list);
        } catch (SQLException e) {
            return new BooBoo("Orders", "Error during list - " + e.getMessage());
        }
        // TODO: REPLACE THIS COMMENT WITH YOUR CODE
    }


    /**This method prints a list of orders
     * -
     *
     * @return - returns list of orders or error message
     */
    private ApplicationBean listOrders() {


        final String query = "SELECT * FROM Orders ORDER BY OrderId, CustomerId;";
        final List<Order> list = new ArrayList<Order>();

        try {
            final Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String customerId = rs.getString("CustomerId");
                String orderId = rs.getString("OrderId");
                String orderDate = rs.getString("OrderDate");
                String type = rs.getString("Type");
                String details = rs.getString("Details");
                list.add(new Order(customerId, orderId, orderDate, type, details));
            }
            return new OrderList(list);
        } catch (SQLException e) {
            return new BooBoo("Orders", "Error during list - " + e.getMessage());
        }
    }


    @Override
    public void run() {
        try (final ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                                                final ObjectInputStream ios = new ObjectInputStream(socket.getInputStream());) {

            ActionRequest actionRequest;
            ActionResponse actionResponse = null;
            String action;
            Object data;

            loop: while (true) {
                actionRequest = (ActionRequest) ios.readObject();
                action = actionRequest.getAction();
                data = actionRequest.getData();
//                System.out.println(String.format("Request: action='%s', data=%s", action, data == null ? "<< empty >>" : data.toString()));
                switch (action) {
                    case "QQ":
                        actionResponse = new ActionResponse("", "ADIOS", null);
                        oos.writeObject(actionResponse);
                        System.out.println(String.format("\n** Client %s disconnected!", this.getName()));
                        break loop;

                    case "CC":
                        actionResponse = new ActionResponse("Customers", "success", insertCustomer((Customer) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "CO":
                        actionResponse = new ActionResponse("Orders", "success", insertOrder((Order) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "RC":
                        actionResponse = new ActionResponse("Customers", "success", retrieveCustomer((Customer) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "RO":
                        actionResponse = new ActionResponse("Orders", "success", retrieveOrder((Order) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "UC":
                        actionResponse = new ActionResponse("Customers", "success", updateCustomer((Customer) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "UO":
                        actionResponse = new ActionResponse("Orders", "success", updateOrder((Order) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "DC":
                        actionResponse = new ActionResponse("Customers", "success", deleteCustomer((Customer) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "DO":
                        actionResponse = new ActionResponse("Orders", "success", deleteOrder((Order) actionRequest.getData()));
                        oos.writeObject(actionResponse);
                        break;

                    case "LC":
                        actionResponse = new ActionResponse("Customers", "success", listCustomers());
                        oos.writeObject(actionResponse);
                        break;

                    case "LO":
                        actionResponse = new ActionResponse("Orders", "success", listOrders());
                        oos.writeObject(actionResponse);
                        break;

                    default:
                        System.out.println(String.format("*** Fatal server thread error - unexpected command - %s", action));
                        System.exit(1);
                }
//                System.out.println(String.format("Response: action='%s', table='%s', data=%s", action, actionResponse.getTable(),
//                                                 actionResponse.getData().toString()));
            }

            connection.close();
            socket.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println(String.format("\n** Client %s died!", this.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
