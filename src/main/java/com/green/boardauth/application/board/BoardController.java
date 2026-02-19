package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.*;
import com.green.boardauth.configuration.model.ResultResponse;
import com.green.boardauth.configuration.model.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResultResponse<?> postBoard(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody BoardPostReq req){
        log.info("통신됐다!!");
        log.info("signedUserId: {}", userPrincipal.getSignedUserId());
        log.info("req: {}", req);
        req.setUserId( userPrincipal.getSignedUserId());
        long id = boardService.postBoard(req);
        String message = id > 0 ? "등록 성공" : "등록 실패";
        return new ResultResponse<>(message, id);
    }

    @GetMapping
    public ResultResponse<?> getBoardList(@ModelAttribute BoardGetReq req){
        log.info("req: {}", req);
        List<BoardGetRes> list = boardService.getBoardList(req);
        return new ResultResponse<>( String.format("%d rows", list.size()), list );
    }

    @GetMapping("/max_page")
    public ResultResponse<?> getBoardMaxPage(@ModelAttribute BoardMaxCountReq req){
        int maxPage = boardService.getMaxPage(req);
        return new ResultResponse<>(String.format("maxPage: %d",maxPage), maxPage);
    }
    @GetMapping("/{id}")
    public BoardGetOneReq getBoard(@PathVariable long id){
        return boardService.getBoardOne(id);
    }

    @DeleteMapping
    public ResultResponse<?> delBoard(@AuthenticationPrincipal UserPrincipal userPrincipal, @ModelAttribute BoardDelReq req){
        req.setSignedUserId( userPrincipal.getSignedUserId());
        log.info("req: {}", req);
        int result = boardService.delBoard(req);
        return new ResultResponse<>( result ==1 ? "삭제 성공" : "삭제 권한이 없습니다.", result);
    }

    @PutMapping
    public ResultResponse<?> putBoard(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody BoardPutReq req){
        req.setSignedUserId( userPrincipal.getSignedUserId());
        long id = boardService.putBoard(req);
        String message = id > 0 ? "수정 성공" : "수정 실패";
        return new ResultResponse<>(message, id);
    }

    @GetMapping("/related_search")
    public ResultResponse<?> getText(@ModelAttribute BoardGetText req){
        log.info("req: {}", req);
        List<BoardGetText> text = boardService.getBoardText(req);
        return new ResultResponse<>( String.format("%d rows", text.size()), text );
    }
}
