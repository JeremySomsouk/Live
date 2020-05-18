package com.tippers.containment.live.mapper;

import com.tippers.containment.live.controller.dto.UserDto;
import com.tippers.containment.live.repository.model.postgres.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper implements Mapper<UserDto, Users> {

    public final UserDto toDto(Users user) {

        return UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .job(user.getJob())
                .age(user.getAge())
                .build();
    }

    public final Users toModel(UserDto userDto) {

        return Users.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .job(userDto.getJob())
                .age(userDto.getAge())
                .build();
    }
}
