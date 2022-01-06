package com.vinimadd.interntask.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRepo {

    private int stargazers;
    private int size;
    private String language;

    public GetRepo(int stargazers, int size, String language) {
        this.stargazers = stargazers;
        this.size = size;
        this.language = language;
    }

    public int getStargazers() {
        return stargazers;
    }

    public int getSize() {
        return size;
    }

    public String getLanguage() {
        return language;
    }

    //import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Data
//    public class Post {
//        @JsonProperty("userId")
//        int userId;
//        @JsonProperty("id")
//        int id;
//        @JsonProperty("title")
//        String title;
//        @JsonProperty("body")
//        String body;
//    }

}
