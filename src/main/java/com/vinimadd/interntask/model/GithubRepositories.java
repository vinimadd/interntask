package com.vinimadd.interntask.model;

import java.beans.ConstructorProperties;
import java.util.*;

public class GithubRepositories {

    // Work on data fetched from Github API - count stars.

    private final GithubRepo[] repositories;
    private final int stargazersSum;
    private Map<String, Integer> totalSizeByLanguage = new HashMap<>();


    @ConstructorProperties({"repositories"})
    public GithubRepositories(GithubRepo[] repositories) {
        this.repositories = repositories;
        this.stargazersSum = countStars();
        this.totalSizeByLanguage = sortByValue(calculateTotalSizeByLanguage());
    }

    public GithubRepo[] getRepositories() {
        return repositories;
    }
    public int getStargazersSum() {
        return stargazersSum;
    }
    public Map<String, Integer> getTotalSizeByLanguage() {
        return totalSizeByLanguage;
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

    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(Map<String, Integer> map) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        //Interface Map.Entry<K,V> => The Map.entrySet method returns a collection-view of the map, whose elements are of this class.
        // The only way to obtain a reference to a map entry is from the iterator of this collection-view.

        // Sort the list
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
            //Compares its two arguments for order
            //Parameters => o1 - the first object to be compared / o2 - the second object to be compared.
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
