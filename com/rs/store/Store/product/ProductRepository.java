package com.rs.store.Store.product;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> getByType(String type);
	
//	@Transactional
//	@Modifying
//	@Query("delete from Product p where p.type=?1")
//	void deleteByType(String type);
	
	@Transactional
	void deleteByType(String type);   //   -> JPA Repository
}
