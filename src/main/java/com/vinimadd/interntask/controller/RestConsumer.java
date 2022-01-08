package com.vinimadd.interntask.controller;


import com.vinimadd.interntask.model.GetRepo;
import com.vinimadd.interntask.model.GithubRepo;
import com.vinimadd.interntask.model.GithubRepoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.lang.reflect.Array;
import java.util.*;

@RestController
public class RestConsumer {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/user/{username}")
    public GithubRepoResponse githubRepo(@PathVariable("username") String username){

        GithubRepo[] repositories;
        String resourceUrl = "https://api.github.com/users/"+username+"/repos";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);

        repositories = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, GithubRepo[].class).getBody();

        GithubRepoResponse response = new GithubRepoResponse(repositories);

        return response;

    }

}
