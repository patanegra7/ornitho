/**
 * 
 */
package cat.dme.ornitho.server.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author dmolina
 *
 */
@Document(language="english")
public class EnglishBird extends BirdI18n {
	private static final long serialVersionUID = 5206084581860378687L;
}
