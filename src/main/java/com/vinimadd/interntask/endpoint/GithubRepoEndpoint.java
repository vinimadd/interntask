package com.vinimadd.interntask.endpoint;


import com.vinimadd.interntask.model.GithubRepo;
import com.vinimadd.interntask.model.GithubRepositories;
import com.vinimadd.interntask.service.HttpGithubRepoRetriever;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class GithubRepoEndpoint {

    private final HttpGithubRepoRetriever httpGithubRepoRetriever;

    public GithubRepoEndpoint(HttpGithubRepoRetriever httpGithubRepoRetriever) {
        this.httpGithubRepoRetriever = httpGithubRepoRetriever;
    }

    // Create path and fetch data by given username & return data from GitHub API.

    @GetMapping(value = "/users/{username}/repos")

    public GithubRepositories githubRepo(@PathVariable("username") String username) {
        List<GithubRepo> repositories = httpGithubRepoRetriever.getData(username);
        return new GithubRepositories(repositories);
    }
}
