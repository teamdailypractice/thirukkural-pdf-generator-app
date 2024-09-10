package info.dailypractice.service;

import info.dailypractice.dao.CustomerRepository;
import info.dailypractice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findByLastName(String lastName) {
        return this.customerRepository.findByLastName(lastName);
    }

    public Customer findById(long id) {
        return this.customerRepository.findById(id);
    }

    public void save(Customer customer) {
        Customer save = this.customerRepository.save(customer);

    }

    public List<Customer> findAll() {
       return (List<Customer>) this.customerRepository.findAll();

    }
}

