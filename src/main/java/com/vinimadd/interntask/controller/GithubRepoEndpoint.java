package com.vinimadd.interntask.controller;


import com.vinimadd.interntask.model.GithubRepo;
import com.vinimadd.interntask.model.GithubRepoResponse;
import com.vinimadd.interntask.service.GithubRestApiConsumer;
import org.springframework.web.bind.annotation.*;

@RestController
public class GithubRepoEndpoint {

    private GithubRestApiConsumer githubRestApiConsumer;

    public GithubRepoEndpoint(GithubRestApiConsumer githubRestApiConsumer) {
        this.githubRestApiConsumer = githubRestApiConsumer;
    }

    // Create path and fetch data by given username.
    // Return data from Github API.

    @GetMapping(value = "/user/{username}")
    public GithubRepoResponse githubRepo (@PathVariable("username") String username) {

        GithubRepo[] repositories = githubRestApiConsumer.getRepos(username);
        GithubRepoResponse response = new GithubRepoResponse(repositories);

        return response;

    }

}
