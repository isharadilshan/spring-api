package com.alphabit.api.controller;

import com.alphabit.api.domain.FilteredRole;
import com.alphabit.api.domain.Role;
import com.alphabit.api.repo.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        path = "/api/v1/roles",
        produces = MediaType.APPLICATION_JSON_VALUE
)
//Autowired annotation doesnt needed since injection happening in the constructor
@AllArgsConstructor
public class RoleController {

    private final RolesRepository roles;

    //retrieve roles using nic
    @GetMapping(path = "/{nic}")
    public Role findByNic(@PathVariable String nic) {
        return roles.findByNic(nic);
    }

    //retrieve all roles
    @GetMapping
    public Iterable<Role> findAll() {
        return roles.findAll();
    }

    //create new role
    @PostMapping
    public Role save(@RequestBody Role role) {
        return roles.save(role);
    }

    //update role
    @PutMapping("/{nic}")
    public Role update(@RequestBody Role role, @PathVariable String nic) {
        Role updatedRole = roles.findByNic(nic);
        if (updatedRole != null) {
            updatedRole.setFirstName(role.getFirstName());
            updatedRole.setLastName((role.getLastName()));
            updatedRole.setNic(role.getNic());
            updatedRole.setOrganization(role.getOrganization());
            updatedRole.setRoleType(role.getRoleType());
        }
        return roles.save(role);
    }
    
    //delete role
//     @DeleteMapping("/{nic}")
//     public Role delete(@PathVariable("nic") String nic){
//         Role role = roles.findByNic(nic);
//         return roles.delete(Role role);
//     }

    //search roles using specific oql
    @GetMapping("/search")
    public List<FilteredRole> findByOrgAndNic(@RequestParam("org") String organization, @RequestParam("roleType") String roleType){
        return roles
                .findAllByOrganizationAndRoleType(organization, Role.RoleType.valueOf(roleType))
                .stream()
                .map(role -> new FilteredRole(role.getFirstName(), role.getLastName(), role.getNic()))
                .collect(Collectors.toList());
    }
}
