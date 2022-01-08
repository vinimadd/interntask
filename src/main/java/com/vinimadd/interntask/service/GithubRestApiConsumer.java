package com.vinimadd.interntask.service;


import com.vinimadd.interntask.model.GithubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class GithubRestApiConsumer {

    @Autowired
    private RestTemplate restTemplate;

    // Fetch required data from Github API: repository name, repository stars

    public GithubRepo[] getRepos (String username) {

        String resourceUrl = "https://api.github.com/users/"+username+"/repos";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, GithubRepo[].class).getBody();

    }

}
