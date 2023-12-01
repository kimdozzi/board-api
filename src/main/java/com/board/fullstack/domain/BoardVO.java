package com.board.fullstack.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL) // not null인 경우만 포함한다는 의미, property가 null이면 만들지 말라는 의미
@Data
public class BoardVO {
    private Integer id;
    private String title;
    private String content;
    private String created;
    private String updated;
}
