package com.hyoseon.board.main.service;

import com.hyoseon.board.main.dao.BoardInterfaceDao;
import com.hyoseon.board.main.vo.Board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    // READ UPDATE DELETE 서비스

    private BoardInterfaceDao dao;

    @Autowired
    private SqlSessionTemplate template;

    public Board readPost(int postidx){

        Board board = null;

        try{
        dao = template.getMapper(BoardInterfaceDao.class);
        board = dao.postByIdx(postidx);
        }catch(Exception e){
            e.printStackTrace();
        }

        return board;
    }
    
}
