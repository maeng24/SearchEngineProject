package com.search.blog.common.external;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ExternalSearchApiService {

    @Autowired
    private WebClient webClient;

        public JsonNode callExternalApi(String query, String sort, Integer page, Integer size) {

            AtomicReference<JsonNode> result = null;

            webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("dapi.kakao.com")
                        .path("/v2/search/blog")
                        .queryParam("query", query)
                        .queryParam("sort", sort)
                        .queryParam("size", size)
                        .queryParam("page", page)
                        .build())
                .header("Authorization", ${})
                .retrieve()
                .bodyToMono(JsonNode.class)
                .subscribe(response -> {
                    // API 호출 성공 시 처리 로직
                    result.set(response);
                }, error -> {
                    // API 호출 실패 시 처리 로직
                    System.err.println(error.getMessage());
                }, () -> {
                    // API 호출 완료 시 처리 로직
                    System.out.println("API 호출 완료");
                });

            return result!=null ? result.get() :  null;
    }
}
