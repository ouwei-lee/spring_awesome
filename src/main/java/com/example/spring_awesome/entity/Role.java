package com.example.spring_awesome.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @date: 2021/9/14 13:49
 */
@Data
@ToString
public class Role implements Serializable {
	private static final long serialVersionUID = -1767327914553823741L;

	private Integer id;

	private String role;

	private String desc;
}
