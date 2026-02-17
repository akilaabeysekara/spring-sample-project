package lk.ijse.posebackend.service;

import lk.ijse.posebackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO);
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String id);
    public List<CustomerDTO> getAllCustomers();


}
