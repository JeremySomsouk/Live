package com.tippers.containment.live.mapper;

public interface Mapper<A, T> {

    public A toDto(T model);

    public T toModel(A dto);
}
