package com.search.blog.search.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchInfoResource {

    //검색을 원하는 질의어
    //특정 블로그 글만 검색하고 싶은 경우, 블로그 url과 검색어를 공백(' ') 구분자로 넣을 수 있음	O
    private String query;

    //결과 문서 정렬 방식, accuracy(정확도순) 또는 recency(최신순), 기본 값 accuracy
    private String sort;

    //Integer	결과 페이지 번호, 1~50 사이의 값, 기본 값 1
    private Integer page;

    //Integer	한 페이지에 보여질 문서 수, 1~50 사이의 값, 기본 값 10
    private Integer size;
}
