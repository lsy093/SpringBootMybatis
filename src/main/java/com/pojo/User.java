package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"name", "age", "phone", "password" })
public class User {
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("age")
	private int age;
	@JsonProperty("phone")
	private int phone;
	@JsonProperty("password")
	private String password;
}
