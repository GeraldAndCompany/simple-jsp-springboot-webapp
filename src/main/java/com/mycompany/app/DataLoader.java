package com.mycompany.app;

import com.mycompany.app.entity.Role;
import com.mycompany.app.entity.User;
import com.mycompany.app.repository.RoleRepository;
import com.mycompany.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataLoader(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        String[] defaultRoles = {"USER", "ADMIN"};
        Set<Role> allRoles = new HashSet<Role>();
        for(String roleName: defaultRoles){
            Role role = new Role();
            role.setName(roleName);
            allRoles.add(roleRepository.save(role));
        }
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("password"));
        admin.setRoles(allRoles);
        userRepository.save(admin);
    }
}
