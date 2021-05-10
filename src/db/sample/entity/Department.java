package db.sample.entity;

import java.sql.Timestamp;

public class Department {

	private long id;
	
	private String name;
	
	private Timestamp created;
	
	private Timestamp modified;
	
	private Timestamp deleted;

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return created
	 */
	public Timestamp getCreated() {
		return created;
	}

	/**
	 * @param created セットする created
	 */
	public void setCreated(Timestamp created) {
		this.created = created;
	}

	/**
	 * @return modified
	 */
	public Timestamp getModified() {
		return modified;
	}

	/**
	 * @param modified セットする modified
	 */
	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	/**
	 * @return deleted
	 */
	public Timestamp getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted セットする deleted
	 */
	public void setDeleted(Timestamp deleted) {
		this.deleted = deleted;
	}
	
	
}
