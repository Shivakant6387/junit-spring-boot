package com.example.employeeservices.service;

import com.example.employeeservices.entity.Employee;
import com.example.employeeservices.repository.EmployeeRepository;
import com.example.employeeservices.response.AddressResponse;
import com.example.employeeservices.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    RestTemplate restTemplate;
    @Value("${addressservice.base.url}")
    private String addressBaseUrl;
    public EmployeeResponse getEmployeeById(int id){
      //AddressResponse addressResponse=new AddressResponse();
        Employee employee= employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
       AddressResponse addressResponse = restTemplate.getForObject(addressBaseUrl+"/address/{id}",AddressResponse.class,id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

}
