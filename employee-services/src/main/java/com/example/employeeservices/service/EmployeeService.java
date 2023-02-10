package com.example.employeeservices.service;

import com.example.employeeservices.entity.Employee;
import com.example.employeeservices.repository.EmployeeRepository;
import com.example.employeeservices.response.AddressResponse;
import com.example.employeeservices.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    //@Autowired
//    RestTemplate restTemplate;
//    public EmployeeService(  @Value("${addressservice.base.url}")String addressBaseUrl,RestTemplateBuilder builder){
//       // System.out.println("url"+addressBaseUrl);
//       this.restTemplate= builder.rootUri(addressBaseUrl).build();
//    }
    @Autowired
    private WebClient webClient;
    public EmployeeResponse getEmployeeById(int id){
      //AddressResponse addressResponse=new AddressResponse();
        Employee employee= employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
       //AddressResponse addressResponse = restTemplate.getForObject("/address/{id}",AddressResponse.class,id);
        AddressResponse addressResponse=webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

//    private AddressResponse callingAddessServiceRESTTemplate(int id) {
//        return  restTemplate.getForObject("/address/{id}",AddressResponse.class,id);
//    }

}
