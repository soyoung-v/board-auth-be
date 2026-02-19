package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardGetText {
    private String title;
    private String searchText;

    public void setSearch_text(String searchText) {
        this.searchText = searchText;
    }
}
