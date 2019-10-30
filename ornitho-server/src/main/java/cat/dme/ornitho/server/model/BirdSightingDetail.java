/**
 * 
 */
package cat.dme.ornitho.server.model;

import java.io.Serializable;
import java.util.List;

/**
 * Bird sighting details as sex, age, ...
 */
public class BirdSightingDetail implements Serializable {

	private static final long serialVersionUID = -5980230245478523020L;

	private Integer amount;

	private Sex sex;

	private Boolean immature;

	private Boolean breeding; 

	private Boolean chick;

	private List<SightingAction> actions;

	private List<SightingType> types;

	private String remarks;

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return this.amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the sex
	 */
	public Sex getSex() {
		return this.sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(final Sex sex) {
		this.sex = sex;
	}

	/**
	 * @return the immature
	 */
	public Boolean getImmature() {
		return this.immature;
	}

	/**
	 * @param immature the immature to set
	 */
	public void setImmature(final Boolean immature) {
		this.immature = immature;
	}

	/**
	 * @return the breeding
	 */
	public Boolean getBreeding() {
		return this.breeding;
	}

	/**
	 * @param breeding the breeding to set
	 */
	public void setBreeding(final Boolean breeding) {
		this.breeding = breeding;
	}

	/**
	 * @return the chick
	 */
	public Boolean getChick() {
		return this.chick;
	}

	/**
	 * @param chick the chick to set
	 */
	public void setChick(final Boolean chick) {
		this.chick = chick;
	}

	/**
	 * @return the actions
	 */
	public List<SightingAction> getActions() {
		return this.actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(final List<SightingAction> actions) {
		this.actions = actions;
	}

	/**
	 * @return the types
	 */
	public List<SightingType> getTypes() {
		return this.types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(final List<SightingType> types) {
		this.types = types;
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

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("BirdSightingDetail [");
		if (this.amount != null) {
			builder.append("amount=");
			builder.append(this.amount);
			builder.append(", ");
		}
		if (this.sex != null) {
			builder.append("sex=");
			builder.append(this.sex);
			builder.append(", ");
		}
		if (this.immature != null) {
			builder.append("immature=");
			builder.append(this.immature);
			builder.append(", ");
		}
		if (this.breeding != null) {
			builder.append("breeding=");
			builder.append(this.breeding);
			builder.append(", ");
		}
		if (this.chick != null) {
			builder.append("chick=");
			builder.append(this.chick);
			builder.append(", ");
		}
		if (this.actions != null) {
			builder.append("actions=");
			builder.append(this.actions);
			builder.append(", ");
		}
		if (this.types != null) {
			builder.append("types=");
			builder.append(this.types);
			builder.append(", ");
		}
		if (this.remarks != null) {
			builder.append("remarks=");
			builder.append(this.remarks);
		}
		builder.append("]");
		return builder.toString();
	}

}
