package com.yuyue_learn.yupicturebackend.model.dto.picture;

import lombok.Data;

import java.util.List;
@Data
public class PictureTagCategory {
    private List<String> tagList;
    private List<String> categoryList;
}
