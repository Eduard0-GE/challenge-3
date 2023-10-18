package br.gerson.sousa.msvoting.controller;

import br.gerson.sousa.msvoting.dto.SaveProposalDto;
import br.gerson.sousa.msvoting.model.Proposal;
import br.gerson.sousa.msvoting.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProposalController {
    private ProposalService service;

    @Autowired
    public ProposalController(ProposalService service){
        this.service = service;
    }

    @PostMapping("/proposal/name/{name}/start-poll")
    public ResponseEntity<String > startPoll(@PathVariable String name, @RequestParam String cpf, @RequestParam(required = false)Duration duration){
        service.startPoll(name, cpf, duration);
        return ResponseEntity.ok().body("DDD");
    }

    @PostMapping("/proposal/name/{name}/end-poll")
    public ResponseEntity<String > endPoll(@PathVariable String name, @RequestParam String cpf){
        service.endPoll(name, cpf);
        return ResponseEntity.ok().body("DDD");
    }

    @PostMapping("/proposal")
    public ResponseEntity<String> create(@RequestBody SaveProposalDto dto){
        service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }

    @GetMapping("/proposal")
    public ResponseEntity<List<SaveProposalDto>> findAll(){
        return ResponseEntity.ok().body(service.findALl());
    }

    @GetMapping("/proposal/result/{result}")
    public ResponseEntity<List<Proposal>> findAllByResult(@PathVariable boolean result){
        return ResponseEntity.ok().body(service.findAllByResult(result));
    }

    @GetMapping("/proposal/id/{id}")
    public ResponseEntity<SaveProposalDto> findById(@PathVariable long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/proposal/name/{name}")
    public ResponseEntity<SaveProposalDto> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(service.findByName(name));
    }

    @DeleteMapping("/proposal/id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().body("Deleted");
    }

    @DeleteMapping("/proposal/name/{name}")
    public ResponseEntity<String> deleteById(@PathVariable String name){
        service.deleteByName(name);
        return ResponseEntity.ok().body("Deleted");
    }
}
