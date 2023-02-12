package kz.bitlab.group1.security.securitypro1.service;

import kz.bitlab.group1.security.securitypro1.model.User1;
import kz.bitlab.group1.security.securitypro1.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class User1Service implements UserDetailsService {

    @Autowired
    private User1Repository user1Repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User1 user1 = user1Repository.findByEmail(username);
        if(user1!=null) return user1;
        throw new UsernameNotFoundException("User Not Found");
    }
}
