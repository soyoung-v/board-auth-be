package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardPutReq {
    private long id;
    private String title;
    private String contents;
    private long signedUserId;
}
