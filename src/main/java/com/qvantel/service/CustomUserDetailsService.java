package com.qvantel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qvantel.dao.UserDAO;
import com.qvantel.model.Role;
import com.qvantel.model.User;

@Service ("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
    private UserDAO userDAO;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userDAO.findByUserName(userName);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
                 user.getStatus().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(Role userRole : user.getRoles()){
            System.out.println("UserProfile : "+userRole.getRoleName());
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRoleName()));
        }
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}
