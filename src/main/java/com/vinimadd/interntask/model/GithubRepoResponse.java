package com.vinimadd.interntask.model;

import java.beans.ConstructorProperties;

public class GithubRepoResponse {

    GithubRepo[] repositories;
    private int stargazersSum;

    @ConstructorProperties({"repositories"})
    public GithubRepoResponse(GithubRepo[] repositories) {
        this.repositories = repositories;
        for (GithubRepo i : repositories) {
            this.stargazersSum += i.getStargazers_count();
        }
    }

    public GithubRepo[] getRepositories() {
        return repositories;
    }

    public int getStargazersSum() {
        return stargazersSum;
    }

}
