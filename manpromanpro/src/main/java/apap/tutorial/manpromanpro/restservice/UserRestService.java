package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.restdto.request.CreateUserRequestDTO;
import apap.tutorial.manpromanpro.restdto.response.CreateUserResponseDTO;

public interface UserRestService {
    CreateUserResponseDTO addUser(CreateUserRequestDTO user);
    String hashPassword(String password);
}
