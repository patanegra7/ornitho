package cat.dme.ornitho.server.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.dme.ornitho.server.model.Bird;

/**
 * TODO
 * @author dmolina
 *
 */
@Repository
public interface BirdRepository extends MongoRepository<Bird, String> { //, QuerydslPredicateExecutor<Bird> {

	Bird findOneById(String id);

	@Override
	List<Bird> findAll();

	@Override
	void delete(Bird b);

	@Override
	void deleteAll();

	@Override
	<S extends Bird> S save(S bird);


	List<Bird> findByName(String name);

	List<Bird> findByNameStartingWith(String regexp);

}