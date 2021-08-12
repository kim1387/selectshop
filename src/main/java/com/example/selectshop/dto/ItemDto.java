package com.example.selectshop.dto;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ItemDto {
    // Product랑 원하는 변수가 달라서 하나 더 만들어주는것임
    // 이건 이제 Naver API 검색 결과를 가져올 떄 씀
    private String title;
    private String link;
    private String image;
    private int lprice;
    
    // 제이슨 결과 바로 쏙쏙 들어갈 수 있도록
    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}
