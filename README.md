--------------------------------------------------------------------------------------------------------------------------------------------------------------    
Step To Be Followed :
--------------------------------------------------------------------------------------------------------------------------------------------------------------    

1. Create a Basic Rest API that will return the list of Details like Employee,Student or any other.
2. Secure the Rest API by adding security dependency.
3. Use the properties file to create custom username and password for authentication.
4. Create the SpringSecurityConfig class to define the bean like PasswordEncoder, UserDetailsService and AuthenticationManager.
5. Create JwtAuthenticationEntryPoint Class Which implements AuthenticationEntryPoint interface and override method commence.
6. Create JwtHelper Class which is used to perform action like validateToken and generateToken etc.
7. Create JWTAuthenticationFilter class which is used for the filter purpose.
8. Create SecurityFilterConfig class to define request processing logic.
9. Create JwtRequest and JwtResponse class.
10. Create JwtAuthenticationController to return the JwtResponse if everything works fine.

--------------------------------------------------------------------------------------------------------------------------------------------------------------    
 Important Dependency to be used :
--------------------------------------------------------------------------------------------------------------------------------------------------------------    

~ For rest api ~ Spring Web

~ For Getter and Setter ~ Lombok

~ For Security ~ Spring Security


-------------------------------------------------------------------------------------------------------------------------------------------------------------
  For JWT ( Import from Maven Repository ) 
--------------------------------------------------------------------------------------------------------------------------------------------------------------    

- Jjwt-api

- Jjwt-impl

- jjwt-jackson

