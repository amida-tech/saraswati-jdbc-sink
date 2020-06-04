package com.amida.saraswatijdbcsink.sink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import com.amida.saraswatijdbcsink.converter.InputOutputConverter;
import com.amida.saraswatijdbcsink.model.InputObject;
import com.amida.saraswatijdbcsink.model.OutputObject;
import com.amida.saraswatijdbcsink.sink.repository.OutputObjectRepository;

@EnableBinding(Sink.class)
public class ExampleSink {

	@Autowired
	private OutputObjectRepository outputObjectRepository;

	// specify what type of message you are receiving
	@StreamListener(Sink.INPUT)
	public void process(Message<InputObject> message) {

		// convert payoad.
		// TODO: actually write a real converter and payload data objects.
		OutputObject output = InputOutputConverter.convert(message.getPayload());
		if (output == null) {
			System.out.println(">>>>>>>>>>Error with message conversion");
		}
		else {
			outputObjectRepository.save(output);
		}
	}
}