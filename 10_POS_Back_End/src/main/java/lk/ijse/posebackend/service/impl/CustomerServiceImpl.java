package lk.ijse.posebackend.service.impl;

import lk.ijse.posebackend.dto.CustomerDTO;
import lk.ijse.posebackend.entity.Customer;
import lk.ijse.posebackend.repository.CustomerRepository;
import lk.ijse.posebackend.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }
    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }
    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(modelMapper.map(customer, CustomerDTO.class));
        }
        return customerDTOS;
    }


}
