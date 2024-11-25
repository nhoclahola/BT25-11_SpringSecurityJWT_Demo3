package com.nhoclahola.bt2511_springsecurityjwt_demo3.services.implement;

import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.User;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Could not find user");
        return new MyUserService(user);
    }
}
