package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@ToString
@Setter
public class BoardMaxCountReq {
    private String searchText;
    private int size;

    public BoardMaxCountReq(@BindParam("search_text") String searchText, int size) {
        this.searchText = searchText;
        this.size = size;
    }
}
