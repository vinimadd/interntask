package com.vinimadd.interntask.model;

import java.beans.ConstructorProperties;

public class GithubRepositories {

    // Work on data fetched from Github API - count stars.

    private final GithubRepo[] repositories;
    private final int stargazersSum;

    @ConstructorProperties({"repositories"})
    public GithubRepositories(GithubRepo[] repositories) {
        this.repositories = repositories;
        this.stargazersSum = countStars();
    }

    public GithubRepo[] getRepositories() {
        return repositories;
    }

    public int getStargazersSum() {
        return stargazersSum;
    }

    private int countStars() {
        int stargazersSum = 0;
        for (GithubRepo i : repositories) {
            stargazersSum += i.getStargazers_count();
        }
        return stargazersSum;
    }
}
