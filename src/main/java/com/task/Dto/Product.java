package com.task.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	private Long pid;

	private String name;

	private String description;

	private Double price;

	private String isactive;

	private LocalDate createDate;

	private LocalDate updateDate;

}
