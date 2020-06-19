package com.amida.saraswati.jdbcsink.sink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import com.amida.saraswati.jdbcsink.model.InputIngest;
import com.amida.saraswati.jdbcsink.model.Output;
import com.amida.saraswati.jdbcsink.sink.repository.OutputObjectRepository;

@EnableBinding(Sink.class)
public class ExampleSink {

	@Autowired
	private OutputObjectRepository outputObjectRepository;

	// specify what type of message you are receiving
	@StreamListener(Sink.INPUT)
	public void process(Message<InputIngest> message) {

		// convert payoad.
		// TODO: actually write a real converter and payload data objects.
		Output converter = new Output();
		Output output;
		try {
			output = converter.convertInputToOutput(message.getPayload());
			if (output == null) {
				System.out.println(">>>>>>>>>>Error with message conversion");
			} else {
				outputObjectRepository.save(output);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}