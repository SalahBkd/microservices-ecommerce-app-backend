package me.salah.customerservice.services;

import lombok.AllArgsConstructor;
import me.salah.customerservice.entity.Customer;
import me.salah.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer product) {
        customerRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
