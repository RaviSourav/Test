package com.rs.store.Store.account;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Transactional
	@Modifying
	@Query("update Account a set a.quantity=a.quantity+?2, a.totalSell=a.totalSell+?2*?3 where a.type=?1 AND a.date=?4")
	void updateType(String type,int quantity, float unitPrice, Date date);
	
	@Query("select type from Account a where a.type=?1 AND a.date=?2")
	String getByType(String type, Date date);
	
//	@Query("")
//	String calculateMargin();
	
	
//	@Query("insert into Account values (?1,?2,?3*1.0,?4)")
//	String saveAccountDetails(Date date, String type, int unitPrice, int quantity);
	
	
	//This is test for Git
}
