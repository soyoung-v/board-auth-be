package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardGetOneReq {
    private long id;
    private String title;
    private String contents;
    private String createdAt;
    private String nm;
    private long userId;

}
