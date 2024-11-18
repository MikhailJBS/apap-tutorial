package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.repository.*;
import apap.tutorial.manpromanpro.restdto.response.CreateUserResponseDTO;
import apap.tutorial.manpromanpro.restdto.request.CreateUserRequestDTO;
import apap.tutorial.manpromanpro.model.UserModel;
import apap.tutorial.manpromanpro.restservice.RoleRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserRestServiceImpl implements UserRestService {
    
    @Autowired
    private UserDb userDb;

    @Autowired
    private RoleRestService roleService;

    @Override
    public String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Override
    public CreateUserResponseDTO addUser(CreateUserRequestDTO user) {
        UserModel newUser = new UserModel();
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(hashPassword(user.getPassword()));
        newUser.setRole(roleService.getRoleByRoleName(user.getRole()));
        userDb.save(newUser);
        
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        responseDTO.setId(newUser.getId());
        responseDTO.setName(newUser.getName());
        responseDTO.setUsername(newUser.getUsername());
        responseDTO.setRole(newUser.getRole().getRole());
        return responseDTO;
    }
    
}
