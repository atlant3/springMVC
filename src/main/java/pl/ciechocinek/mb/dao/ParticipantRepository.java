package pl.ciechocinek.mb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import pl.ciechocinek.mb.domain.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long>, CrudRepository<Participant, Long> {

}
