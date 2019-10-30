package cat.dme.ornitho.server.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cat.dme.ornitho.server.model.Bird;

/**
 * 
 * TODO: JAvadoc
 * 
 */
public interface BirdService {

	/**
	 * TODO: JAvadoc
	 * @return
	 * @deprecated Uses pages!
	 */
	@Deprecated
	List<Bird> getList(); 

	/**
	 * 
	 * @return
	 */
	Page<Bird> getPage(Pageable pageable);

	/**
	 * TODO: JAvadoc
	 * @return
	 */
	Bird get(String birdId);

	/**
	 * TODO: JAvadoc
	 * @return
	 */
	Bird getByName(String name);

	/**
	 * TODO: JAvadoc
	 * @return
	 */
	List<Bird> getStartByName(String name);

	/**
	 * TODO: JAvadoc
	 * @return
	 */
	void delete(String birdId);

	/**
	 * TODO: JAvadoc
	 * @return
	 */
	void update(Bird bird);

	/**
	 * TODO: JAvadoc
	 * @return
	 */
	void add(Bird bird);
}
