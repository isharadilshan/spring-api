package com.alphabit.api.repo;

import com.alphabit.api.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RolesRepository extends CrudRepository<Role,String> {//name of the entity class name with type of the primary key
    List<Role> findAll();
    Role findByNic(String nic);
    List<Role> findAllByOrganizationAndRoleType(String organization, Role.RoleType roleType);
}
