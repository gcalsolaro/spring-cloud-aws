package com.gcalsolaro.cloud.aws.sns.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
@RequestMapping(value = "/aws/sns")
public class SNSController {

	private static String topicName;

	@Autowired
	private AmazonSNS amazonSNS;

	@Autowired
	private SNSMessageSender snsMessageSender;

	@GetMapping(value = "/create")
//	@PostMapping(value = "/create")
	public String createTopic() {
		topicName = UUID.randomUUID().toString();
		CreateTopicResult result = amazonSNS.createTopic(topicName);
		String topicArn = result.getTopicArn();
		return topicArn;
	}

	@GetMapping(value = "/subscribe/{topicArn}/{email}")
//	@PostMapping(value = "/subscribe/{topicArn}/{email}")
	public void subscribe(@PathVariable("topicArn") String topicArn, @PathVariable("email") String email) {
		SubscribeRequest subscribeRequest = new SubscribeRequest(topicArn, "email", email);
		amazonSNS.subscribe(subscribeRequest);
	}

	@GetMapping(value = "/send/{topicArn}")
//	@PostMapping(value = "/send/{topicArn}")
	public void sendMessage(@PathVariable("topicArn") String topicArn) {
		String subject = "Test Message";
		String message = "Hello World";
		snsMessageSender.send(topicArn, message, subject);
	}

	@GetMapping(value = "/delete/{topicArn}")
//	@DeleteMapping(value = "/delete")
	public void deleteTopic(@PathVariable("topicArn") String topicArn) {
		amazonSNS.deleteTopic(topicArn);
	}

}
