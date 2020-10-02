package com.yn.training.policyserviceyn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yn.training.policyserviceyn.model.Policy;

public interface PolicyRepository extends MongoRepository<Policy, String>{

}
