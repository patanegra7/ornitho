package cat.dme.ornitho.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cat.dme.ornitho.server.model.Bird;
import cat.dme.ornitho.server.service.BirdService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/birds")
public class BirdsController {

	private static final Logger LOG = LoggerFactory.getLogger(BirdsController.class);

	@Autowired
	private BirdService birdService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Bird> getBirds() {
		BirdsController.LOG.info("Getting birds...");
		final List<Bird> birds = this.birdService.getList();
		BirdsController.LOG.info("Birds got!");
		return birds;
	}
}
