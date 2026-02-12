package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public long postBoard( BoardPostReq req){
        boardMapper.save(req);
        return req.getId();
    }

    public List<BoardGetRes> getBoardList(BoardGetReq req){
        return boardMapper.findAll(req);
    }
    public int getMaxPage(BoardMaxCountReq req){
        return boardMapper.maxPage(req);
    }
    public BoardGetOneReq getBoardOne(long id){ return boardMapper.findOne(id);}
    public int delBoard(BoardDelReq req) {
        return boardMapper.delBoard(req);
    }
    public int putBoard( BoardPutReq req){
        return boardMapper.update(req);
    }
}

