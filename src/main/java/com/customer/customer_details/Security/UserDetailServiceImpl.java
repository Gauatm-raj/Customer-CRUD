package com.customer.customer_details.Security;


import com.customer.customer_details.Model.User;
import com.customer.customer_details.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("User Not Found");
        }
        UserDetailImpl userDetail=new UserDetailImpl(user);
        return userDetail;
    }
}
