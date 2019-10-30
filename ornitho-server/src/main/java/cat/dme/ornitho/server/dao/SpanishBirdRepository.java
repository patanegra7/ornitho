package cat.dme.ornitho.server.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.dme.ornitho.server.model.SpanishBird;

/**
 * TODO
 * @author dmolina
 *
 */
@Repository
public interface SpanishBirdRepository extends MongoRepository<SpanishBird, String> { //, QuerydslPredicateExecutor<Bird> {

	//	Bird findOneById(String id);
	//
	//	@Override
	//	List<Bird> findAll();
	//
	@Override
	void delete(SpanishBird b);
	//
	//	@Override
	//	void deleteAll();

	@Override
	<S extends SpanishBird> S save(S bird);


	List<SpanishBird> findByName(String name);

	List<SpanishBird> findByNameStartingWith(String regexp);

}