package com.experis.faketunes.Controllers.api;
import com.experis.faketunes.Data_access.CustomerRepository;
import com.experis.faketunes.Data_access.SearchRepository;
import com.experis.faketunes.Models.*;
import org.springframework.web.bind.annotation.*;

import javax.management.ValueExp;
import java.util.ArrayList;

@RestController
public class CustomerController {

    CustomerRepository customerRepository = new CustomerRepository();

    /*
    Return all customers
    */
    @RequestMapping(value="/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    /*
    Return a customer by id
    */
    @RequestMapping(value= "/api/customers/{id}", method = RequestMethod.GET)
    public Customer getSpecificCustomerById(@PathVariable String id){
        return customerRepository.getSpecificCustomerById(id);
    }
    /*
        Return a customer by search name
        */
    @RequestMapping(value= "/api/customers/search/{name}", method = RequestMethod.GET)
    public Customer getSpecificCustomerByName(@PathVariable String name){
        return customerRepository.getSpecificCustomerByName(name);
    }

    /*
    Return subset of customers
    */
    @RequestMapping(value="/api/customers/page/{limit}/{offset}", method = RequestMethod.GET)
    public ArrayList<Customer> getSubsetOfCustomers(@PathVariable int limit, @PathVariable int offset){
        return customerRepository.getSubsetOfCustomers(limit, offset);
    }
    /*
        Add a customer to the db
    */
    @RequestMapping(value="/api/customers/add", method = RequestMethod.POST)
    public Boolean addCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    /*
    Update a customer by id
    */
    @RequestMapping(value="/api/customers/update", method = RequestMethod.PUT)
    public Boolean addCustomer(@PathVariable String customerId,@RequestBody Customer customer){
        return customerRepository.updateCustomer(customerId,customer);
    }

    /*
    Return customers by country count
    */
    @RequestMapping(value="/api/customers/country", method = RequestMethod.GET)
    public ArrayList<CustomerCountry> getCountryByCustomerCount(){
        return customerRepository.getCountryByCustomerCount();
    }
    /*
    Return customer by highest spent amount
    */
    @RequestMapping(value="/api/customers/spenders", method = RequestMethod.GET)
    public ArrayList<CustomerSpender> getCustomerByHighestSpentAmount(){
        return customerRepository.getCustomerByHighestSpentAmount();
    }
    /*
    Return a customer and their most popular genre
    */
    @RequestMapping(value="/api/customers/{id}/popular", method = RequestMethod.GET)
    public ArrayList<CustomerGenre> getCustomerMostPopularGenre(@PathVariable String id){
        return customerRepository.getCustomerMostPopularGenre(id);
    }

    /*
    //test
    SearchRepository searchRepository = new SearchRepository();
    @RequestMapping(value="/api/customers/searchresults/{id}", method = RequestMethod.GET)
    public ArrayList<Search> searchTrack(@PathVariable (value = "id") String id){
        return searchRepository.search(id);
    }
    */
}
