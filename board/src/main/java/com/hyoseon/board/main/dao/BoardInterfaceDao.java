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

    //postidx에 해당하는 글 정보
    Board postByIdx(int postidx);

    //글번호와 비밀번호 체크
    int passchk(int postidx, String postPassword);

    // 글 수정
    int updatePost(Board board);

    // 비밀번호 확인하기
    int passChk(int postidx, int postPassword);

    // 파일이름 받아오기
    String getFileName(int postidx, int postPassword);

    // 글 삭제하기
    int deletePost(int postidx, int postPassword);
}
