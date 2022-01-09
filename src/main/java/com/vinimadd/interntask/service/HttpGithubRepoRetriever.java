package com.vinimadd.interntask.service;


import com.vinimadd.interntask.model.GithubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpGithubRepoRetriever {

    private final RestTemplate restTemplate;

    @Autowired
    public HttpGithubRepoRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Fetch required data from Github API: repository name, repository stars

    public GithubRepo[] getRepos (String username) {

        String resourceUrl = "/users/"+username+"/repos";
        return restTemplate.getForObject(resourceUrl, GithubRepo[].class);

    }
}
