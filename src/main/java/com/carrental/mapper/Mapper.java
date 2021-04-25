package com.carrental.mapper;

public interface Mapper<From, To> {
    To map(From from);
}
