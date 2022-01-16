// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Bryan Moreno
// ===================================


package edu.cscc.csci2469.finalexam.client;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.cscc.csci2469.finalexam.bean.BooBoo;
import edu.cscc.csci2469.finalexam.bean.Customer;
import edu.cscc.csci2469.finalexam.bean.CustomerList;
import edu.cscc.csci2469.finalexam.bean.Order;
import edu.cscc.csci2469.finalexam.bean.OrderList;
import edu.cscc.csci2469.finalexam.common.ActionRequest;
import edu.cscc.csci2469.finalexam.common.ActionResponse;
import edu.cscc.csci2469.finalexam.util.ConsoleReader;


/** - */
public class Client {
    /** - */
    private static final ConsoleReader consoleReader = new ConsoleReader();


    /** - */
    private static final List<String> commands = new ArrayList<>();
    static {
        commands.add("CC");
        commands.add("CC");
        commands.add("CO");
        commands.add("RC");
        commands.add("RO");
        commands.add("UC");
        commands.add("UO");
        commands.add("DC");
        commands.add("DO");
        commands.add("LC");
        commands.add("LO");
        commands.add("QQ");
    }


    /**
     * -
     *
     * @return -
     */
    private static String getCommand() {
        String result = null;
        while (result == null) {
            System.out.println("Main Menu");
            System.out.println("   CC - Create Customer");
            System.out.println("   CO - Create Order");
            System.out.println("   RC - Retrieve Customer");
            System.out.println("   RO - Retrieve Order");
            System.out.println("   UC - Update Customer");
            System.out.println("   UO - Update Order");
            System.out.println("   DC - Delete Customer");
            System.out.println("   DO - Delete Order");
            System.out.println("   LC - List Customers");
            System.out.println("   LO - List Orders");
            System.out.println("   QQ - Quit");
            result = consoleReader.getString("Which one? ").toUpperCase();
            if (result.length() != 2 || !commands.contains(result)) {
                System.out.println("\n** Invalid response **\n");
                result = null;
            }
        }

        return result.toUpperCase();
    }


    /**
     * -
     *
     * @param needId -
     * @param needEverythingElse -
     * @return -
     */
    private static Customer inputCustomer(final boolean needId, final boolean needEverythingElse) {

        Customer customer;
        String id = null;
        String lastName = null;
        String firstName = null;
        String streetAddress = null;
        String city = null;
        String state = null;
        String zip = null;
        String phoneNumber = null;

        if (needId) {
            id = consoleReader.getString("Enter customer id: ");
        }
        if (needEverythingElse) {
            lastName = consoleReader.getString("Enter customer last name: ");
            firstName = consoleReader.getString("Enter customer first name: ");
            streetAddress = consoleReader.getString("Enter customer street address: ");
            city = consoleReader.getString("Enter customer city: ");
            state = consoleReader.getString("Enter customer state: ");
            zip = consoleReader.getString("Enter customer zip code: ");
            phoneNumber = consoleReader.getString("Enter customer phone number: ");
        }
        customer = new Customer(id, lastName, firstName, streetAddress, city, state, zip, phoneNumber);
        return customer;
    }


    /**
     * -
     *
     * @param needId -
     * @param needEverythingElse -
     * @return -
     */
    private static Order inputOrder(final boolean needId, final boolean needEverythingElse) {

        Order order;
        String customerId = null;
        String orderId = null;
        String orderDate = null;
        String type=null;
        String details = null;

        if (needId) {
            orderId = consoleReader.getString("Enter order id: ");
        }
        if (needEverythingElse) {
            customerId = consoleReader.getString("Enter customer id: ");
            orderDate = consoleReader.getString("Enter order date: ");
            type = consoleReader.getString("Enter type (COOL, HEAT, BOTH): ");
            details = consoleReader.getString("Enter problem details: ");
        }
        order = new Order(customerId, orderId, orderDate, type, details);
        return order;
    }


