package org.example.lastjwt.service;

import org.example.lastjwt.model.Users;
import org.example.lastjwt.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    public UserService(UserRepo userRepo, AuthenticationManager authManager, JwtService jwtService) {
        this.userRepo = userRepo;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    private final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    public Users register(Users user){
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         userRepo.save(user);
        return user;
    }

    public String verify(Users user) {
        Authentication authentication=
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            System.out.println( "Authentication SuccessFull!! ");
            return jwtService.generateToken(user.getUsername());
        }
        return "Authentication Failed";

    }
}
