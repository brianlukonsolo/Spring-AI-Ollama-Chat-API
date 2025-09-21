package com.brianlukonsolo.dto;

import jakarta.validation.constraints.NotBlank;

public record Request(
        @NotBlank(message = "question must not be blank")
        String question
) {

}
