package com.amida.saraswatijdbcsink;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;

import com.amida.saraswatijdbcsink.converter.InputOutputConverter;
import com.amida.saraswatijdbcsink.mocks.InputMock;
import com.amida.saraswatijdbcsink.mocks.OutputMock;
import com.amida.saraswatijdbcsink.model.InputObject;
import com.amida.saraswatijdbcsink.model.OutputObject;
import com.amida.saraswatijdbcsink.sink.repository.OutputObjectRepository;

@SpringBootTest
class SaraswatiJdbcSinkApplicationTests {

	@Autowired
	private OutputObjectRepository outputObjectRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void amIWorking() {
		assertEquals(2, (1+1));
	}

	@Test
	public void testInputIngest() throws Exception {
		// Test input mapping against inputmock.
		
		Message<InputObject> message = new Message<InputObject>();
	}

	@Test
	public void testOutputValues() throws Exception {
		// Create Assertions of Mocks for Static Implementation
		InputMock inputMockAssert = new InputMock();
		OutputMock outputMockAssert = new OutputMock();

		// Define Mocks and tests
		OutputObject outputMock = outputMockAssert.outputMock();
		OutputObject outputTest = InputOutputConverter.convert(inputMockAssert.inputMock());

		// TODO: rewrites to the converter and model will need to be reflected here.
		// Compare Tests
		assertEquals(outputTest.getFirstName(), outputMock.getFirstName());
		assertEquals(outputTest.getLastName(), outputMock.getLastName());
		assertEquals(outputTest.getState(), outputMock.getState());
	}

	@Test
	public void testOutputWrite() throws Exception {
		// write the output mock to the test db, read it, then remove it.
		OutputMock outputMockAssert = new OutputMock();
		OutputObject outputMock = outputMockAssert.outputMock();
		outputObjectRepository.save(outputMock);
		
		//Pull object back from test DB
		OutputObject returnedObject;
		try {
			returnedObject = outputObjectRepository.findByFirstName("James");
			
			//TODO: will need to be updated when the model is improved.
			//Test Equality
			assertEquals(returnedObject.getFirstName(), outputMock.getFirstName());
			assertEquals(returnedObject.getLastName(), outputMock.getLastName());
			assertEquals(returnedObject.getState(), outputMock.getState());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Remove object from test DB.
		outputObjectRepository.delete(outputMock);

	}

}
