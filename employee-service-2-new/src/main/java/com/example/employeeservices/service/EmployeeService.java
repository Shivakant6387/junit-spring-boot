package com.example.employeeservices.service;

import com.example.employeeservices.entity.Employee;
import com.example.employeeservices.feignClient.AddressClient;
import com.example.employeeservices.repository.EmployeeRepository;
import com.example.employeeservices.response.AddressResponse;
import com.example.employeeservices.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressClient addressClient;
    public EmployeeResponse getEmployeeById(int id){
      //AddressResponse addressResponse=new AddressResponse();
        Employee employee= employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
       //AddressResponse addressResponse = restTemplate.getForObject("/address/{id}",AddressResponse.class,id);
       // AddressResponse addressResponse=addressClient.getAddressByEmployeeId(id);
                //webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
        ResponseEntity<AddressResponse> addressResponseEntity=addressClient.getAddressByEmployeeId(id);
        AddressResponse addressResponse=addressResponseEntity.getBody();
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

//    private AddressResponse callingAddessServiceRESTTemplate(int id) {
//        return  restTemplate.getForObject("/address/{id}",AddressResponse.class,id);
//    }

}
