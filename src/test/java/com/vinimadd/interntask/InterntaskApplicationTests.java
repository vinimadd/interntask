package com.vinimadd.interntask;

import com.vinimadd.interntask.model.GithubRepo;
import com.vinimadd.interntask.model.GithubRepositories;
import com.vinimadd.interntask.service.HttpGithubRepoRetriever;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class InterntaskApplicationTests {

	HttpGithubRepoRetriever httpGithubRepoRetriever;

	GithubRepositories githubRepositories;

	GithubRepo githubRepo;


	@Test
	void testThrows() {
		assertThrows(Exception.class, () -> { httpGithubRepoRetriever.takeCareWithNotFound(); } );
	}

}
