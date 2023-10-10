package br.gerson.sousa.msemployees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FindEmployeeDto {
    private String name;
    private String cpf;
    private String address;
    private String email;
}
