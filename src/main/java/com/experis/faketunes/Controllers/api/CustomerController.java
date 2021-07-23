package com.experis.faketunes.Controllers.api;
import com.experis.faketunes.Data_access.CustomerRepository;
import com.experis.faketunes.Models.Customer;
import com.experis.faketunes.Models.CustomerCountry;
import com.experis.faketunes.Models.CustomerGenre;
import com.experis.faketunes.Models.CustomerSpender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    CustomerRepository customerRepository = new CustomerRepository();

    /*
    This first one just returns all the customers in the database
    it will return a CustomerShort object.
    */
    @RequestMapping(value="/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @RequestMapping(value= "/api/customers/{id}", method = RequestMethod.GET)
    public Customer getSpecificCustomerById(@PathVariable String id){
        return customerRepository.getSpecificCustomerById(id);
    }

    @RequestMapping(value= "/api/customers/search/{name}", method = RequestMethod.GET)
    public Customer getSpecificCustomerByName(@PathVariable String name){
        return customerRepository.getSpecificCustomerByName(name);
    }

    @RequestMapping(value="/api/customers/page/{limit}/{offset}", method = RequestMethod.GET)
    public ArrayList<Customer> getSubsetOfCustomers(@PathVariable int limit, @PathVariable int offset){
        return customerRepository.getSubsetOfCustomers(limit, offset);
    }

    @RequestMapping(value="/api/customers/add", method = RequestMethod.POST)
    public Boolean addCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping(value="/api/customers/update", method = RequestMethod.PUT)
    public Boolean addCustomer(@PathVariable String customerId,@RequestBody Customer customer){
        return customerRepository.updateCustomer(customerId,customer);
    }

    @RequestMapping(value="/api/customers/country", method = RequestMethod.GET)
    public ArrayList<CustomerCountry> getCountryByCustomerCount(){
        return customerRepository.getCountryByCustomerCount();
    }

    @RequestMapping(value="/api/customers/spenders", method = RequestMethod.GET)
    public ArrayList<CustomerSpender> getCustomerByHighestSpentAmount(){
        return customerRepository.getCustomerByHighestSpentAmount();
    }

    @RequestMapping(value="/api/customers/{id}/popular", method = RequestMethod.GET)
    public ArrayList<CustomerGenre> getCustomerMostPopularGenre(@PathVariable String id){
        return customerRepository.getCustomerMostPopularGenre(id);
    }

}