    /**
     * -
     *
     * @param ios -
     * @return -
     * @throws ClassNotFoundException -
     * @throws IOException -
     */
    private static boolean handleServerResponse(final ObjectInputStream ios) throws ClassNotFoundException, IOException {

        final ActionResponse actionResponse = (ActionResponse) ios.readObject();
        final String table = actionResponse.getTable();
        final String status = actionResponse.getStatus();
        final Object data = actionResponse.getData();

//        System.out.println(String.format("Handling response: table='%s', status='%s', data=%s", table, status, data));
        switch (table) {
            case "Customers":
                if (data instanceof Customer) {
                    final Customer customer = (Customer) data;
                    System.out.println(String.format("%s - %s: %s", table, status, customer.toString()));

                } else if (data instanceof CustomerList) {
                    final List<Customer> list = ((CustomerList) data).getList();
                    System.out.println(String.format("%s - %s:",  table, status));
                    for (Customer customer : list) {
                        System.out.println(String.format("   %s", customer));
                    }

                } else if (data instanceof BooBoo) {
                    final BooBoo booBoo = (BooBoo) data;
                    System.out.println(String.format("\n** Action failed for %s - %s", table, booBoo.getMessage()));

                } else {
                    System.out.println(String.format("\n** Unrecognized response type - %s", data.getClass().getName()));
                }
                break;

            case "Orders":
                if (data instanceof Order) {
                    final Order order = (Order) data;
                    System.out.println(String.format("%s - %s: %s", table, status, order.toString()));

                } else if (data instanceof OrderList) {
                    final List<Order> list = ((OrderList) data).getList();
                    System.out.println(String.format("%s - %s:",  table, status));
                    for (Order order : list) {
                        System.out.println(String.format("   %s", order));
                    }

                } else if (data instanceof BooBoo) {
                    final BooBoo booBoo = (BooBoo) data;
                    System.out.println(String.format("\n** Action failed for %s - %s", table, booBoo.getMessage()));

                } else {
                    System.out.println(String.format("\n** Unrecognized response type - %s", data.getClass().getName()));
                }
                break;

            default:
                System.out.println(String.format("Unexpected response for table %s", table));
                break;
        }

        return "ADIOS".equals(actionResponse.getStatus());
    }


    /**
     * -
     *
     * @param oos -
     * @throws IOException -
     */
    private static void sendServerRequest(final ObjectOutputStream oos) throws IOException {

        ActionRequest actionRequest = null;

        String command = getCommand();
//        System.out.println(String.format("Sending ActionRequest - %s", command));
        switch (command) {
            case "CC":
                actionRequest = new ActionRequest(command, inputCustomer(true, true));
                break;

            case "CO":
                actionRequest = new ActionRequest(command, inputOrder(false, true));
                break;

            case "RC":
                actionRequest = new ActionRequest(command, inputCustomer(true, false));
                break;

            case "RO":
                actionRequest = new ActionRequest(command, inputOrder(true, false));
                break;

            case "UC":
                actionRequest = new ActionRequest(command, inputCustomer(true, true));
                break;

            case "UO":
                actionRequest = new ActionRequest(command, inputOrder(true, true));
                break;

            case "DC":
                actionRequest = new ActionRequest(command, inputCustomer(true, false));
                break;

            case "DO":
                actionRequest = new ActionRequest(command, inputOrder(true, false));
                break;

            case "LC":
                actionRequest = new ActionRequest(command, null);
                break;

            case "LO":
                actionRequest = new ActionRequest(command, null);
                break;

            case "QQ":
                actionRequest = new ActionRequest(command, null);
                break;

            default:
                System.out.println(String.format("*** Fatal client error - unexpected command - %s", command));
                System.exit(1);
        }

        oos.writeObject(actionRequest);
    }


    /**
     * -
     *
     * @param args -
     */
    public static void main(String[] args) {
        System.out.println(String.format("Client started at %s\n", new Date().toString()));
        final String serverHost = consoleReader.getString("Enter server's host name or IP: ");
        final int serverPort = consoleReader.getPortNumber("Enter server's port number: ");
        InetAddress server = null;
        Socket clientSocket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ios = null;

        try {
            server = InetAddress.getByName(serverHost);
            System.out.println(String.format("Connecting to %s on port %d", server.getCanonicalHostName(), serverPort));

            clientSocket = new Socket(serverHost, serverPort);
            System.out.println("Connection to server successful");

            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ios = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {
                sendServerRequest(oos);
                if (handleServerResponse(ios)) {
                    break;
                }
            }

            System.out.println("Closing connection with server");
        } catch (EOFException e) {
            System.out.println("Server has died");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    // Ignore any exceptions
                }
            }
            if (ios != null) {
                try {
                    ios.close();
                } catch (IOException e) {
                    // Ignore any exceptions
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    // Ignore any exceptions
                }
            }
        }
    }
}
