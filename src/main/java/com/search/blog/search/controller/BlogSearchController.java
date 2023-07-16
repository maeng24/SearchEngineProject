package com.search.blog.search.controller;

import com.search.blog.search.resource.SearchHisoryResource;
import com.search.blog.search.resource.SearchInfoResource;
import com.search.blog.search.service.BlogSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@Api(tags="카카오 api를 사용한 블로그 검")
@RequestMapping("/search/blog")
public class BlogSearchController {

    private final BlogSearchService blogSearchService;

    @ApiOperation(value="조회",notes="조회한다.")
    @PostMapping("")
    public void searchBlog(@RequestBody SearchInfoResource searchResource){
        blogSearchService.getSearchResult(searchResource);
    };

    @GetMapping("/")
    public List<SearchHisoryResource> searchPopularKeywords(){
        return blogSearchService.getPopularKeywords();
    };

}
