package com.vinimadd.interntask.model;

import lombok.Data;

@Data
public class GithubRepo {

    // Prepare fields needed to be fetched from GitHub API.

    private final int stargazers_count;
    private final String name;
    private final String language;
    private final int size;

}
