package com.epam.spring.homework3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class ClientDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    @NotBlank
    private String secondName;

    @NotNull
    private Date birthdate;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private String email;
}