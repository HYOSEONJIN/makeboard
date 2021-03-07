package com.hyoseon.board.main.service;

import java.util.List;

import com.hyoseon.board.main.dao.BoardInterfaceDao;
import com.hyoseon.board.main.vo.Board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    // 글 리스트 출력과 관련된 서비스

    private BoardInterfaceDao dao;
    
    @Autowired
    private SqlSessionTemplate template;

    // 전체리스트
    public List<Board> getList() {

        dao = template.getMapper(BoardInterfaceDao.class);



        return dao.getAllList();
    }
    
}
