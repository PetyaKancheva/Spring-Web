package com.example.demo.model;

import java.util.List;

public class ListCommentsDTO {
    List<CommentDTO> list;

    public List<CommentDTO> getList() {
        return list;
    }

    public ListCommentsDTO setList(List<CommentDTO> list) {
        this.list = list;
        return this;
    }
}
