package com.amida.saraswati.jdbcsink.sink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import com.amida.saraswati.jdbcsink.model.InputIngest;
import com.amida.saraswati.jdbcsink.model.Patient;
import com.amida.saraswati.jdbcsink.sink.repository.PatientRepository;

@EnableBinding(Sink.class)
public class ExampleSink {

	@Autowired
	private PatientRepository patientRepository;

	// specify what type of message you are receiving
	@StreamListener(Sink.INPUT)
	public void process(Message<InputIngest> message) {

		// convert payoad.
		Patient converter = new Patient();
		Patient output;
		try {
			output = converter.convertInputToPatient(message.getPayload());
			if (output == null) {
				System.out.println(">>>>>>>>>>Error with message conversion");
			} else {
				patientRepository.save(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}