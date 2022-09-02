package com.racloop.tdd;

import com.racloop.tdd.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TddApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCarTest() throws Exception{
		//arrange

		//act
		ResponseEntity<Car> response = restTemplate.getForEntity("/car/swift", Car.class);
		//assert
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		Assertions.assertThat(response.getBody().getName()).isEqualTo("swift");
		Assertions.assertThat(response.getBody().getType()).isEqualTo("petrol");


	}

}
