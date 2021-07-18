package com.rs.store.Store.customer;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Transactional
	@Modifying
	@Query("update Product p set p.quantity=p.quantity-?2, p.totalPrice=p.totalPrice-p.unitPrice*?2 where p.type=?1")
	void updateType(String type, int count);
	
	
	@Query("select quantity from Product p where p.type=?1")
	int countType(String type);
}
