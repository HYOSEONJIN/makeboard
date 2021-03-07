package com.hyoseon.board.main.dao;

import com.hyoseon.board.main.vo.Board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardInterfaceDao {
    

    //글쓰기
    int post(Board board);
}
