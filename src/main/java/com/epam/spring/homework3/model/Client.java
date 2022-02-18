package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Client {
    private int id;
    private String firstName;
    private String secondName;
    private Date birthdate;
    private String phone;
    private String email;
    private String password;
}
