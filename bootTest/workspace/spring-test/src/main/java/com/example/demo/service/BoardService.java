package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository repository;
	
	public List<Board> getList(){
		return repository.getList();
	}
	
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	}
	
	public int save(Board parameter) {
		Board board = repository.get(parameter.getBoardSeq());
		if(board == null) {
			repository.save(parameter);
		}
		return parameter.getBoardSeq();
	}
	
	public boolean delete(int boardSeq) {
		return repository.delete(boardSeq);
	}
}
