package cat.dme.ornitho.server.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * Birdwatching's Sightings.
 */
public class Sightings implements Serializable {

	private static final long serialVersionUID = -7844526673372281016L;

	private Long id;

	private Instant date;

	private Place place;

	private Bird bird;

	private List<BirdSightingDetail> details;

	private String remarks;

	private List<String> photos;

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Instant getDate() {
		return this.date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(final Instant date) {
		this.date = date;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return this.place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(final Place place) {
		this.place = place;
	}

	/**
	 * @return the bird
	 */
	public Bird getBird() {
		return this.bird;
	}

	/**
	 * @param bird the bird to set
	 */
	public void setBird(final Bird bird) {
		this.bird = bird;
	}

	/**
	 * @return the details
	 */
	public List<BirdSightingDetail> getDetails() {
		return this.details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(final List<BirdSightingDetail> details) {
		this.details = details;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(final String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the photos
	 */
	public List<String> getPhotos() {
		return this.photos;
	}

	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(final List<String> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Sightings [");
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.date != null) {
			builder.append("date=");
			builder.append(this.date);
			builder.append(", ");
		}
		if (this.place != null) {
			builder.append("place=");
			builder.append(this.place);
			builder.append(", ");
		}
		if (this.bird != null) {
			builder.append("bird=");
			builder.append(this.bird);
			builder.append(", ");
		}
		if (this.details != null) {
			builder.append("details=");
			builder.append(this.details);
			builder.append(", ");
		}
		if (this.remarks != null) {
			builder.append("remarks=");
			builder.append(this.remarks);
			builder.append(", ");
		}
		if (this.photos != null) {
			builder.append("photos=");
			builder.append(this.photos);
		}
		builder.append("]");
		return builder.toString();
	}

}
