package com.tippers.containment.live.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String username;
    private String job;
    private Integer age;
}
