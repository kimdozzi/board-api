package com.board.fullstack.domain;

import lombok.Data;

@Data
public class ImageVO {
    private Integer Id;
    private String mimetype;
    private String original_name;
    private byte[] data;
    private String created;
}
