package com.example.employeeservices.service;

import com.example.employeeservices.entity.Employee;
import com.example.employeeservices.repository.EmployeeRepository;
import com.example.employeeservices.response.AddressResponse;
import com.example.employeeservices.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
   // @Autowired
//    RestTemplate restTemplate;
    public EmployeeResponse getEmployeeById(int id){
      AddressResponse addressResponse=new AddressResponse();
        Employee employee= employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
       // AddressResponse addressResponse = restTemplate.getForObject("http://localhost:19191/address-app/api/address/{id}",AddressResponse.class,id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

}
