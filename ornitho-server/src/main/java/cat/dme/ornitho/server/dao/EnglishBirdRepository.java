package cat.dme.ornitho.server.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.dme.ornitho.server.model.EnglishBird;

/**
 * TODO
 * @author dmolina
 *
 */
@Repository
public interface EnglishBirdRepository extends MongoRepository<EnglishBird, String> { //, QuerydslPredicateExecutor<Bird> {

	//	Bird findOneById(String id);
	//
	//	@Override
	//	List<Bird> findAll();
	//
	@Override
	void delete(EnglishBird b);
	//
	//	@Override
	//	void deleteAll();

	@Override
	<S extends EnglishBird> S save(S bird);


	List<EnglishBird> findByName(String name);

	List<EnglishBird> findByNameStartingWith(String regexp);

}