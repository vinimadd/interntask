package com.vinimadd.interntask.endpoint;


import com.vinimadd.interntask.model.GithubRepo;
import com.vinimadd.interntask.model.GithubRepositories;
import com.vinimadd.interntask.service.HttpGithubRepoRetriever;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class GithubRepoEndpoint {

    private final HttpGithubRepoRetriever httpGithubRepoRetriever;

    public GithubRepoEndpoint(HttpGithubRepoRetriever httpGithubRepoRetriever) {
        this.httpGithubRepoRetriever = httpGithubRepoRetriever;
    }

    // Create path and fetch data by given username.
    // Return data from Github API.

    @GetMapping(value = "/users/{username}/repos")
    public GithubRepositories githubRepo (@PathVariable("username") String username) {

        GithubRepo[] repositories = httpGithubRepoRetriever.getRepos(username);
        return new GithubRepositories(repositories);

    }

}
