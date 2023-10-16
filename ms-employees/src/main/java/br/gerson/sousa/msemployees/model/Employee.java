package br.gerson.sousa.msemployees.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String password;

    public Employee(String name, String cpf, String address, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.email = email;
        this.password = password;
    }
}