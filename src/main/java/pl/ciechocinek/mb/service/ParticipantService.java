package pl.ciechocinek.mb.service;

import java.util.List;

import pl.ciechocinek.mb.domain.Participant;

public interface ParticipantService {
	Participant save(Participant articipant);

	Participant findByid(Long id);

	Participant update(Participant participant);

	void deleteById(Long id);

	List<Participant> findAll();

}
