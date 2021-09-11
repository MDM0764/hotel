package com.mdm.hotel;

import com.mdm.hotel.entities.test;
import com.mdm.hotel.repos.testRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelApplicationTests {

	@Autowired
	private testRepository test;
	@Test
	public void testCreateTest() {
		test t1 = new test();
		t1.setName("Geralt");
		test.save(t1);

	}
}
