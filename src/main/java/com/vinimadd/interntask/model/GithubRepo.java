package com.vinimadd.interntask.model;

import java.beans.ConstructorProperties;

public class GithubRepo {


    private int stargazers_count;
    private String name;

    @ConstructorProperties({"stargazers_count", "name"})
    public GithubRepo(int stargazers_count, String name) {
        this.stargazers_count = stargazers_count;
        this.name = name;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public String getName() {
        return name;
    }
}
