package com.example.demo.service.impl.security;

import com.example.demo.UserDetail.CustomUserDetail;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("Sai");
        }
        else {
            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
            Set<UserRole> roles = user.getUserRoles();
            for(UserRole role : roles)
            {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
            }
            return new CustomUserDetail(user,grantedAuthorities);
        }
    }
}
