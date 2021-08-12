package com.example.selectshop.controller;

import com.example.selectshop.dto.ItemDto;
import com.example.selectshop.utils.NaverShopSearch;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"SEARCH REQUEST REST API CONTROLLER"})
@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {
    // 네이버에서 검색 결과 가져오는 Controller
    private final NaverShopSearch naverShopSearch;

    // query parameter 꼭 필요!
    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) {
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}
