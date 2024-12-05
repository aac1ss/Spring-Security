package org.example.lastjwt.service;

import org.example.lastjwt.model.UserPrincipal;
import org.example.lastjwt.model.Users;
import org.example.lastjwt.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
   public final UserRepo repo;
    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= repo.findByUsername(username);
        if(user==null){
            System.out.println("User not Found ");
            throw new UsernameNotFoundException("User not FOund");
        }
        return new UserPrincipal(user);
    }
}
