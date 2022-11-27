package com.example.backend.controller;

import com.example.backend.entity.Board;
import com.example.backend.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j //xslf4j 는 또 뭐지 새로 나온듯함
@RestController
@RequestMapping("/backend/board")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService bc;
    //boardService 변수를 bc로 지정함
    //게시판 등록 register 게시판에서 제대로 게시판 출력이 되는지 확인할 것
    //게시판 list의 기본 primary key는 boardNo이므로(기준), 이걸 기준으로 게시판 리스트가 생성되어야함
    //일단 리스트까지 무리없이 해보고 이후단계는 다음에 생각해보자 할 수 있을것임....

    @PostMapping("/register")
    public void BoardRegister (@Validated @RequestBody Board board) {
        //@validated - @valid 차이점
        //검증 항목을 그룹으로 나눠서 검정할 수 있는지 여부. @valid + 그룹 검증까지 가능토록 구현된게 > validated
        //GET으로 접근할 때는 계정의 아이디만 검증하고 POST로 접근할 때는 모든 파라미터를 검증하는 것
        //이를 '요청' 그룹(GET)과 '제출' 그룹(POST)으로 나눠서 검증할 수 있는 것이 Group Validation
    log.info("Register! 제대로 출력이 되는지 확인");

    bc.register(board);
    }

    @GetMapping("/list")
    public Board boardRead (@PathVariable("boardNo") Integer boardNo) {
        log.info("BoardRead! 출력완료");
        return bc.read(boardNo);
    }
}
