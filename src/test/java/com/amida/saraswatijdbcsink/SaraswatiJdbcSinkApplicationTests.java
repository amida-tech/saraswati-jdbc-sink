package com.amida.saraswatijdbcsink;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaraswatiJdbcSinkApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testInputIngest() {
		//Test input mapping against inputmock.
	}
	
	@Test
	public void testOutputValues() {
		//run input mock through mapper and compare to output mock.
	}
	
	@Test
	public void testOutputWrite() {
		//write the output mock to the test db, read it, then remove it.
	}

}
