package cat.dme.ornitho.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cat.dme.ornitho.server.dao.BirdRepository;
import cat.dme.ornitho.server.dao.CatalanBirdRepository;
import cat.dme.ornitho.server.dao.EnglishBirdRepository;
import cat.dme.ornitho.server.dao.SpanishBirdRepository;
import cat.dme.ornitho.server.model.Bird;
import cat.dme.ornitho.server.service.BirdService;

/**
 * 
 * TODO
 *
 */
@Service
public class BirdServiceImpl implements BirdService {

	private static final Logger LOG = LoggerFactory.getLogger(BirdServiceImpl.class);

	@Autowired
	private BirdRepository birdRepository;

	@Autowired
	private CatalanBirdRepository catalanBirdRepository;

	@Autowired
	private SpanishBirdRepository spanishBirdRepository;

	@Autowired
	private EnglishBirdRepository englishBirdRepository;

	/**
	 * Default constructor.
	 */
	public BirdServiceImpl() {
		super();
	}

	@Override
	public List<Bird> getList() {
		LOG.debug("start getList...");
		final List<Bird> aList = this.birdRepository.findAll();
		LOG.trace("getList returns - birds: {}", aList);
		LOG.debug("getList finish.");
		return aList;
	}

	@Override
	public Bird get(final String birdId) {
		LOG.debug("start get...");
		LOG.trace("get param - birdId: {}", birdId);
		final Bird bird = this.birdRepository.findOneById(birdId);
		LOG.trace("get returns - bird: {}", bird);
		LOG.debug("get finish.");
		return bird;
	}

	@Override
	public void delete(final String birdId) {

		//TODO: Hay que recuperar y borrar los otros primero.


		this.birdRepository.deleteById(birdId);
	}

	@Override
	public void update(final Bird bird) {
		LOG.debug("update add...");
		LOG.trace("update param - bird: {}", bird);
		this.add(bird);
		LOG.debug("update finish.");
	}

	@Override
	public void add(final Bird bird) {
		LOG.debug("start add...");
		LOG.trace("add param - bird: {}", bird);
		if(bird.getEs()!=null) {
			this.spanishBirdRepository.save(bird.getEs());
		}
		if(bird.getEn()!=null) {
			this.englishBirdRepository.save(bird.getEn());
		}
		if(bird.getCa()!=null) {
			this.catalanBirdRepository.save(bird.getCa());
		}
		this.birdRepository.save(bird);
		LOG.debug("add finish.");
	}

	@Override
	public Page<Bird> getPage(final Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bird getByName(final String name) {
		LOG.debug("start getByName...");
		LOG.trace("getByName param - name: {}", name);
		final List<Bird> birds = this.birdRepository.findByName(name);
		Bird bird = null;
		if(birds!=null && birds.size()>0) {
			bird = birds.get(0);
		}
		LOG.trace("getByName returns - bird: {}", bird);
		LOG.debug("getByName finish.");	
		return bird;
	}

	@Override
	public List<Bird> getStartByName(final String name) {
		LOG.debug("start getStartByName...");
		LOG.trace("getStartByName param - name: {}", name);
		final List<Bird> birds = this.birdRepository.findByNameStartingWith(name);
		LOG.trace("getStartByName returns - bird: {}", birds);
		LOG.debug("getStartByName finish.");	
		return birds;
	}

}
