package com.bp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "mylastname")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "The name cannot be empty!")
	@Pattern(regexp = "^[A-Za-zА-Яа-яЁё]+$", message = "The name must contain only letters")
	private String name;

	@NotBlank(message = "The last name must contain only letters")
	@Pattern(regexp = "^[A-Za-zА-Яа-яЁё]+$", message = "Last name must contain only letters")
	private String sureName;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSureName() {
		return sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", sureName='"
				+ sureName + '\'' + '}';
	}
}