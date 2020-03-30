package com.tippers.containment.live.mapper;

import com.tippers.containment.live.controller.dto.UserDto;
import com.tippers.containment.live.repository.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper implements Mapper<UserDto, UserModel> {

    public final UserDto toDto(UserModel userModel) {

        return UserDto.builder()
                .userId(userModel.getUserId())
                .username(userModel.getUsername())
                .job(userModel.getJob())
                .age(userModel.getAge())
                .build();
    }

    public final UserModel toModel(UserDto userDto) {

        return UserModel.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .job(userDto.getJob())
                .age(userDto.getAge())
                .build();
    }
}
