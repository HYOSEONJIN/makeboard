package com.hyoseon.board.main.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Board {


    int postidx;             //글번호
    String postWriter;       //글쓴이
    String postPassword;     //비밀번호
    String postTitle;        //글제목
    String postText;         //글내용
    String postFileName;     //첨부파일이름
    MultipartFile postFile;  //첨부파일
    String regDate;          //글 등록시간


    
}
