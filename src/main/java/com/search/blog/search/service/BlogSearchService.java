package com.search.blog.search.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.search.blog.search.resource.SearchHisoryResource;
import com.search.blog.search.resource.SearchInfoResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogSearchService {

    public Page<JSONPObject> getSearchResult(SearchInfoResource searchResource);
    public List<SearchHisoryResource> getPopularKeywords();
}
