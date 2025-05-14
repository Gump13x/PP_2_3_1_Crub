package com.bp.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	@NotEmpty(message = "Введите имя, это обязательное поле")
	@Size(min = 2, max = 20, message = "Имя - от 2 до 20 символов")
	@Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы")
	private String name;

	@Column(name = "surname")
	@NotEmpty(message = "Введите фамилию")
	@Size(min = 2, max = 25, message = "Фамилия - от 2 до 25 символов")
	@Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы")
	private String surname;

	@Column(name = "age")
	@Min(value = 0, message = "Возраст должен быть положительным числом")
	@Max(value = 150, message = "Возраст должен быть реальным")
	private int age;

	@Column(name = "mail")
	@NotEmpty(message = "Вы не указали электронную почту")
	@Email
	@Size(min = 4, max = 40, message = "Введите корректный почтовый адрес")
	private String mail;

	public User(String name, String surname, int age, String mail) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.mail = mail;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Users{" + "id=" + id + ", name='" + name + '\'' + ", lastName='"
				+ surname + '\'' + ", age=" + age + ", mail='" + mail + '\''
				+ '}';
	}
}