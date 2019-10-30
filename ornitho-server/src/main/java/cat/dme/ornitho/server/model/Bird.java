package cat.dme.ornitho.server.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A bird data.
 */
@Document(language="spanish")
public class Bird implements Serializable {

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
	 * A bird name in different languages.
	 */
	@DBRef
	private SpanishBird es;

	@DBRef
	private EnglishBird en;

	@DBRef
	private CatalanBird ca;

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

	/**
	 * @return the es
	 */
	public SpanishBird getEs() {
		return this.es;
	}

	/**
	 * @param es the es to set
	 */
	public void setEs(final SpanishBird es) {
		this.es = es;
	}

	/**
	 * @return the en
	 */
	public EnglishBird getEn() {
		return this.en;
	}

	/**
	 * @param en the en to set
	 */
	public void setEn(final EnglishBird en) {
		this.en = en;
	}

	/**
	 * @return the ca
	 */
	public CatalanBird getCa() {
		return this.ca;
	}

	/**
	 * @param ca the ca to set
	 */
	public void setCa(final CatalanBird ca) {
		this.ca = ca;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Bird [");
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.name != null) {
			builder.append("name=");
			builder.append(this.name);
			builder.append(", ");
		}
		if (this.es != null) {
			builder.append("es=");
			builder.append(this.es);
			builder.append(", ");
		}
		if (this.en != null) {
			builder.append("en=");
			builder.append(this.en);
			builder.append(", ");
		}
		if (this.ca != null) {
			builder.append("ca=");
			builder.append(this.ca);
		}
		builder.append("]");
		return builder.toString();
	}

}
