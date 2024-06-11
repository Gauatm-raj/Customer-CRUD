package com.customer.customer_details.Repository;

import com.customer.customer_details.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {

     @Query(value = "select * from user u where u.email =:email",nativeQuery = true)
      public User getUserByUsername(@Param("email")String email);


}
