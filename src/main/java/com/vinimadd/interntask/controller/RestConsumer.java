package com.vinimadd.interntask.controller;


import com.vinimadd.interntask.model.GetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@RestController
public class RestConsumer {

//    RestTemplate restTemplate;
//
//    public RestConsumer(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    private String username = "vinimadd";
    String resourceUrl = "https://api.github.com/users/"+username+"/repos";

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping
    public String gGet (){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class).getBody();
    }

//    @RequestMapping(value = "/posts")
//    public Post[] getProductList() {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, entity, Post[].class).getBody();
//    }
//
//    @RequestMapping(value = "/posts/delete/{id}")
//    public String deletePost(@PathVariable("id") int id) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.DELETE, entity, String.class).getBody();
//    }

//     if (user.isPresent()) {
//        return new ResponseEntity<>(user.get(), HttpStatus.OK);
//    } else {
//        throw new RecordNotFoundException();
//    }



}
