package br.gerson.sousa.msvoting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveVoteDto {
    private String name;
    private String cpf;
    private boolean vote;
}
