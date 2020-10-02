package com.yn.training.policyserviceyn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yn.training.policyserviceyn.model.Policy;
import com.yn.training.policyserviceyn.service.PolicyService;



@RestController
public class PolicyController {
	
	@Autowired
	PolicyService policyService;

	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot Application 1.0";
	}
	
	@RequestMapping(value="/policy", method = RequestMethod.POST)
	public Policy createPolicy(@RequestBody Policy policy) {
		return policyService.createPolicy(policy);
		
	}
	
	@RequestMapping(value="/policy/{policyId}", method = RequestMethod.GET)
	public Policy getPolicy(@RequestBody String policyId) {
		return policyService.getPolicy(policyId);
	}
	
	@RequestMapping(value="/policy/{policyId}", method = RequestMethod.POST)
	public Policy updatePolicy(@RequestBody Policy policy) {
		return policyService.updatePolicy(policy);
	}
	
	@RequestMapping(value="/policy/{policyId}", method = RequestMethod.DELETE)
	public String deletePolicy(@RequestBody Policy policy) {
		return policyService.deletePolicy(policy);
	}
	
	@RequestMapping(value="/policies", method = RequestMethod.GET)
	public List<Policy> getPolicies(){
		return policyService.getPolicies();
	}
}

