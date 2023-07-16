package com.search.blog.search.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.search.blog.common.external.ExternalSearchApiService;
import com.search.blog.search.resource.SearchHisoryResource;
import com.search.blog.search.resource.SearchInfoResource;
import com.search.blog.search.service.BlogSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional//(readOnly=true) //데이터베이스 작업이 읽기 전용으로 처리됩니다. 이를 통해 데이터베이스 성능을 향상시킬 수 있고, 동시성 제어를 개선할 수 있습니다.
@RequiredArgsConstructor
public class BlogSearchServiceImpl implements BlogSearchService {

    private final ExternalSearchApiService externalSearchApiService;

    @Override
    public Page<JSONPObject> getSearchResult(SearchInfoResource searchResource) {

        JsonNode searchResult = externalSearchApiService.callExternalApi(searchResource.getQuery(),searchResource.getSort(),searchResource.getPage(),searchResource.getSize());


//        //검색된 문서 수
//        private Integer totalCount;
//
//        //total_count 중 노출 가능 문서 수
//        private Integer pageableCount;
//
//        //	현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음 페이지를 요청할 수 있음
//        private Boolean isEnd;
//
//
//        //검색에 성공했다면 키워드를 parse 하여 테이블에 저장한다.
//
//        // 데이터를 JSON 형식으로 변환
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonData = objectMapper.writeValueAsString(dataList);
//
//        // 페이징 정보를 추가한 응답 생성
//        int totalPages = dataPage.getTotalPages();
//        long totalElements = dataPage.getTotalElements();
//        int currentPage = dataPage.getNumber();
//        int pageSize = dataPage.getSize();
//
//        // 응답 생성
//        Map<String, Object> response = new HashMap<>();
//        response.put("data", jsonData);
//        response.put("totalPages", totalPages);
//        response.put("totalElements", totalElements);
//        response.put("currentPage", currentPage);
//        response.put("pageSize", pageSize);
//
        return null;
    }


    @Override
    public List<SearchHisoryResource> getPopularKeywords() {

        return null;
    }
}
