package cat.dme.ornitho.server.service.dummy.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cat.dme.ornitho.server.model.Bird;
import cat.dme.ornitho.server.service.BirdService;
import cat.dme.ornitho.server.util.FileUtil;
import cat.dme.ornitho.server.util.JSONUtil;

/**
 * 
 * TODO
 * @author dmolina
 *
 */
//@Service
public class DummyBirdServiceImpl implements BirdService {

	private static final Logger LOG = LoggerFactory.getLogger(DummyBirdServiceImpl.class);

	private final Map<String, Bird> birds;
	private Long lastId;

	/**
	 * Default constructor.
	 */
	public DummyBirdServiceImpl() {
		super();
		this.birds = new LinkedHashMap<>();
		this.lastId = Long.valueOf(0);
		try {
			final String jsonBirdsResponseOK = FileUtil.readStrFromJsonResourceFile("birds/jsonBirdsResponseOk.json");
			@SuppressWarnings("unchecked")
			final List<Bird> BirdList = (List<Bird>) JSONUtil.convertJsonStringToParametrizedObject(jsonBirdsResponseOK, List.class, Bird.class);
			for (final Bird bird : BirdList) {
				this.birds.put(bird.getId(), bird);
				if (Long.valueOf(bird.getId()) > this.lastId) {
					this.lastId = Long.valueOf(bird.getId());
				}
			}
		} catch (final Exception e) {
			LOG.error("Error retrieving bird data", e);
		}
	}

	@Override
	public List<Bird> getList() {
		final List<Bird> aList = new ArrayList<>();
		for (final Iterator<Bird> iterator = this.birds.values().iterator(); iterator.hasNext();) {
			aList.add(iterator.next());
		}
		return aList;
	}

	@Override
	public Bird get(final String birdId) {
		return this.birds.get(birdId);
	}

	@Override
	public void delete(final String birdId) {
		this.birds.remove(birdId);
	}

	@Override
	public void update(final Bird bird) {
		this.birds.put(bird.getId(), bird);
	}

	@Override
	public void add(final Bird bird) {
		bird.setId(this.nextId());
		this.birds.put(bird.getId(), bird);
	}

	private String nextId() {
		return (++this.lastId).toString();
	}

	@Override
	public Page<Bird> getPage(final Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bird getByName(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bird> getStartByName(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
