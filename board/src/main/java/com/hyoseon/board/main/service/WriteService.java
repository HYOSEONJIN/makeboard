package com.hyoseon.board.main.service;


import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.hyoseon.board.main.dao.BoardInterfaceDao;
import com.hyoseon.board.main.vo.Board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteService {
//글쓰기와 관련된 서비스 

    private BoardInterfaceDao dao;

    @Autowired
    private SqlSessionTemplate template;

    

    File newFile = null;
    String postFileName = null;
    String saveDirPath = null;

    public int writePost(Board board,
    HttpServletRequest request){
        int result=0;
        
        // 글 내용이 없을 경우 >>>>>>>>>> 2
        if(board.getPostText().trim().isEmpty()){
            result = 2;
        }

        // 사진이 정상적인 파일인지 확인하기
        if(board.getPostFile()!=null && !board.getPostFile().isEmpty()){

            String uploadPath = "/fileupload";
			saveDirPath = request.getSession().getServletContext().getRealPath(uploadPath);
			// 새로운 파일이름 만들어주기
			postFileName = String.valueOf(System.nanoTime());
			newFile = new File(saveDirPath, postFileName);
        } else {
			// 정상적인 사진이 없을 경우 >>>>>>>>> 3
			result = 3;
			return result;

		}

        // 파일저장하기
        try{
            board.getPostFile().transferTo(newFile);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 파일 이름 저장하기
        if (postFileName != null) {
			board.setPostFileName(postFileName);
		}

        // DB에 저장하기
        try {
			dao = template.getMapper(BoardInterfaceDao.class);
			//result = dao.post(board);
            result=1;
            // 제대로 저장됐다면 >>>>>>>>>>>>> 1

		} catch (Exception e) {
			e.printStackTrace();
            // 에러나면 파일 삭제
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}
		}

        return result;
    }

    
}
