package cat.dme.ornitho.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cat.dme.ornitho.server.model.Bird;
import cat.dme.ornitho.server.service.BirdService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/bird")
public class BirdController {

	private static final Logger LOG = LoggerFactory.getLogger(BirdController.class);

	@Autowired
	private BirdService birdService;

	@RequestMapping(path = "/{birdId}", method = RequestMethod.GET)
	public Bird getBird(@PathVariable final String birdId) {
		BirdController.LOG.info("Getting bird...");
		BirdController.LOG.info("Getting bird parameter - birdId: {}", birdId);
		final Bird bird = this.birdService.get(birdId);
		BirdController.LOG.info("Bird {} got!", birdId);
		return bird;
	}

	@RequestMapping(path = "/name/{birdName}", method = RequestMethod.GET)
	public Bird getBirdByName(@PathVariable final String birdName) {
		BirdController.LOG.info("Getting bird by name...");
		BirdController.LOG.info("Getting bird parameter - birdName: {}", birdName);
		final Bird bird = this.birdService.getByName(birdName);
		BirdController.LOG.info("Bird by name {} got!", birdName);
		return bird;
	}

	@RequestMapping(path = "/starts/{birdName}", method = RequestMethod.GET)
	public List<Bird> getBirdByNameStarts(@PathVariable final String birdName) {
		BirdController.LOG.info("Getting bird by name starts...");
		BirdController.LOG.info("Getting bird by name starts parameter - birdName: {}", birdName);
		final List<Bird> birds = this.birdService.getStartByName(birdName);
		BirdController.LOG.info("Getting bird by name starts {} got!", birdName);
		return birds;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateBird(@RequestBody final Bird bird) {
		BirdController.LOG.info("Updating bird...");
		BirdController.LOG.info("Getting bird parameter - bird: {}", bird);
		this.birdService.update(bird);
		BirdController.LOG.info("Bird {} updated!", bird.getId());
	}

	@RequestMapping(method = RequestMethod.POST)
	public Bird addBird(@RequestBody final Bird bird) {
		BirdController.LOG.info("Adding bird...");
		BirdController.LOG.info("Adding bird parameter - bird: {}", bird);
		this.birdService.add(bird);
		BirdController.LOG.info("Customer {} added!", bird.getId());
		return bird;
	}

	@RequestMapping(path = "/{birdId}", method = RequestMethod.DELETE)
	public void deleteBird(@PathVariable final String birdId) {
		BirdController.LOG.info("Deleting bird...");
		BirdController.LOG.info("Deleting bird parameter - birdId: {}", birdId);
		this.birdService.delete(birdId);
		BirdController.LOG.info("Bird {} deleted!", birdId);
	}

}
