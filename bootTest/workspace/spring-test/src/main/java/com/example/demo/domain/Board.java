package com.example.demo.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	private int boardSeq;
	private String title;
	private String contents;
	private Date regData;
}
