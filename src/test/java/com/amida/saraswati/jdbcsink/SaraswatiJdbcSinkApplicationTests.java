package com.amida.saraswati.jdbcsink;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amida.saraswati.jdbcsink.model.Patient;
import com.amida.saraswati.jdbcsink.sink.repository.PatientRepository;
import com.amida.saraswatijdbcsink.mocks.InputMock;
import com.amida.saraswatijdbcsink.mocks.PatientMock;

@SpringBootTest
class SaraswatiJdbcSinkApplicationTests {

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void amIWorking() {
		assertEquals(2, (1 + 1));
	}

	@Test
	public void testInputToOutputConversion() throws Exception {
		// Create Assertions of Mocks for Static Implementation
		InputMock inputMockAssert = new InputMock();
		PatientMock outputMockAssert = new PatientMock();

		// Define Mocks and tests
		Patient converter = new Patient();
		Patient outputMock = outputMockAssert.outputMock();
		Patient outputTest = converter.convertInputToPatient(inputMockAssert.inputMock());

		// Compare Tests
		assertEquals(outputTest.getLastName(), outputMock.getLastName());
	}

	@Test
	public void testOutputWrite() throws Exception {
		// write the output mock to the test db, read it, then remove it.
		PatientMock outputMockAssert = new PatientMock();
		Patient outputMock = outputMockAssert.outputMock();
		patientRepository.save(outputMock);
		//Pull object back from test DB
		
		Patient returnedObject;
		try {
			returnedObject = patientRepository.findByLastNameLowercase("kirk");
			
			//Test Equality
			assertEquals(returnedObject.getLastName(), outputMock.getLastName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Remove object from test DB.
		patientRepository.delete(outputMock);

	}

}
