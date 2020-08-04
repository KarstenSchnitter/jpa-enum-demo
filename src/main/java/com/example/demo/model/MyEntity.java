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
@Table(name = "entities")
@Access(AccessType.PROPERTY)
public class MyEntity {

	private String id;
	private Map<Keys, Values> map;

	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ElementCollection
	@JoinTable(name = "join_table", joinColumns = @JoinColumn(name = "my_entitiy_id"))
	@Column(name = "my_map_values")
	@Enumerated(EnumType.STRING)
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "my_map_keys")
	public Map<Keys, Values> getMyMap() {
		return map;
	}

	public void setMyMap(Map<Keys, Values> map) {
		this.map = map;
	}

	public enum Keys {
		IMPORTANT, UNIMPORTANT;
	}

	public enum Values {
		MILK, WINE, BEER;
	}

}
