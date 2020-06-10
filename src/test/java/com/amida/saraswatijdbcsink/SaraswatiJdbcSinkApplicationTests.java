package com.amida.saraswatijdbcsink;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;

import com.amida.saraswatijdbcsink.converter.InputOutputConverter;
import com.amida.saraswatijdbcsink.mocks.InputMock;
import com.amida.saraswatijdbcsink.mocks.OutputMock;
import com.amida.saraswatijdbcsink.mocks.PayloadMock;
import com.amida.saraswatijdbcsink.model.InputObjectIngest;
import com.amida.saraswatijdbcsink.model.OutputObject;
import com.amida.saraswatijdbcsink.sink.repository.OutputObjectRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class SaraswatiJdbcSinkApplicationTests {

//	@Autowired
//	private OutputObjectRepository outputObjectRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void amIWorking() {
		assertEquals(2, (1+1));
	}

//	@Test
//	public void testInputIngest() throws Exception {
//		// Test input mapping against inputmock.
//		
//		//TODO: Needs to be finished after the model is updated.
//		PayloadMock payloadMock = new PayloadMock();
//		
//		ObjectMapper payloadMockMapper = new ObjectMapper();
//		
//		InputStream payloadInputStream = 
//				TypeReference.class.getResourceAsStream("/payloadMock.json");
//		
//		payloadMock.setPayload("");
//	}
//
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
	}
//
//	@Test
//	public void testOutputWrite() throws Exception {
//		// write the output mock to the test db, read it, then remove it.
//		OutputMock outputMockAssert = new OutputMock();
//		OutputObject outputMock = outputMockAssert.outputMock();
//		outputObjectRepository.save(outputMock);
//		
//		//Pull object back from test DB
//		OutputObject returnedObject;
//		try {
//			returnedObject = outputObjectRepository.findByFirstName("James");
//			
//			//TODO: will need to be updated when the model is improved.
//			//Test Equality
//			assertEquals(returnedObject.getFirstName(), outputMock.getFirstName());
//			assertEquals(returnedObject.getLastName(), outputMock.getLastName());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Remove object from test DB.
//		outputObjectRepository.delete(outputMock);
//
//	}

}
