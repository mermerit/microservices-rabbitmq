package com.example.customerservice.Controller;

import com.example.customerservice.configration.CustomerRabbitmqConfig;
import com.example.customerservice.model.CustomerRequest;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {

    @Autowired
    RabbitTemplate template;


    @PostMapping(value = "/customer",
            produces = "application/json",consumes = "application/json")

    public void customerOrderRequest(@RequestBody CustomerRequest customerRequest)

{
    template.convertAndSend(CustomerRabbitmqConfig.EXCHANGE,CustomerRabbitmqConfig.ROUTING_KEYS,customerRequest);
customerRequest.setCustomerCity(customerRequest.getCustomerCity());
}
}
