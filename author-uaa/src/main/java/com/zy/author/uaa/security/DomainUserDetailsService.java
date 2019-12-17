package com.zy.author.uaa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangyunfei on 2017/6/9.
 */
//@Service("userDetailsService")
//public class DomainUserDetailsService implements UserDetailsService {
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Set<GrantedAuthority> grantedAuthorities =  new HashSet<>();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("admin");
//        return new User("admin","$2a$10$ODoZJKtLmhwpdfeoU08Q7OqrpftHfWpaBGhsRG.Xw4XRk69/RkLR.",grantedAuthorities);
//    }
//}
