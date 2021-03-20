package pl.ciechocinek.mb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ciechocinek.mb.dao.ParticipantRepository;
import pl.ciechocinek.mb.domain.Participant;
import pl.ciechocinek.mb.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;


	@Override
	public Participant save(Participant participant) {
		Participant updateParticipant = null;
		if(participant.getId() != null) {
			updateParticipant = findByid(participant.getId());
			updateParticipant.setId(participant.getId());
			updateParticipant.setName(participant.getName());
			updateParticipant.setEmail(participant.getEmail());
			updateParticipant.setPrimarySkill(participant.getPrimarySkill());
			updateParticipant.setLevel(participant.getLevel());
			participantRepository.save(updateParticipant);
		}
		else {
			participantRepository.save(participant);
		}
		return participant;
	}

	@Override
	public Participant findByid(Long id) {
		return participantRepository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		participantRepository.deleteById(id);

	}

	@Override
	public List<Participant> findAll() {
		return participantRepository.findAll();
	}
	@Override
	public Participant update(Participant participant) {
//		Participantz parti = participantRepository.getOne(id);
//		System.out.print("Jestem");
//		Participant updateParticipant = null;
//		updateParticipant = participantRepository.getOne(id);
//		
//		updateParticipant.setName(parti.getName());
//		updateParticipant.setEmail(parti.getEmail());
//		updateParticipant.setPrimarySkill(parti.getPrimarySkill());
//		updateParticipant.setLevel(parti.getLevel());
//		participantRepository.save(updateParticipant);
//		System.out.print(updateParticipant.toString());
		return participant;

	}

}
