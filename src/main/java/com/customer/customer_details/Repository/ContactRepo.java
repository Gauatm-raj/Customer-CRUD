package com.customer.customer_details.Repository;

import com.customer.customer_details.Model.Contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepo extends JpaRepository<Contact,Integer> {

    @Query(value = "select * from contact as c where c.user_id =:userid",nativeQuery = true)
    public Page<Contact> getContactByUserId(@Param("userid") Integer userid, Pageable pageable);

//    @Query(value = "select * from contact as c where c.firstName like :"%"",nativeQuery = true)
//    public Page<Contact> getContactByUserId(@Param("userid") Integer userid, Pageable pageable);

}
