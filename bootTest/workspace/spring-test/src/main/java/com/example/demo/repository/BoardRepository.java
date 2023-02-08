package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Board;


@Repository
public interface BoardRepository {
	List<Board> getList();
	
	Board get(int boardSeq);
	
	int save(Board board);
	
	boolean delete(int boardSeq);
}
