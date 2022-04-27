package com.vinimadd.interntask.model;

import java.beans.ConstructorProperties;


public class GithubRepo {

    // Prepare fields needed to be fetched from GitHub API.

    private final int stargazers_count;
    private final String name;
    private final String language;
    private final int size;

    @ConstructorProperties({"stargazers_count", "name", "language", "size"})
    public GithubRepo(int stargazers_count, String name, String language, int size) {
        this.stargazers_count = stargazers_count;
        this.name = name;
        this.language = language;
        this.size = size;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public int getSize() {
        return size;
    }
}
