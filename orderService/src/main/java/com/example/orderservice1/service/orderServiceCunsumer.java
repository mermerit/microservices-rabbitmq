package com.example.orderservice1.service;

import com.example.orderservice1.configation.OrderServiceConfigration;
import com.example.orderservice1.modul.CustomerRequest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class orderServiceCunsumer {

    @RabbitListener(queues = OrderServiceConfigration.QUEUE)
    public void consumerCustomerOrderServiceQueue (CustomerRequest customerRequest){

        System.out.println(customerRequest.getCustomerName());
        System.out.println(customerRequest.getCustomerMobile());
        System.out.println(customerRequest.getCustomerCity());

    }
}
