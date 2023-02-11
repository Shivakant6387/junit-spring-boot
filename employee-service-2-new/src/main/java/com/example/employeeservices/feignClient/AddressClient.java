package com.example.employeeservices.feignClient;

import com.example.employeeservices.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service",url = "http://localhost:19191",path = "/address-app/api/")
public interface AddressClient {
    //localhost:19191/address-app/api/address/1
    //@GetMapping("/address/{id}")
   // AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId")int id);

}
