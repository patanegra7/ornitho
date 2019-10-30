package cat.dme.ornitho.server.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.dme.ornitho.server.model.CatalanBird;

/**
 * TODO
 * @author dmolina
 *
 */
@Repository
public interface CatalanBirdRepository extends MongoRepository<CatalanBird, String> { //, QuerydslPredicateExecutor<Bird> {

	//	Bird findOneById(String id);
	//
	//	@Override
	//	List<Bird> findAll();
	//
	@Override
	void delete(CatalanBird b);
	//
	//	@Override
	//	void deleteAll();

	@Override
	<S extends CatalanBird> S save(S bird);


	List<CatalanBird> findByName(String name);

	List<CatalanBird> findByNameStartingWith(String regexp);

}