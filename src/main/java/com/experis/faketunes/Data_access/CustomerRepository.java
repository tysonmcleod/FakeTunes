package com.experis.faketunes.Data_access;
import com.experis.faketunes.Models.Customer;
import com.experis.faketunes.Models.CustomerCountry;
import com.experis.faketunes.Models.CustomerGenre;
import com.experis.faketunes.Models.CustomerSpender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class CustomerRepository {

    // set up connection
    private String URL = CONNECTION_URL;
    private Connection conn = null;


    // #1
    // read all customers -> get id, get first name, last name, country , postal code, phone number and email
    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer ");

            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                customers.add(
                        new Customer(
                                set.getString("CustomerId"),
                                set.getString("FirstName"),
                                set.getString("LastName"),
                                set.getString("Country"),
                                set.getString("PostalCode"),
                                set.getString("Phone"),
                                set.getString("Email")
                        ));

            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customers;
    }

    // #2
    // get specific customer by id -> get id, get first name, last name, country , postal code, phone number and email
    public Customer getSpecificCustomerById(String customerId){
        Customer specificCustomer = null;

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId=?");
                    preparedStatement.setString(1, customerId);
            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                specificCustomer = new Customer(
                                set.getString("CustomerId"),
                                set.getString("FirstName"),
                                set.getString("LastName"),
                                set.getString("Country"),
                                set.getString("PostalCode"),
                                set.getString("Phone"),
                                set.getString("Email")
                        );
            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return specificCustomer;
    }

    // #3
    // get specific customer by name -> get id, get first name, last name, country , postal code, phone number and email
    public Customer getSpecificCustomerByName(String name){
        Customer specificCustomer = null;

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE FirstName LIKE ? OR LastName LIKE ?");
            preparedStatement.setString(1, name);
            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                specificCustomer = new Customer(
                        set.getString("CustomerId"),
                        set.getString("FirstName"),
                        set.getString("LastName"),
                        set.getString("Country"),
                        set.getString("PostalCode"),
                        set.getString("Phone"),
                        set.getString("Email")
                );
            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return specificCustomer;
    }

    // #4
    // return page of customers from the database -> arguments limit and offset (get subset of customer data)
    public ArrayList<Customer> getSubsetOfCustomers(int limit, int offset){
        ArrayList<Customer> customers = new ArrayList<>();

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer LIMIT ? , ?");
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2,limit);

            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                customers.add(
                        new Customer(
                                set.getString("CustomerId"),
                                set.getString("FirstName"),
                                set.getString("LastName"),
                                set.getString("Country"),
                                set.getString("PostalCode"),
                                set.getString("Phone"),
                                set.getString("Email")
                        ));

            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customers;
    }

    // #5
    // add customer into db using fields "id, firstName, lastName, country, postal code, phone number and email
    public Boolean addCustomer(Customer customer){
        Boolean success = false;
        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Customer(CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email)" + "VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getCountry());
            preparedStatement.setString(5, customer.getPostalCode());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());

            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("Added customer");
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return success;

    }

    // #6
    // update an existing customer
    public Boolean updateCustomer(String customerId, Customer updatedValuedCustomer){
        Boolean success = false;
        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE Customer SET FirstName=?, LastName=?, Country=?, PostalCode=?, Phone=?, Email=? WHERE CustomerId = ?");
            preparedStatement.setString(1, updatedValuedCustomer.getFirstName());
            preparedStatement.setString(2, updatedValuedCustomer.getLastName());
            preparedStatement.setString(3, updatedValuedCustomer.getCountry());
            preparedStatement.setString(4, updatedValuedCustomer.getPostalCode());
            preparedStatement.setString(5, updatedValuedCustomer.getPhoneNumber());
            preparedStatement.setString(6, updatedValuedCustomer.getEmail());
            preparedStatement.setString(7, customerId);

            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("Added customer");
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return success;
    }

    // #7
    // number of customers in each country, ordered DESC
    public ArrayList<CustomerCountry> getCountryByCustomerCount(){
        ArrayList<CustomerCountry> customerCountry = new ArrayList<>();
        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            // (https://stackoverflow.com/questions/39565394/how-to-rename-result-set-of-count-in-sql)
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Country,  COUNT(*) as numcustomers FROM Customer GROUP BY Country ORDER BY numcustomers DESC");

            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                customerCountry.add(new CustomerCountry(set.getString("Country"), set.getString("numcustomers")));
            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customerCountry;

    }

    // #8
    // customers who are the highest spenders DESC
    public ArrayList<CustomerSpender> getCustomerByHighestSpentAmount(){
        ArrayList<CustomerSpender> customerSpenders = new ArrayList<>();
        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Customer.CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email, Invoice.Total" +
                            " FROM Customer INNER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId" +
                            " ORDER BY Invoice.Total DESC");

            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                customerSpenders.add(new CustomerSpender(
                        set.getString("CustomerId"),
                        set.getString("FirstName"),
                        set.getString("LastName"),
                        set.getString("Country"),
                        set.getString("PostalCode"),
                        set.getString("Phone"),
                        set.getString("Email"),
                        set.getString("total")
                        ));
            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customerSpenders;
    }

    // #9
    // customers most popular genre
    public ArrayList<CustomerGenre> getCustomerMostPopularGenre(String customerId){
        ArrayList<CustomerGenre> customerGenres = new ArrayList<>();
        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("");

            // execute query
            preparedStatement.setString(1, customerId);
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                customerGenres.add(new CustomerGenre(
                        set.getString("CustomerId"),
                        set.getString("FirstName"),
                        set.getString("LastName"),
                        set.getString("Country"),
                        set.getString("PostalCode"),
                        set.getString("Phone"),
                        set.getString("Email"),
                        set.getString("mostTracks")
                ));
            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customerGenres;
    }



}
