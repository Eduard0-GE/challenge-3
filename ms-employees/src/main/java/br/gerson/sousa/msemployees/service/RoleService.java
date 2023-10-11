package br.gerson.sousa.msemployees.service;

import br.gerson.sousa.msemployees.dto.FindRoleDto;
import br.gerson.sousa.msemployees.dto.SaveRoleDto;
import br.gerson.sousa.msemployees.model.Employee;
import br.gerson.sousa.msemployees.model.Role;
import br.gerson.sousa.msemployees.repository.EmployeeRepository;
import br.gerson.sousa.msemployees.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, EmployeeRepository employeeRepository){
        this.roleRepository = roleRepository;
        this.employeeRepository = employeeRepository;
    }

    public void save(SaveRoleDto dto){
        Employee emp = employeeRepository.findByCpf(dto.getCpf()).get();
        roleRepository.save(new Role(emp, dto.getRole()));
    }

    public List<FindRoleDto> findAll(){
        List<Role> roles= roleRepository.findAll();
        List<FindRoleDto> dtos = new ArrayList<>();
        for(Role role: roles){
            dtos.add(new FindRoleDto(role));
        }
        return dtos;
    }

    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }

    public Optional<Role> findByEmployee(String cpf){
        Employee emp = employeeRepository.findByCpf(cpf).get();
        return roleRepository.findByEmployee(emp);
    }

    public void deleteById(Long id){
        roleRepository.deleteById(id);
    }

    public void deleteByEmployee(Employee emp){
        roleRepository.deleteByEmployee(emp);
    }
}
