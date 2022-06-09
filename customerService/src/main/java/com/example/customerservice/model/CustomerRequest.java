package com.example.customerservice.model;


import lombok.Data;



@Data
public class CustomerRequest {
    private String customerName;
    private String customerCity;
    private String customerMobile;
}
