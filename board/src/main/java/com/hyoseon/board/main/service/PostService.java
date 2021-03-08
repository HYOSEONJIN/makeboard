package com.hyoseon.board.main.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.hyoseon.board.main.dao.BoardInterfaceDao;
import com.hyoseon.board.main.vo.Board;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    // READ UPDATE DELETE 서비스

    private final Logger logger = LoggerFactory.getLogger(PostService.class);
    private BoardInterfaceDao dao;

    @Autowired private SqlSessionTemplate template;

    // 게시물 읽기
    public Board readPost(int postidx) {

        Board board = null;

        try {
            dao = template.getMapper(BoardInterfaceDao.class);
            board = dao.postByIdx(postidx);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return board;
    }
    

    File newFile = null;
    String postFileName = null;
    String saveDirPath = null;


    // 게시물 수정
    public int updatePost(Board board, HttpServletRequest request) {


        int result = 0;
        boolean photoChk = true;


        dao = template.getMapper(BoardInterfaceDao.class);
        // 비밀번호 확인
        int passwordChk = dao.passchk(board.getPostidx(), board.getPostPassword());
        logger.info("비밀번호확인 Chk"+ passwordChk);

        // 비밀번호가 틀리다면 >>>>>>>>>>>>>> 4
        if(passwordChk!=1){
            result=4;
            return result;
        }


        // 원래파일 이름 받기
        String exFileName = board.getExFileName();
        System.out.println(exFileName);


        // 글 내용이 없을 경우 >>>>>>>>>> 2
        if (board.getPostText().trim().isEmpty()) {
            result = 2;

            return result;
        }

        String fileTypeChk = board.getPostFile().getOriginalFilename();
        String[] arr = fileTypeChk.split("\\.");
        String Type = arr[arr.length-1].toString().toUpperCase();
        logger.info("파일확장자"+Type);


        // 확장자가 사진파일이 아닐경우 >>>>>> 3
        if(!Type.equals("JPG") && !Type.equals("JPEG") && !Type.equals("PNG") && !Type.equals("GIF") && !Type.equals("")){

            result = 3;            
            return result;
        }

        
        // 사진이 정상적인 파일인지 확인하기 
        if (board.getPostFile() != null && !board.getPostFile().isEmpty()) {

          

            String uploadPath = "/fileupload";
            saveDirPath = request
                .getSession()
                .getServletContext()
                .getRealPath(uploadPath);
            // 새로운 파일이름 만들어주기
            postFileName = String.valueOf(System.nanoTime());
            newFile = new File(saveDirPath, postFileName);
        } else {

            // 파일이 없거나 비정상이라면
            photoChk = false;

        }

        // 파일이 있다면 파일 저장하기
        if (photoChk) {
            try {
                board.getPostFile().transferTo(newFile);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }

            // 파일 이름 저장하기
            if (postFileName != null) {
                board.setPostFileName(postFileName);
            }
        }
        




        try {
                     
  
            //DB수정
            result = dao.updatePost(board);                
          

        } catch (Exception e) {
            e.printStackTrace();
        }


        if(result==1 && exFileName!=null ){
            // 원래 있던 파일 삭제하기
            String uploadPath = "/fileupload";
			String DirPath = request.getSession().getServletContext().getRealPath(uploadPath);
            System.out.println(DirPath);
            System.out.println(exFileName);
            File file = new File(DirPath, exFileName);
            if (file.exists()) {
				if (file.delete()) {
					System.out.println("기존 파일 삭제 성공");
				} else {
					System.out.println("기존 파일 삭제 실패");
				}
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
        }

        return result;
    }

    

    // 게시물 삭제

    public int deletePost(int postidx, String postPassword,  HttpServletRequest request){
        int result = 0;

        
        dao = template.getMapper(BoardInterfaceDao.class);
        // 삭제하기 전에 파일명 받아오기 & 비밀번호 확인하기
        int Chk = dao.passChk(postidx, postPassword);

        if(Chk==0){
            // 비밀번호가 틀리면  >>>>>>>>> 2
            result = 2;
            
        }else if(Chk==1){
            // 파일이름 받아오기
            String fileName = dao.getFileName(postidx, postPassword);
            // 글삭제하기  >>>>>>>>>>>>>>>>>>> 삭제하면 1
            result = dao.deletePost(postidx, postPassword);


            //글이 삭제됐고, 파일을 첨부했었다면 삭제해준다.
            if(result==1 && fileName!=null){
                String uploadPath = "/fileupload";
			    String DirPath = request.getSession().getServletContext().getRealPath(uploadPath);
                System.out.println(DirPath);
                System.out.println(fileName);
                File file = new File(DirPath, fileName);
                if (file.exists()) {
				    if (file.delete()) {
					    System.out.println("기존 파일 삭제 성공");
				    } else {
					    System.out.println("기존 파일 삭제 실패");
				    }
			    } else {
				    System.out.println("파일이 존재하지 않습니다.");
			    }

            }
        }


        
        return result;

        
    }

    
}
