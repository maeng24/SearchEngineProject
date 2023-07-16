package com.search.blog.search.resource;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SearchHisoryResource {

    private Long searchHistId;

    private String keyword;

    private String category;

    private LocalDateTime searchDateTime;

    private Long searchCount;
}
