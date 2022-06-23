package com.vinimadd.interntask.service;

import com.vinimadd.interntask.model.GithubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class HttpGithubRepoRetriever {

    private final RestTemplate restTemplate;

    @Autowired
    public HttpGithubRepoRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Fetch required data from Github API: repository name, repository stars + lang, size

    public List<GithubRepo> getData(String username) {
        String resourceUrl = "/users/" + username + "/repos";

        ResponseEntity<List<GithubRepo>> responseEntity;

//        takeCareWithNotFound(); -> to check if error occurs

        try {
            responseEntity =
                    restTemplate.exchange(
                            resourceUrl,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<GithubRepo>>() {
                            });
            System.out.println("Status Code: " + responseEntity.getStatusCode());
        } catch (Exception globalExceptionHandler) {
            throw globalExceptionHandler;
        }

        return responseEntity.getBody();
    }

    public void takeCareWithNotFound() {
        throw new InvalidParameterException();
    }
}