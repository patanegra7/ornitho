package cat.dme.ornitho.server;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cat.dme.ornitho.server.model.Bird;
import cat.dme.ornitho.server.model.CatalanBird;
import cat.dme.ornitho.server.model.EnglishBird;
import cat.dme.ornitho.server.model.SpanishBird;
import cat.dme.ornitho.server.service.BirdService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BirdServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(BirdServiceTest.class);

	private static final String ID = "111aa222BB333cde";
	private static final String LATIN_NAME = "Erithacus rubecula";
	private static final String SPANISH_NAME = "Petirrojo";
	private static final String ENGLISH_NAME = "Robin";
	private static final String CATALAN_NAME = "Pit-roig";

	@Autowired
	private BirdService birdService;

	@Test
	public void test1ContextLoads() {
		Assert.assertNotNull(this.birdService);
	}

	@Test()
	public void test2AddBirdTest() {
		LOG.debug("start test2AddBirdTest...");
		final Bird b = new Bird();
		b.setId(ID); // only for test
		b.setName(LATIN_NAME);

		final SpanishBird sB = new SpanishBird();
		sB.setName(SPANISH_NAME);
		final EnglishBird eB = new EnglishBird();
		eB.setName(ENGLISH_NAME);
		final CatalanBird cB = new CatalanBird();
		cB.setName(CATALAN_NAME);

		b.setEs(sB);
		b.setEn(eB);
		b.setCa(cB);

		this.birdService.add(b);
		LOG.trace("test2AddBirdTest returns - bird: {}", b);
		LOG.debug("test2AddBirdTest finish.");
	}

	@Test()
	public void test3GetBirdTest() {
		LOG.debug("start test3GetBirdTest...");
		final Bird bird = this.birdService.get(ID);
		Assert.assertNotNull(bird);
		LOG.trace("test3GetBirdTest returns - bird: {}", bird);
		LOG.debug("test3GetBirdTest finish.");
	}

	@Test()
	public void test4FindBirdTest() {
		LOG.debug("start test4FindBirdTest...");
		final Bird bird = this.birdService.getByName(LATIN_NAME);
		Assert.assertNotNull(bird);
		LOG.trace("test4FindBirdTest returns - bird: {}", bird);

		final List<Bird> birds = this.birdService.getStartByName("Eri");
		Assert.assertNotNull(birds);
		Assert.assertFalse(birds.isEmpty());
		Assert.assertNotNull(birds.get(0));
		LOG.trace("test4FindBirdTest returns - bird: {}", birds.get(0));

		LOG.debug("test4FindBirdTest finish.");
	}

}
