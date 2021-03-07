package com.hyoseon.board.main.dao;

import java.util.List;

import com.hyoseon.board.main.vo.Board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardInterfaceDao {
    

    //글쓰기
    int post(Board board);

    //전체글리스트 불러오기
    List<Board> getAllList();
}
