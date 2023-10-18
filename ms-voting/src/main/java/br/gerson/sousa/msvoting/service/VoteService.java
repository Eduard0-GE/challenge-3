package br.gerson.sousa.msvoting.service;

import br.gerson.sousa.msvoting.dto.SaveVoteDto;
import br.gerson.sousa.msvoting.model.DateFormatter;
import br.gerson.sousa.msvoting.model.Proposal;
import br.gerson.sousa.msvoting.model.Vote;
import br.gerson.sousa.msvoting.repository.ProposalRepository;
import br.gerson.sousa.msvoting.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
    private VoteRepository voteRepository;
    private ProposalRepository proposalRepository;
    private DateFormatter formatter = new DateFormatter();

    @Autowired
    public VoteService(VoteRepository voteRepository, ProposalRepository proposalRepository){
        this.voteRepository = voteRepository;
        this.proposalRepository = proposalRepository;
    }

    public void save(SaveVoteDto dto){
        Optional<Proposal> proposal = proposalRepository.findByName(dto.getName());
        LocalDateTime now = LocalDateTime.now();
        if(now.isBefore(formatter.stringToDate(proposal.get().getEndingDate()))){
            voteRepository.save(new Vote(proposal.get(), dto.getCpf(), dto.isApproved()));
        }
    }

    public List<Vote> findAll(){
        return voteRepository.findAll();
    }

    public List<Vote> findAllByProposal_Name(String name){
        return voteRepository.findAllByProposal_Name(name);
    }

    public List<Vote> findAllByProposal_Id(Long id){
        return voteRepository.findAllByProposal_Id(id);
    }

    public List<Vote> findAllByCpf(String cpf){
        return voteRepository.findAllByCpf(cpf);
    }

    public void deleteById(Long id){voteRepository.deleteById(id);}

    public void deleteAllByCpf(String cpf){voteRepository.deleteAllByCpf(cpf);}

}
