package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.model.Role;

import java.util.List;

public interface RoleRestService {
    List<Role> getAllRole();
    Role getRoleByRoleName(String roleName);
}
