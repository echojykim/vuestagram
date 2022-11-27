package com.example.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Board {
    //게시판 번호, 제목, 작성자, 내용, 현재시간, 업데이트수정시간
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //요 generateType.Identity로 기본키 생성을 DB에 위임
    // (auto_increment)를 사용해서 기본키 생성
    private Long boardNo;

    @Column(length = 128, nullable = false) //필드&컬럼매핑, nullable=false 설정하면 ddl생성때 not null 제약조건 붙음
    private String title;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob //BLOB(멀티미디어 데이터를 다룰때 사용), CLOB(문자형 대용량 파일저장)를 매핑
    private String content;
    private Date regDate;
    private Date upDate;


}
