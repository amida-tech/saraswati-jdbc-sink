package com.amida.saraswati.jdbcsink;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amida.saraswati.jdbcsink.model.Output;
import com.amida.saraswati.jdbcsink.sink.repository.OutputObjectRepository;
import com.amida.saraswatijdbcsink.mocks.InputMock;
import com.amida.saraswatijdbcsink.mocks.OutputMock;

@SpringBootTest
class SaraswatiJdbcSinkApplicationTests {

	@Autowired
	private OutputObjectRepository outputObjectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void amIWorking() {
		assertEquals(2, (1 + 1));
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
	public void testInputToOutputConversion() throws Exception {
		// Create Assertions of Mocks for Static Implementation
		InputMock inputMockAssert = new InputMock();
		OutputMock outputMockAssert = new OutputMock();

		// Define Mocks and tests
		Output converter = new Output();
		Output outputMock = outputMockAssert.outputMock();
		Output outputTest = converter.convertInputToOutput(inputMockAssert.inputMock());

		// TODO: rewrites to the converter and model will need to be reflected here.
		// Compare Tests
		assertEquals(outputTest.getLastName(), outputMock.getLastName());
	}

	@Test
	public void testOutputWrite() throws Exception {
		// write the output mock to the test db, read it, then remove it.
		OutputMock outputMockAssert = new OutputMock();
		Output outputMock = outputMockAssert.outputMock();
		outputObjectRepository.save(outputMock);

//		//Pull object back from test DB
		Output returnedObject;
		try {
			returnedObject = outputObjectRepository.findByLastName("Kirk");
			
			//TODO: will need to be updated when the model is improved.
			//Test Equality
			assertEquals(returnedObject.getLastName(), outputMock.getLastName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		//Remove object from test DB.
		outputObjectRepository.delete(outputMock);

	}

}
