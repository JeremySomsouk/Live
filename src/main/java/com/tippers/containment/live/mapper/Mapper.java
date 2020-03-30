package com.tippers.containment.live.mapper;

import com.tippers.containment.live.controller.dto.UserDto;
import com.tippers.containment.live.repository.model.UserModel;

public interface Mapper<A, T> {

    public A toDto(T model);
    public T toModel(A dto);
}
