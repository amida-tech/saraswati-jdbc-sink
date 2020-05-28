package com.amida.saraswatijdbcsink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import com.amida.saraswatijdbcsink.converter.InputOutputConverter;
import com.amida.sink.model.InputObject;
import com.amida.sink.model.OutputObject;
import com.amida.sink.repository.OutputObjectRepository;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(Sink.class) @Slf4j
public class ExampleSink {

	@Autowired 
	private OutputObjectRepository outputObjectRepository;

    //specify what type of message you are receiveing
    @StreamListener(Sink.INPUT)
    public void process(Message<InputObject> message){

        //convert payoad. 
    	//TODO: actually write a real converter and payload data objects.
        OutputObject output = InputOutputConverter.convert(message.getPayload());
        
        outputObjectRepository.save(output);
    }
}