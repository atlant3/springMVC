package pl.ciechocinek.mb.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.ciechocinek.mb.domain.Participant;
import pl.ciechocinek.mb.service.ParticipantService;

@Controller
public class ParticipantController {
	@Autowired
	private ParticipantService participantService;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("participants", participantService.findAll());
		req.setAttribute("mode", "VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newParticipant(HttpServletRequest req) {
		req.setAttribute("mode", "CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
		participantService.save(participant);
		req.setAttribute("participants", participantService.findAll());
		req.setAttribute("mode", "VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam Long id, HttpServletRequest req) {
		participantService.findByid(id);
		req.setAttribute("participant", participantService.findByid(id));
		req.setAttribute("mode", "EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam Long id, HttpServletRequest req) {
		participantService.deleteById(id);
		req.setAttribute("participants", participantService.findAll());
		req.setAttribute("mode", "VIEW");
		return "index";
	}
}
