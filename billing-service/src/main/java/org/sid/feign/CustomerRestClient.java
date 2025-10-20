package org.sid.feign;



import org.sid.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{id}")
    Customer getCustomerById(@PathVariable(name="id")Long id);

    @GetMapping(path = "/api/customers")
    PagedModel<Customer> getAllCustomers();
}