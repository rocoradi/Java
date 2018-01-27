/**
 * @author Coradi
 *
 * 10 de jan de 2018
 */
package com.schoolofnet.Rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.Rest.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
