package com.example.demo.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.exception.BaseException;
import com.example.demo.configuration.http.BaseResponse;
import com.example.demo.configuration.http.BaseResponseCode;
import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board")
@Api(tags = "게시판API")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	@ApiOperation(value="리스트", notes = "T_BOARD테이블의 모든 리스트")
	public BaseResponse<List<Board>> getList(){
		return new BaseResponse<List<Board>>(BaseResponseCode.SUCCESS, boardService.getList());
	}
	
	@GetMapping("/{boardSeq}")
	public BaseResponse<Board> get(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if(board == null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});
		}
		System.out.println(BaseResponseCode.SUCCESS.name());
//		return new BaseResponse<Board>(BaseResponseCode.SUCCESS, boardService.get(boardSeq));
		return new BaseResponse<Board>(BaseResponseCode.SUCCESS, messageSource.getMessage(BaseResponseCode.SUCCESS.name(), null, null));
	}
	
	@PutMapping("/save")
	@ApiOperation(value="리스트", notes = "T_BOARD테이블의 모든 리스트")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
		@ApiImplicitParam(name = "title", value = "게시물 제목", example = "제목"),
		@ApiImplicitParam(name = "contents", value = "게시물 내용", example = "내용")
	})
	public BaseResponse<Integer> save(Board parameter) {
		return new BaseResponse<Integer>(BaseResponseCode.SUCCESS, boardService.save(parameter));
	}
	
	@GetMapping("/delete/{boardSeq}")
	public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
		return new BaseResponse<Boolean>(BaseResponseCode.SUCCESS, boardService.delete(boardSeq));
	}
}
