package com.vinimadd.interntask;

import com.vinimadd.interntask.service.HttpGithubRepoRetriever;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class InterntaskApplicationTests {

	HttpGithubRepoRetriever httpGithubRepoRetriever;

	@Test
	void testThrows() {
		assertThrows(Exception.class, () -> {httpGithubRepoRetriever.takeCareWithNotFound();} );
	}



}
