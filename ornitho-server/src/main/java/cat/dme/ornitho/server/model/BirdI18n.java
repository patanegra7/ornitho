package cat.dme.ornitho.server.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A localized bird name.
 */
public abstract class BirdI18n implements Serializable {

	private static final long serialVersionUID = -1462941288380420530L;

	/**
	 * Bird unique identifier.
	 */
	@Id
	private String id;

	/**
	 * Scientific bird name.
	 */
	@Field
	@Indexed(unique=true)
	@TextIndexed
	private String name;

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("BirdI18n [");
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.name != null) {
			builder.append("name=");
			builder.append(this.name);
		}
		builder.append("]");
		return builder.toString();
	}

}
