package com.vinimadd.interntask.model;

import lombok.Data;

import java.beans.ConstructorProperties;
import java.util.*;

@Data
public class GithubRepositories {

    // Work on data fetched from GitHub API - count stars.

    private  List<GithubRepo> repositories = new ArrayList<>();
    private final int stargazersSum;
    private Map<String, Integer> totalSizeByLanguage = new HashMap<>();


    @ConstructorProperties({"repositories"})

    public GithubRepositories(List<GithubRepo> repositories) {
        this.repositories = repositories;
        this.stargazersSum = countStars();
        this.totalSizeByLanguage = sortByValue(calculateTotalSizeByLanguage());
    }

    private int countStars() {
        int stargazersSum = 0;
        for (GithubRepo repo  : repositories) {
            stargazersSum += repo.getStargazers_count();
        }
        return stargazersSum;
    }

    private Map<String, Integer> calculateTotalSizeByLanguage() {

        Map<String, Integer> totalSizeByLanguage = new HashMap<>();

        for (GithubRepo lang : repositories) {
            String language = lang.getLanguage();
            int size = lang.getSize();

            if (totalSizeByLanguage.containsKey(language)) {
                int totalSize = totalSizeByLanguage.get(language);
                totalSize += size;
                totalSizeByLanguage.replace(language, totalSize);
            }

            if (language != null && !totalSizeByLanguage.containsKey(language)) {
                totalSizeByLanguage.put(language,size);
            }


        } return totalSizeByLanguage;
    }

    // Function to sort hashmap by values -> desc order
    public static HashMap<String, Integer> sortByValue(Map<String, Integer> map) {

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}