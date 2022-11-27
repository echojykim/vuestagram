package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository br;

    //11-07 현재 BoardRepository에서 CrudRepository가 extends 확장(Repository 확장행위)을 통해 상속되어 인식이 되었어야 했는데 인식이 되지 않는 사태가 발생
    //아무래도 해당 CrudRepository가 상속이 안된것같기도 한데 이유를 모르겠음.
    //해결했다.... extends Repository가 아니라 그보다 상위개념인 JpaRepository를 extends해야했던것임 (해결완료)
    //공부링크: https://blog.naver.com/writer0713/221587319282

    @Override
    public void register(Board board) { br.save(board); }

    @Override
    public List<Board> list() { return br.findAll(Sort.by(Sort.Direction.DESC, "boardNo")); }

    @Override
    public Board read(Integer boardNo) {
        Optional<Board> maybeReadBoard = br.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("게시판을 읽을 수 없습니다!");
            return null;
        }

        return maybeReadBoard.get();
    }


}
