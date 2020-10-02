package com.yn.training.policyserviceyn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yn.training.policyserviceyn.model.Customer;
import com.yn.training.policyserviceyn.model.Policy;
import com.yn.training.policyserviceyn.repository.PolicyRepository;



@Service
public class PolicyService {
	
	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	CustomerService customerService;

	public Policy createPolicy(Policy policy) {
		Customer customer;
		customer = customerService.getCustomerDetails(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}

	public Policy getPolicy(String policyId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Policy> response = restTemplate.getForEntity("http://localhost:8081/mongoCustomer/"+policyId, Policy.class);
		Policy policy = response.getBody();
		return policy;
	}
	
	public String deletePolicy(Policy policy) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8081/mongoCustomer/"+policy);
		return "Policy Deleted";
	}
	
	public Policy updatePolicy(Policy policy) {
		Customer customer;
		customer = customerService.getCustomer(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.insert(policy);
	}
	
	public List<Policy> getPolicies() {
		return policyRepository.findAll();
	}

}