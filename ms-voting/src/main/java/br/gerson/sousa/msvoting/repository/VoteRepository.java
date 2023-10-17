package br.gerson.sousa.msvoting.repository;

import br.gerson.sousa.msvoting.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Vote save(Vote vote);

    List<Vote> findAll();

    Optional<Vote> findById(Long id);

    void deleteById(Long id);
}