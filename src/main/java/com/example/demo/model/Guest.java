package com.example.demo.model;

import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

@Entity
@Table(name = "guests")
@Access(AccessType.PROPERTY)
public class Guest {

	private String id;
	private Map<Beverages, Sentiments> map;

	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ElementCollection
	@JoinTable(name = "sentiments", joinColumns = @JoinColumn(name = "guest_id"))
	@Column(name = "sentiment")
	@Enumerated(EnumType.STRING)
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "beverage")
	public Map<Beverages, Sentiments> getMyMap() {
		return map;
	}

	public void setMyMap(Map<Beverages, Sentiments> map) {
		this.map = map;
	}

	public enum Sentiments {
		LIKE, DISLIKE;
	}

	public enum Beverages {
		MILK, WINE, BEER;
	}

}
