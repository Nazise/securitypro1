package kz.bitlab.group1.security.securitypro1.service;

import kz.bitlab.group1.security.securitypro1.model.Permission;
import kz.bitlab.group1.security.securitypro1.model.User1;
import kz.bitlab.group1.security.securitypro1.repository.PermissionRepository;
import kz.bitlab.group1.security.securitypro1.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final PasswordEncoder passwordEncoder;
    private final User1Repository user1Repository;
    private final PermissionRepository permissionRepository;

    public User1 registerUser(String email, String password, String rePassword, String fullName){
        User1 checkUser = user1Repository.findByEmail(email);
        if(checkUser==null){
            if(password.equals(rePassword)){

                List<Permission> permissions = new ArrayList<>();
                Permission userPermission = permissionRepository.findByPermission("ROLE_USER");
                permissions.add(userPermission);

                User1 user1 = User1
                        .builder()
                        .fullName(fullName)
                        .email(email)
                        .roles(permissions)
                        .password(passwordEncoder.encode(password))
                        .build();
                return user1Repository.save(user1);
            }
        }
        return null;
    }
}
