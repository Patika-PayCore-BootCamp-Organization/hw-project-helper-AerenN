package com.helperproject.interestservice.consumer;

import com.helperproject.interestservice.config.MQConfig;
import com.helperproject.interestservice.model.UserLikedMessageEvent;
import com.helperproject.interestservice.service.UserInterestService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLikedMessageEventConsumer {


    @Autowired
    private UserInterestService interestService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(UserLikedMessageEvent message) {
        System.out.println(message.getUsername());
        System.out.println(message.getTag());
        System.out.println(message.getMessageId());
        interestService.saveUserInterest(message.getUsername(),
                message.getTag());

    }
}
